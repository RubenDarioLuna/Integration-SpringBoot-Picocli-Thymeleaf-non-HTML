package com.lunaru.democli.logic.commands.subcommds;

import com.lunaru.democli.common.exceptions.SendMailException;
import com.lunaru.democli.service.contracts.IMailService;
import com.lunaru.democli.common.entities.Mail;
import com.lunaru.democli.logic.commands.MainCommand;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Callable;

import picocli.CommandLine;

@Component
@CommandLine.Command( name = "sendMail" )
public class SubCommandSendMail extends BaseSubCommand implements Callable<Integer>
{
    @CommandLine.ParentCommand
    private MainCommand parent;

    //Without @Autowired
    private IMailService _mailService;
    private TemplateEngine _textTemplateEngine;
    private Context _contextTemplateEngine;
    private Mail _mail;

    @CommandLine.Option( names = "--to", description = "email(s) of recipient(s). Separate the emails with a comma",
                         required = true, split = "," )
    String[] _to = {};

    @CommandLine.Option( names = { "--subject", "-s" }, defaultValue = "Test Mail", description = "Subject" )
    String _subject;

    @CommandLine.Option( names = {"-b", "--body"}, defaultValue = "Hi, this is a test mail with Spring Boot + picocli",
            description = "Message to be sent" )
    String _body;

    @CommandLine.Option( names = { "-f", "--file" }, description = "the archive file" )
    File _file = null;


    public SubCommandSendMail( IMailService mailService, Environment properties, TemplateEngine textTemplateEngine,
                               Context contextTemplateEngine, Mail mail ) {
        //Autowiring
        _mailService = mailService;
        _properties = properties;
        _textTemplateEngine = textTemplateEngine;
        _contextTemplateEngine = contextTemplateEngine;
        _mail = mail;

        _printMessage = "";
        _ok = false;
    }

    @Override
    public Integer call() throws Exception
    {
        fillMailData();
        try
        {
            _mailService.sendMessage( _mail );

            _printMessage = String.format( _properties.getProperty( "message.mailSent" ),
                                           Arrays.toString( _mail.getTo() ), _mail.getSubject(), _mail.getBody() );
            printMessage();

            _ok = true;

            /*LOGGER.info( _properties.getProperty( "logger.mailSent" ), mail.getTo(), mail.getSubject(),
                         mail.getBody() );*/
        }
        catch ( SendMailException e)
        {
            //LOGGER.error( _properties.getProperty( "printMessage.mailNotSent" ), e );
            _printMessage = e.getMessage();
            printErrorMessage();
        }
        catch ( Exception e )
        {
            //LOGGER.error( _properties.getProperty( "printMessage.general" ), e );
            _printMessage = _properties.getProperty( "error.general" );
            printErrorMessage();
        }

        return _ok ? 0 : 1;
    }

    private void fillMailData()
    {
        _mail.setTo( _to );
        _mail.setSubject( _subject );
        _mail.setBody( createBody( _body ) );
        _mail.setFile( _file );
    }

    private String createBody( String body )
    {
        _contextTemplateEngine.setVariable( "name", "Developer" );
        _contextTemplateEngine.setVariable( "body", body );
        _contextTemplateEngine.setVariable( "tags", "#framework #java #spring #picocli #thymeleaf".split(" "));

        String text = _textTemplateEngine.process("MailTest", _contextTemplateEngine);

        return text;
    }
}

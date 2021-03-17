package com.lunaru.democli.logic.commands.subcommds;

import com.lunaru.democli.common.exceptions.SendMailException;
import com.lunaru.democli.common.utilities.Properties;
import com.lunaru.democli.service.contracts.IMailService;
import com.lunaru.democli.common.entities.Mail;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.util.Arrays;

import picocli.CommandLine;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/1/2021
 */
@Component
@CommandLine.Command( name = "sendMail",
                      version = {
                              "@|green,bg(white) Send mail v1.0.0|@",
                              "@|green,bg(white) Picocli: " + picocli.CommandLine.VERSION + "|@",
                              "@|red,bg(white) JVM: ${java.version} (${java.vendor} ${java.vm.name} ${java.vm.version})|@",
                              "@|red,bg(white) OS: ${os.name} ${os.version} ${os.arch}|@",
                              "@|black,bg(white) (c) 2021|@"},
                      header = "%n@|green,bg(white) Command send mail|@",
                      description = "This command sends an mail to different destinations!.%n",
                      mixinStandardHelpOptions = true )
//The mixinStandardHelpOptions attribute adds --help and --version options
public class SubCommandSendMail extends BaseSubCommand implements Runnable
{
    //#region Privates Attributes
    private IMailService _mailService;
    private TemplateEngine _textTemplateEngine;
    private Context _contextTemplateEngine;
    private Mail _mail;
    //#endregion

    //#region Options/Parameters
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
    //#endregion

    //#region Constructors
    /**
     * Class constructor.
     * @param mailService
     * @param textTemplateEngine
     * @param contextTemplateEngine
     * @param mail
     */
    public SubCommandSendMail( IMailService mailService, TemplateEngine textTemplateEngine,
                               Context contextTemplateEngine, Mail mail )
    {
        super();

        //Autowiring
        _mailService = mailService;
        _textTemplateEngine = textTemplateEngine;
        _contextTemplateEngine = contextTemplateEngine;
        _mail = mail;
    }
    //#endregion

    //#region Public Methods
    @Override
    public void run()
    {
        try
        {
            fillMailData();
            _mailService.sendMessage( _mail );

            _printMessage = String.format( Properties.getProperty( "message.mailSent" ),
                                           Arrays.toString( _mail.getTo() ), _mail.getSubject(), _mail.getBody() );
            printCorrectMessage();
        }
        catch ( SendMailException e)
        {
            _printMessage = e.getMessage();
            printErrorMessage( e.getMessage() );
        }
        catch ( Exception e )
        {
            _printMessage = Properties.getProperty( "error.general" );
            printErrorMessage( e.getMessage() );
        }
    }
    //#endregion

    //#region Privates Methods
    private void fillMailData()
    {
        _mail.setTo( _to );
        _mail.setSubject( _subject );
        _mail.setBody( createBody( _body ) );
        _mail.setFile( _file );
    }

    private String createBody( String body )
    {
        _contextTemplateEngine.setVariable( Properties.getProperty( "template.mail.name" ),
                                            Properties.getProperty( "defaultValue.mail.name" ) );

        _contextTemplateEngine.setVariable( Properties.getProperty( "template.mail.body" ), body );

        _contextTemplateEngine.setVariable( Properties.getProperty( "template.mail.tags" ),
                                            splitStringBy( Properties.getProperty( "defaultValue.mail.tags" ),
                                                           Properties.getProperty( "template.mail.tags.regex" ) ) );

        String text = _textTemplateEngine.process("MailTest", _contextTemplateEngine);

        return text;
    }
    //#endregion
}

package com.lunaru.democli.commands;

import com.lunaru.democli.services.IMailService;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine;

@Component
@CommandLine.Command( name = "mailCommand" )
public class MailCommand implements Callable<Integer>
{
    private final IMailService _mailService; //Example is with Autowired
    private TemplateEngine _textTemplateEngine;

    @CommandLine.Option( names = "--to", description = "email(s) of recipient(s)", required = true )
    List<String> _to;

    @CommandLine.Option( names = "--subject", description = "Subject" )
    String _subject;

    @CommandLine.Parameters( description = "Message to be sent" )
    String[] _body = {};

    public MailCommand( IMailService mailService, TemplateEngine textTemplateEngine ) {
        this._mailService = mailService;
        this._textTemplateEngine = textTemplateEngine;
    }

    public Integer call() throws Exception
    {
        _mailService.sendMessage( _to, _subject, createBody( String.join( " ", _body ) ) );
        return 0;
    }

    private String createBody( String body )
    {
        Context context = new Context();
        context.setVariable( "name", "Developer" );
        context.setVariable( "body", body );
        context.setVariable( "tags", "#framework #java #spring #picocli #thymeleaf".split(" "));

        String text = _textTemplateEngine.process("MailTest", context);

        return text;
    }
}

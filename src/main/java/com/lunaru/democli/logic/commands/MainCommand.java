package com.lunaru.democli.logic.commands;

import com.lunaru.democli.logic.commands.subcommds.SubCommandSendMail;

import org.springframework.stereotype.Component;

import picocli.CommandLine;

@Component
@CommandLine.Command( name = "mainCommand",
                      version = {
                      "@|green,bg(white) Spring-picocli Demo v1.0.0|@",
                      "@|green,bg(white) Picocli: " + picocli.CommandLine.VERSION + "|@",
                      "@|red,bg(white) JVM: ${java.version} (${java.vendor} ${java.vm.name} ${java.vm.version})|@",
                      "@|red,bg(white) OS: ${os.name} ${os.version} ${os.arch}|@",
                      "@|black,bg(white) (c) 2020|@"},
                      header = "%n@|green,bg(white) Cli Application with Spring Boot, picocli and Thymeleaf|@",
                      description = "Basic example of a Cli application using Spring boot, picocli and Thymeleaf.%n",
                      subcommands = SubCommandSendMail.class,
                      mixinStandardHelpOptions = true )
//The mixinStandardHelpOptions attribute adds --help and --version options
public class MainCommand //implements Runnable
{
    /*@CommandLine.Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run()
    {
    }*/
    /*
    private final IMailService _mailService; //Example is with Autowired
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


    public MainCommand( IMailService mailService, TemplateEngine textTemplateEngine, Context contextTemplateEngine,
                        Mail mail ) {
        _mailService = mailService;
        _textTemplateEngine = textTemplateEngine;
        _contextTemplateEngine = contextTemplateEngine;
        _mail = mail;
    }

    public Integer call() throws Exception
    {
        fillMailData();
        _mailService.sendMessage( _mail );
        return 0;
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
    }*/
}

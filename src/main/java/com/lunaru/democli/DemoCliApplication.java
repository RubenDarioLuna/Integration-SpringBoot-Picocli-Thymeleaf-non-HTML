package com.lunaru.democli;

import com.lunaru.democli.logic.commands.subcommds.SubCommandSendMail;
import com.lunaru.democli.logic.commands.MainCommand;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import picocli.CommandLine;

@SpringBootApplication
public class DemoCliApplication implements CommandLineRunner, ExitCodeGenerator
{
    private CommandLine.IFactory _factory;
    private MainCommand _mainCommand;
    private SubCommandSendMail _subCommandSendMail;
    private int _exitCode;

    public DemoCliApplication( CommandLine.IFactory factory, MainCommand mainCommand, SubCommandSendMail subCommandSendMail )
    {
        this._factory = factory;
        this._mainCommand = mainCommand;
        this._subCommandSendMail = subCommandSendMail;
    }

    @Override
    public void run(String... args)
    {
        CommandLine commandLine = new CommandLine( _mainCommand, _factory );
        _exitCode = commandLine.execute( args );
    }


    @Override
    public int getExitCode()
    {
        return _exitCode;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoCliApplication.class, args);
    }
}

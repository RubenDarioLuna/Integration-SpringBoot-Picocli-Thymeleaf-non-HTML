package com.lunaru.democli;

import com.lunaru.democli.commands.MailCommand;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import picocli.CommandLine;

@SpringBootApplication
public class DemoCliApplication implements CommandLineRunner, ExitCodeGenerator
{
    private CommandLine.IFactory _factory;
    private MailCommand _mailCommand;
    private int _exitCode;

    public DemoCliApplication( CommandLine.IFactory factory, MailCommand mailCommand )
    {
        this._factory = factory;
        this._mailCommand = mailCommand;
    }

    @Override
    public void run(String... args) throws Exception
    {
        _exitCode = new CommandLine( _mailCommand, _factory ).execute(args);
    }

    @Override
    public int getExitCode()
    {
        return 0;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoCliApplication.class, args);
    }
}

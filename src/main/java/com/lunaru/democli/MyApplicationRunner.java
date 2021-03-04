package com.lunaru.democli;

import com.lunaru.democli.logic.commands.MainCommand;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import picocli.CommandLine;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/1/2021
 */
@Component
public class MyApplicationRunner implements CommandLineRunner, ExitCodeGenerator
{
    // auto-configured to inject PicocliSpringFactory
    private final CommandLine.IFactory _factory;
    private final MainCommand _mainCommand;
    private int _exitCode;

    /**
     * Class constructor.
     * @param factory
     * @param mainCommand
     */
    public MyApplicationRunner( CommandLine.IFactory factory, MainCommand mainCommand )
    {
        this._factory = factory;
        this._mainCommand = mainCommand;
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
}

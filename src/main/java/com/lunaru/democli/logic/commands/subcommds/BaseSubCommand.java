package com.lunaru.democli.logic.commands.subcommds;

import org.springframework.core.env.Environment;

import java.util.Arrays;

import picocli.CommandLine;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/1/2021
 */
public abstract class BaseSubCommand
{
    protected Environment _properties;

    protected String _printMessage;
    protected boolean _ok;

    /**
     * Class constructor.
     */
    public BaseSubCommand()
    {
        super();
    }

    protected void printMessage(  )
    {
        _printMessage = String.format( CommandLine.Help.Ansi.AUTO.string(
                _properties.getProperty( "printTemplateMessage.correct" ) ), _printMessage );
        System.out.println( _printMessage );
    }

    protected void printErrorMessage(  )
    {
        _printMessage = String.format( CommandLine.Help.Ansi.AUTO.string(
                _properties.getProperty( "printTemplateMessage.error" ) ), _printMessage );
        System.out.println( _printMessage );
    }
}

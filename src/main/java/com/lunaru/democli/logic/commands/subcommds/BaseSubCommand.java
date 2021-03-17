package com.lunaru.democli.logic.commands.subcommds;

import com.lunaru.democli.common.utilities.Properties;
import com.lunaru.democli.logic.commands.MainCommand;
import com.lunaru.democli.service.implementation.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    //#region Protected Parameters
    @CommandLine.ParentCommand
    protected MainCommand _parent;
    protected String _printMessage;
    //#endregion

    //#region Constructors
    /**
     * Class constructor.
     */
    public BaseSubCommand()
    {
        this._printMessage = "";
    }
    //#endregion

    //#region Protected Methods
    protected void printMessage()
    {
        System.out.println( _printMessage );
    }

    protected void printCorrectMessage(  )
    {
        _printMessage = String.format( CommandLine.Help.Ansi.AUTO.string(
                Properties.getProperty( "printTemplateMessage.correct" ) ), _printMessage );
        System.out.println( _printMessage );
    }

    protected void printErrorMessage(  )
    {
        _printMessage = String.format( CommandLine.Help.Ansi.AUTO.string(
                Properties.getProperty( "printTemplateMessage.error" ) ), _printMessage );
        System.out.println( _printMessage );
    }

    protected void printErrorMessage( String errorMessage )
    {
        _printMessage = String.format( CommandLine.Help.Ansi.AUTO.string(
                Properties.getProperty( "printTemplateMessage.error" ) ), _printMessage );
        System.out.println( _printMessage + errorMessage );
    }

    public void printResults(Process process) throws IOException
    {
        BufferedReader reader = new BufferedReader( new InputStreamReader( process.getInputStream() ) );

        while ( ( _printMessage = reader.readLine() ) != null )
        {
            System.out.println( _printMessage );
        }
    }

    protected String[] splitStringBy( String string, String regex )
    {
        String[] result = string.split( regex );
        return result;
    }
    //#endregion Region
}

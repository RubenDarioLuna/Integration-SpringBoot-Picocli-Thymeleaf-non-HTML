package com.lunaru.democli.logic.commands.subcommds;

import com.lunaru.democli.common.utilities.Properties;
import com.lunaru.democli.logic.commands.MainCommand;
import com.lunaru.democli.service.implementation.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    //#region Protected Static Attributes
    protected static final Logger LOGGER = LoggerFactory.getLogger( MailService.class );
    //#endregion

    //#region Protected Parameters
    @CommandLine.ParentCommand
    protected MainCommand _parent;
    protected String _printMessage;
    protected boolean _ok;
    //#endregion

    //#region Constructors
    /**
     * Class constructor.
     */
    public BaseSubCommand()
    {
        this._printMessage = "";
        this._ok = false;
    }
    //#endregion

    //#region Protected Methods
    protected void printMessage(  )
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

    protected String[] splitStringBy( String string, String regex )
    {
        String[] result = string.split( regex );
        return result;
    }
    //#endregion Region
}

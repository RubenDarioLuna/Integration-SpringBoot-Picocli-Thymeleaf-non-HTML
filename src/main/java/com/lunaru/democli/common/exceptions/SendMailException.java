package com.lunaru.democli.common.exceptions;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 2/28/2021
 */
public class SendMailException extends DemoCliCustomException
{
    //#region Constructs
    /**
     * Class constructor.
     */
    public SendMailException(){}

    /**
     * Class constructor.
     * @param errorMessage
     */
    public SendMailException( String errorMessage )
    {
        super( errorMessage );
    }

    /**
     * Class constructor.
     * @param error
     */
    public SendMailException ( Exception error )
    {
        super( error );
    }

    /**
     * Class constructor.
     * @param errorMessage
     * @param error
     */
    public SendMailException( String errorMessage, Exception error )
    {
        super( errorMessage, error );
    }
    //#endregion
}

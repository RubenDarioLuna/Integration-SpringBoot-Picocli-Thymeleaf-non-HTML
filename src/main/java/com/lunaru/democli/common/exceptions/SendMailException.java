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
    /**
     * Class constructor.
     */
    public SendMailException(){}

    public SendMailException( String errorMessage )
    {
        super( errorMessage );
    }

    public SendMailException ( Exception error )
    {
        super( error );
    }

    public SendMailException( String errorMessage, Exception error )
    {
        super( errorMessage, error );
    }
}

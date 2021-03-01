package com.lunaru.democli.common.exceptions;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/1/2021
 */
public class GenericException extends DemoCliCustomException
{
    public GenericException(){}

    public GenericException( String errorMessage )
    {
        super( errorMessage );
    }

    public GenericException ( Exception error )
    {
        super( error );
    }

    public GenericException( String errorMessage, Exception error )
    {
        super( errorMessage, error );
    }
}

package com.lunaru.democli.common.exceptions;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 2/28/2021
 */
public abstract class DemoCliCustomException extends Exception
{
    /**
     * Class constructor.
     */
    public DemoCliCustomException() {}

    public DemoCliCustomException( String errorMessage )
    {
        super( errorMessage );
    }

    public DemoCliCustomException( Throwable cause )
    {
        super( cause );
    }

    public DemoCliCustomException( String errorMessage, Throwable cause )
    {
        super( errorMessage, cause );
    }
}

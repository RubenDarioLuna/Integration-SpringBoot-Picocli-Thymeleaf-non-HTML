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
    //#region Constructors
    /**
     * Class constructor.
     */
    public DemoCliCustomException() {}

    /**
     * Class constructor.
     * @param errorMessage
     */
    public DemoCliCustomException( String errorMessage )
    {
        super( errorMessage );
    }

    /**
     * Class constructor.
     * @param cause
     */
    public DemoCliCustomException( Throwable cause )
    {
        super( cause );
    }

    /**
     * Class constructor.
     * @param errorMessage
     * @param cause
     */
    public DemoCliCustomException( String errorMessage, Throwable cause )
    {
        super( errorMessage, cause );
    }
    //#endregion
}

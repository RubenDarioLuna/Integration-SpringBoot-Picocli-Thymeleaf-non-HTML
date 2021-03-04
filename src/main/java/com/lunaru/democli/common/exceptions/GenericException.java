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
    //#region Constructs
    /**
     * Class constructor.
     */
    public GenericException(){}

    /**
     * Class constructor.
     * @param errorMessage
     */
    public GenericException( String errorMessage )
    {
        super( errorMessage );
    }

    /**
     * Class constructor.
     * @param error
     */
    public GenericException ( Exception error )
    {
        super( error );
    }

    /**
     * Class constructor.
     * @param errorMessage
     * @param error
     */
    public GenericException( String errorMessage, Exception error )
    {
        super( errorMessage, error );
    }
    //#endregion
}

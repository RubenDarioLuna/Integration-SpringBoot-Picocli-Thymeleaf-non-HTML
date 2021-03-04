package com.lunaru.democli.common.utilities;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/3/2021
 */
@Component
public class Properties
{
    //#region Privates Attributes
    private static Environment _properties;
    //#endregion

    //#region Constructs
    /**
     * Class constructor.
     * @param properties
     */
    public Properties( Environment properties )
    {
        this._properties = properties;
    }
    //endregion

    //#region Public Static Methods
    public static String getProperty( String nameProperty )
    {
        return _properties.getProperty( nameProperty );
    }
    //#endregion
}

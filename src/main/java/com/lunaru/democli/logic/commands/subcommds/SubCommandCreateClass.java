package com.lunaru.democli.logic.commands.subcommds;

import org.springframework.core.env.Environment;

import java.util.concurrent.Callable;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 2/21/2021
 */
public class SubCommandCreateClass extends BaseSubCommand implements Callable<Integer>
{
    //#region Privates Attributes

    //#endregion

    //#region Options/Parameters

    //#endregion

    //#region Constructors
    /**
     * Class constructor.
     */
    public SubCommandCreateClass()
    {
    }
    //#endregion

    //#region Public Methods
    @Override
    public Integer call()
    {
        return 0;
    }
    //#endregion

    //#region Privates Methods

    //#endregion
}

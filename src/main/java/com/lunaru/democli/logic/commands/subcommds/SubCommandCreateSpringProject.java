package com.lunaru.democli.logic.commands.subcommds;

import com.lunaru.democli.common.utilities.Properties;

import org.springframework.stereotype.Component;

import java.io.File;

import picocli.CommandLine;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/5/2021
 */
@Component
@CommandLine.Command( name = "createSpringProject",
        version = {
                "@|green,bg(white) Create Spring Project v1.0.0|@",
                "@|green,bg(white) Picocli: " + picocli.CommandLine.VERSION + "|@",
                "@|red,bg(white) JVM: ${java.version} (${java.vendor} ${java.vm.name} ${java.vm.version})|@",
                "@|red,bg(white) OS: ${os.name} ${os.version} ${os.arch}|@",
                "@|black,bg(white) (c) 2021|@"},
        header = "%n@|green,bg(white) Command create Spring project|@",
        description = "This command create projects with Spring Framework!.%n",
        mixinStandardHelpOptions = true )
//The mixinStandardHelpOptions attribute adds --help and --version options
public class SubCommandCreateSpringProject extends BaseSubCommand implements Runnable
{
    //#region Privates Attributes
    private String _commandExec;
    private String _path;
    private File _location;
    //#endregion

    //#region Constructors
    /**
     * Class constructor.
     */
    public SubCommandCreateSpringProject()
    {
        super();
        this._commandExec = Properties.getProperty( "default.complete.command" );
        this._path = Properties.getProperty( "default.generation.location" );
        this._location = new File( _path );
    }
    //#endregion

    //#region Public Methods
    @Override
    public void run()
    {
        try
        {
            Process process = Runtime.getRuntime().exec( _commandExec, null, _location);
            printResults(process);

            this._printMessage = String.format( Properties.getProperty( "message.generated.project" ),
                                                Properties.getProperty( "default.name" ),
                                                _path );

            printCorrectMessage();
        }
        catch ( Exception e )
        {
            _printMessage = Properties.getProperty( "error.general" );
            printErrorMessage( e.getMessage() );
        }
    }
    //#endregion
}

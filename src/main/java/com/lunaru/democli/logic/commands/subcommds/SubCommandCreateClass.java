package com.lunaru.democli.logic.commands.subcommds;

import com.lunaru.democli.common.entities.AttributeClass;
import com.lunaru.democli.common.entities.CreatorClass;
import com.lunaru.democli.common.utilities.Properties;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import picocli.CommandLine;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 2/21/2021
 */
@Component
@CommandLine.Command( name = "createClass",
        version = {
                "@|green,bg(white) Create Java Class v1.0.0|@",
                "@|green,bg(white) Picocli: " + picocli.CommandLine.VERSION + "|@",
                "@|red,bg(white) JVM: ${java.version} (${java.vendor} ${java.vm.name} ${java.vm.version})|@",
                "@|red,bg(white) OS: ${os.name} ${os.version} ${os.arch}|@",
                "@|black,bg(white) (c) 2021|@"},
        header = "%n@|green,bg(white) Command create a Java class|@",
        description = "This command create a Java Class!.%n",
        mixinStandardHelpOptions = true )
//The mixinStandardHelpOptions attribute adds --help and --version options
public class SubCommandCreateClass extends BaseSubCommand implements Runnable
{
    //#region Privates Attributes
    private final CreatorClass _creatorClass;
    private final TemplateEngine _textTemplateEngine;
    private final Context _contextTemplateEngine;
    //#endregion

    //#region Options/Parameters

    //#endregion

    //#region Constructors
    /**
     * Class constructor.
     */
    public SubCommandCreateClass( TemplateEngine textTemplateEngine, Context contextTemplateEngine )
    {
        this._contextTemplateEngine = contextTemplateEngine;
        this._textTemplateEngine = textTemplateEngine;

        this._creatorClass = new CreatorClass();
        this._creatorClass.setPackage( "com.ruke.microservice" );
        this._creatorClass.setTypeAccess( "public" );
        this._creatorClass.setType( "class" );
        this._creatorClass.setName( "TestClass" );

        List<AttributeClass> _attributesClass = new ArrayList<>();
        AttributeClass _attributeClass = new AttributeClass();

        _attributeClass.setComment( "This is a test" );
        _attributeClass.setType( "String" );
        _attributeClass.setTypeAccess( "private" );
        _attributeClass.setName( "_test" );

        _attributesClass.add( _attributeClass );

        _attributeClass.setComment( "This is a test 2" );
        _attributeClass.setType( "String" );
        _attributeClass.setTypeAccess( "protected" );
        _attributeClass.setName( "_test2" );

        _attributesClass.add( _attributeClass );

        this._creatorClass.setAttributes( _attributesClass );


    }
    //#endregion

    //#region Public Methods
    @Override
    public void run()
    {
        try
        {
            createClass();

            _printMessage = "File is fill!";
            printCorrectMessage();
        }
        catch ( IOException e )
        {
            _printMessage = "Error creating file!";
            printErrorMessage( e.getMessage() );
        }
        catch ( Exception e )
        {
            _printMessage = Properties.getProperty( "error.general" );
            printErrorMessage( e.getMessage() );
        }
    }
    //#endregion

    //#region Privates Methods
    private void createClass() throws IOException
    {

        File file = new File(  "c://Users//ruben//Desktop//test//"+ _creatorClass.getName() +".java" );

        //Create the file
        if ( file.createNewFile() )
        {
            _printMessage = "File is created!";
            printCorrectMessage();

            //Write Content
            FileWriter writer = new FileWriter( file);
            writer.write( fillClass() );
            writer.close();
        }
        else
        {
            _printMessage = "File already exists.";
            printCorrectMessage();
        }
    }

    private String fillClass()
    {
        _contextTemplateEngine.setVariable( "class",
                                            _creatorClass );

        String text = _textTemplateEngine.process("JavaClassBasic", _contextTemplateEngine);

        return text;
    }
    //#endregion
}

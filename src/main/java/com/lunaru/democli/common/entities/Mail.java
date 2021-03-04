package com.lunaru.democli.common.entities;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/1/2021
 */
@Component
public class Mail
{
    //#region Privates Attributes
    private String _from;
    private String[] _to;
    private String _subject;
    private String _body;
    private File _file;
    //#endregion

    //#region Constructs
    /**
     * Class constructor.
     */
    public Mail()
    {
    }

    /**
     * Class constructor.
     * @param to
     * @param subject
     * @param body
     * @param file
     */
    public Mail( String[] to, String subject, String body, File file )
    {
        _to = to;
        _subject = subject;
        _body = body;
        _file = file;
    }

    /**
     * Class constructor.
     * @param from
     * @param to
     * @param subject
     * @param body
     * @param file
     */
    public Mail( String from, String[] to, String subject, String body, File file )
    {
        _from = from;
        _to = to;
        _subject = subject;
        _body = body;
        _file = file;
    }
    //#endregion

    //#region Getters and Setters
    public String[] getTo()
    {
        return _to;
    }

    public void setTo( String[] to )
    {
        _to = to;
    }

    public String getSubject()
    {
        return _subject;
    }

    public void setSubject( String subject )
    {
        _subject = subject;
    }

    public String getBody()
    {
        return _body;
    }

    public void setBody( String body )
    {
        _body = body;
    }

    public File getFile()
    {
        return _file;
    }

    public void setFile( File file )
    {
        _file = file;
    }
    //#endregion

    //#region Public Methods
    @Override
    public String toString()
    {
        return "Mail{" + "_to=" + Arrays.toString( _to ) + ", _subject='" + _subject + '\'' + ", _body='" + _body +
               '\'' + ", _file=" + _file + '}';
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
        {
            return true;
        }
        if ( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        Mail mail = ( Mail ) o;
        return Arrays.equals( _to, mail._to ) &&
               Objects.equals( _subject, mail._subject ) &&
               Objects.equals( _body, mail._body ) &&
               Objects.equals( _file, mail._file );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( _subject, _body, _file );
    }
    //#endregion
}

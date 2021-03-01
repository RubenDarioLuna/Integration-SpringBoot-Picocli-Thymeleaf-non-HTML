package com.lunaru.democli.common.entities;

import java.util.List;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 2/16/2021
 */
public class CreatorClass
{
    private String _package;
    private String _typeAccess;
    private String _type;
    private String _name;
    private List<AttributeClass> _attributes;

    /**
     * Class constructor.
     */
    public CreatorClass()
    {}

    public String getPackage()
    {
        return _package;
    }

    public void setPackage( String aPackage )
    {
        _package = aPackage;
    }

    public String getTypeAccess()
    {
        return _typeAccess;
    }

    public void setTypeAccess( String typeAccess )
    {
        _typeAccess = typeAccess;
    }

    public String getType()
    {
        return _type;
    }

    public void setType( String type )
    {
        _type = type;
    }

    public String getName()
    {
        return _name;
    }

    public void setName( String name )
    {
        _name = name;
    }

    public List<AttributeClass> getAttributes()
    {
        return _attributes;
    }

    public void setAttributes( List<AttributeClass> attributes )
    {
        _attributes = attributes;
    }
}

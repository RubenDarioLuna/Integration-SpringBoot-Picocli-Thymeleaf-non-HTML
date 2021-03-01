package com.lunaru.democli.common.entities;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 2/21/2021
 */
public class AttributeClass
{
    private String _typeAccess;
    private String _type;
    private String _name;
    private String _comment;

    /**
     * Class constructor.
     */
    public AttributeClass()
    {}

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

    public String getComment()
    {
        return _comment;
    }

    public void setComment( String comment )
    {
        _comment = comment;
    }
}

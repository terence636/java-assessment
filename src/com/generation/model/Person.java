package com.generation.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract public class Person
{
    private final String id;

    private final String name;

    private final String email;

    private final Date birthDate;

    protected Person( String id, String name, String email, Date birthDate )
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    @Override
    public String toString()
    {
        DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        return "ID='" + id + '\'' + ", name='" + name + '\'' + ", email='" + email + '\'' + ", birthDate=" + '\'' + formatter.format(birthDate) + '\'';
    }
}

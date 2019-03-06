/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.skodaj.b0b36pjv.cv03;

import java.util.Objects;

/**
 * Class to store info about cars engine
 * @author skodaji4
 */
public class Engine
{
    private String type;

    /**
     * Constructor of Engine
     * @param type Type of engine
     */
    public Engine(String type)
    {
        this.type = type;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Engine other = (Engine) obj;
        if (!Objects.equals(this.type, other.type))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return this.type;
    }
    
    
    
    
    
    
}

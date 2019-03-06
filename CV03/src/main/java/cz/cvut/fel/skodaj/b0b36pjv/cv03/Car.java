/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.skodaj.b0b36pjv.cv03;

import java.util.*;



/**
 * Class to store some inforamtion about cars
 *
 * @author skodaji4
 */
public class Car
{
    
    private static int countOfCars;
    
    private final String manufacturer;
    private final String modelName;
    private final int year;
    private final UUID vinCode;
    private Engine engine;
    private ServiceBook serviceBook;
    private int speed;
    
    /**
     * Constructor of car class
     * @param manufacturer Manufacturer of class
     * @param type Name of model of car
     * @param year Year of manufacture
     * @param engine Type of engine of car
     * @param speed Speed of car
     */
    public Car(String manufacturer, String type, int year, String engine, int speed)
    {
        this.manufacturer = manufacturer;
        this.modelName = type;
        this.year = year;
        this.vinCode = UUID.randomUUID();
        countOfCars ++;
        this.engine = new Engine(engine);   
        this.speed = speed;
    }
    
    /**
     * Method to get count of instanced cars
     * @return Count of instanced cars
     */
    public static int getNumberOfExistingCars()
    {
        return countOfCars;
    }
    
    /**
     * Adds service book to car
     * @param sb Service book to be added
     */
    public void addServiceBook(ServiceBook sb)
    {
        this.serviceBook = sb;
    }

    /**
     * Gets name of manufacturer of car
     * @return Name of manufacturer
     */
    public String getManufacturer()
    {
        return this.manufacturer;
    }

    /**
     * Gets name of model of car
     * @return Name of model
     */
    public String getModelName()
    {
        return this.modelName;
    }

    /**
     * Gets service book of car
     * @return Service book of car
     */
    public ServiceBook getServiceBook()
    {
        return this.serviceBook;
    }
    
    
    
    
    
    
    
    
    @Override
    public String toString()
    {
        return this.manufacturer + " " + this.modelName + " year " + this.year + " VIN:" + this.vinCode;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.manufacturer);
        hash = 97 * hash + Objects.hashCode(this.modelName);
        hash = 97 * hash + this.year;
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
        final Car other = (Car) obj;
        return Objects.equals(this.vinCode, other.vinCode);
    }
    
    
    
}

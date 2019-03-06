/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.skodaj.b0b36pjv.cv03;

import java.util.ArrayList;

/**
 * Class stores information about cars service book
 * @author skodaji4
 */
public class ServiceBook
{
    private ArrayList<String> serviceRecords;
    private Car car;
    
    /**
     * Constructor of service book class
     * @param car Service book of car
     */
    public ServiceBook(Car car)
    {
        this.serviceRecords = new ArrayList<>();
        this.car = car;
        this.addToCar();        
    }
    
    /**
     * Links service book to car
     */
    private void addToCar()
    {
        this.car.addServiceBook(this);
    }
    
    /**
     * Adds record to service book
     * @param record Record to be recorded in service book
     */
    public void addRecord(String record)
    {
        this.serviceRecords.add(record);
    }

    @Override
    public String toString()
    {
        String reti = "";
        for (String record: this.serviceRecords)
        {
            reti += record;
            reti += "\n";
        }
        
        return reti;
    }
    
    
}

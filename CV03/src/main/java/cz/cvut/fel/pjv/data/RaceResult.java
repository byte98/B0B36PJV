/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv.data;

import cz.cvut.fel.skodaj.b0b36pjv.cv03.Car;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class RaceResult implements Comparable<RaceResult>
{
    private Car car;
    private TimeSpan time;
    
    public RaceResult(Car car, TimeSpan time)
    {
       this.car = car;
       this.time = time;
    }
    
    public Car getCar()
    {
        return this.car;
    }
    
    public TimeSpan getTime()
    {
        return this.time;
    }
    
    @Override
    public int compareTo(RaceResult other)
    {
        return this.time.compareTo(other.getTime());
        
    }
}

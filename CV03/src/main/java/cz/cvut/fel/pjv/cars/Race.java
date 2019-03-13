/*
 * Copyright 2019 Jiří Škoda <skodaji4@fel.cvut.cz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.cvut.fel.pjv.cars;
import cz.cvut.fel.pjv.data.*;
import cz.cvut.fel.skodaj.b0b36pjv.cv03.*;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class Race
{
    private int length;
    private CarLinkedList participiants;
    private boolean started = false;
    private RaceResult[] results;
    
    public Race(int length)
    {
        this.length = length;
        this.participiants = new CarLinkedList();
    }
    
    public boolean addRacingCar(Car car)
    {
        boolean reti = false;
        if (started == false)
        {
            this.participiants.addCar(car);
            reti = true;
        }
        return reti;
    }
    
    private void doRace()
    {
        if (started == false)
        {
            this.started = true;
            this.results = new RaceResult[this.participiants.count()];
            Car[] cars = this.participiants.toArray();
            int i = 0;
            for (Car c : cars)
            {
                this.results[i] = new RaceResult(c, this.computeTime(c));
                i++;
            }

            cz.cvut.fel.pjv.utils.ArrayUtil.sort(this.results);
        }
    }
    
    public Car getWinner()
    {
        this.doRace();
        return this.results[0].getCar();
    }
    
    public TimeSpan getWinningTime()
    {
        this.doRace();
        return this.results[0].getTime();
    }
    
    public RaceResult[] getRaceResults()
    {
        this.doRace();
        return this.results;
    }
    
    private TimeSpan computeTime(Car car)
    {
        return new TimeSpan((this.length / car.getSpeed()));
    }
    
    @Override
    public String toString()
    {
        String reti = "";
        if (started)
        {
            for (RaceResult r: this.results)
            {
                reti += r.getCar() + ", time: " + r.getTime() + "\n";
            }
        }
        else
        {
            for (Car c : this.participiants.toArray())
            {
                reti += c + "\n";
            }
        }
        return reti;
    }
    
}

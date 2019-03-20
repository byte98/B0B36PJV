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
package cz.cvut.fel.skodaj.b0b36pjv.cv04;

import java.util.*;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class AnyHolderCar implements BicycleVisitable
{
    private ArrayList<AnyHolder> holders;
    private int max_holders = 4;
    
    public AnyHolderCar()
    {
        this.holders = new ArrayList<AnyHolder>(this.max_holders);
    }
    
    private void addHolder(AnyHolder holder)
    {
        if (this.holders.size() < this.max_holders)
        {
            this.holders.add(holder);
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public String toString()
    {
       String reti = "<class='Car'>(int)max_holders=" + this.max_holders + "ArrayList<BicycleHolder>holders:\n";
       for (AnyHolder h : this.holders)
       {
           reti += h.toString() + "\n";
       }
       
       return reti;
    }
    

    @Override
    public void accept(Bicycle b)
    {
        this.addHolder(new AnyHolder(b));
    }

    @Override
    public void accept(MountainBike b) {
        this.addHolder(new AnyHolder(b));
    }

    @Override
    public void accept(RoadBike b) {
        this.addHolder(new AnyHolder(b));
    }
}

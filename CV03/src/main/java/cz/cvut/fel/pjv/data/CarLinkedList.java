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
package cz.cvut.fel.pjv.data;
import cz.cvut.fel.skodaj.b0b36pjv.cv03.*;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class CarLinkedList
{
    private CarListNode first;
    private int count;
    
    public CarLinkedList()
    {
        this.count = 0;
        this.first = null;
    }
    
    public void addCar(Car input)
    {
        if (this.count == 0)
        {
            this.first = new CarListNode(input);
            this.count++;
        }
        else
        {
            CarListNode last = this.first;
            while (last.getNext() != null)
            {
                last = last.getNext();
            }
            last.addNext(new CarListNode(input));
            this.count++;
        }
    }
    
    public Car[] toArray()
    {
        Car[] reti;
        if (this.count > 0)
        {
            reti = new Car[this.count];
            int i = 0;
            CarListNode node = this.first;
            reti[i] = node.getData();
            i++;
            while (node.getNext() != null)
            {
                node = node.getNext();
                reti[i] = node.getData();
                i++;
            }
        }
        else
        {
            reti = null;
        }
        
        return reti;
    }
    
    public int count()
    {
        return this.count;
    }
    
    @Override
    public String toString()
    {
        String reti = "";
        Car[] arr = this.toArray();
        for (int i = 0; i < arr.length; i++)
        {
            reti += arr[i].toString();
            if (i < arr.length - 1)
            {
                reti += ",";
            }
        }
        
        return reti;
    }
}

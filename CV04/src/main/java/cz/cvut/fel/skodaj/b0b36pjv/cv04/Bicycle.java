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


/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class Bicycle
{
    protected int cadence; 
    protected int speed; 
    protected int gear;
    

    
    public Bicycle (int cadence, int speed, int gear)
    {
        this.cadence = cadence;
        this.speed = speed;
        this.gear = gear;
    }
    

    
    public void printDescription()
    {
        System.out.println("Bike is in gear " + this.gear + " with a cadence of " + this.cadence + " and travelling at a speed of " + this.speed + ".");
    }
    
    public void visitService(BasicService service)
    {
        service.accept(this);
    }
    
    public void visitCar(Car car)
    {
        car.accept(this);
    }
    
    @Override
    public String toString()
    {
        String reti = "";
        reti += "<class='Bicycle'>";        
        return reti;
    }
    
    public void visit(BicycleVisitable bv)
    {
        bv.accept(this);
    }
}

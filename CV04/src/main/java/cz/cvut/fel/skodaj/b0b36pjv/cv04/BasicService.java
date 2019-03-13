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
public class BasicService {
    
    public void accept(Bicycle b)
    {
        System.out.println("Fixing Bicycle");
    }
    
    public void accept(MountainBike b)
    {
        System.out.println("Can't fix MountainBike!");
    }
    
    public void accept (RoadBike b)
    {
        System.out.println("Can't fix RoadBike!");
    }
}
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
public class TestBikes
{
    public static void main(String[] args)
    {
        Bicycle bike01, bike02, bike03;
 
        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);

        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();
        
        BasicService bService, rbService, mbService;
        
        bService = new BasicService();
        rbService = new RoadBikeService();
        mbService = new MountainBikeService();
        
        bService.accept(bike01);
        bService.accept(bike02);
        bService.accept(bike03);
        
        rbService.accept(bike01);
        rbService.accept(bike02);
        rbService.accept(bike03);
        
        mbService.accept(bike01);
        mbService.accept(bike02);
        mbService.accept(bike03);
        
        Bicycle bBike = new Bicycle(20, 10, 1);
        MountainBike mBike = new MountainBike(20, 10, 5, "Dual");
        RoadBike rBike = new RoadBike(40, 20, 8, 23);
        
        bService.accept(bBike);
        bService.accept(mBike);
        bService.accept(rBike);
        
        rbService.accept(bBike);
        rbService.accept(mBike);
        rbService.accept(rBike);
        
        mbService.accept(bBike);
        mbService.accept(mBike);
        mbService.accept(rBike);
        
        
        
    }
}

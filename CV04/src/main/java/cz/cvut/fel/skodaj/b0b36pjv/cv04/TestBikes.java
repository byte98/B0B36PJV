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
        
        System.out.println("Basic service; Bicycle");
        bService.accept(bike01);
        bService.accept(bike02);
        bService.accept(bike03);
        System.out.println();
        
        System.out.println("Road bike service; Bicycle");        
        rbService.accept(bike01);
        rbService.accept(bike02);
        rbService.accept(bike03);
        System.out.println();

        
        System.out.println("Mountain bike service; Bicycle");
        mbService.accept(bike01);
        mbService.accept(bike02);
        mbService.accept(bike03);
        System.out.println();

        
        Bicycle bBike = new Bicycle(20, 10, 1);
        MountainBike mBike = new MountainBike(20, 10, 5, "Dual");
        RoadBike rBike = new RoadBike(40, 20, 8, 23);
        
        System.out.println("Basic service; Bicycle");
        bService.accept(bBike);
        System.out.println("Basic service; Mountain Bike");
        bService.accept(mBike);
        System.out.println("Basic service; Road Bike");
        bService.accept(rBike);
        System.out.println();

        
        System.out.println("Road bike service; Bicycle");
        rbService.accept(bBike);
        System.out.println("Road bike service; Mountain bike");
        rbService.accept(mBike);
        System.out.println("Road bike service; Road bike");
        rbService.accept(rBike);
        System.out.println();


        System.out.println("Mountain Bike service; Bicycle");
        mbService.accept(bBike);
        System.out.println("Mountain Bike service; Mountain bike");
        mbService.accept(mBike);
        System.out.println("Mountain Bike service; Road bike");
        mbService.accept(rBike);
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("*** Bicycle ***");
        System.out.println("Basic service:");
        bike01.visitService(bService);
        System.out.println("Mountain bike service:");
        bike01.visitService(mbService);
        System.out.println("Road bike service:");
        bike01.visitService(rbService);
        System.out.println();
        System.out.println();
        
        System.out.println("*** Road bike ***");
        System.out.println("Basic service:");
        bike02.visitService(bService);
        System.out.println("Mountain bike service:");
        bike02.visitService(mbService);
        System.out.println("Road bike service:");
        bike02.visitService(rbService);
        System.out.println();
        System.out.println();
        
        System.out.println("*** Mountain bike ***");
        System.out.println("Basic service:");
        bike03.visitService(bService);
        System.out.println("Mountain bike service:");
        bike03.visitService(mbService);
        System.out.println("Road bike service:");
        bike03.visitService(rbService);
        System.out.println();
        System.out.println();
        System.out.println("Double dispatch:");
        Car car2 = new Car();
        bike01.visit(car2);
        bike02.visit(car2);
        bike03.visit(car2);
        System.out.println(car2);
        
    }
}

package cz.cvut.fel.skodaj.b0b36pjv.cv03;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Entry class of program
 * @author skoda
 */
public class Main 
{
    public static void main(String[] args)  
    {
        Car car1 = new Car("Volkswagen", "Polo", 2010, "AKK", 40);
        ServiceBook serviceBook1 = new ServiceBook(car1);
        serviceBook1.addRecord("První servisní prohlídka.");
        System.out.println(car1);
        System.out.println("Počet aut: " + Car.getNumberOfExistingCars());
        System.out.printf("Servisní záznamy %s %s:\n%s\n", car1.getManufacturer(), car1.getModelName(), car1.getServiceBook());
        Car car2 = new Car("Chevrolet", "Corvette", 1980, "LS7", 45);
        ServiceBook serviceBook2 = new ServiceBook(car2);
        serviceBook2.addRecord("První servisní prohlídka.");
        serviceBook2.addRecord("Porucha motoru.");
        System.out.println(car2);
        System.out.println("Počet aut: " + Car.getNumberOfExistingCars());
        System.out.printf("Servisní záznamy %s %s:\n%s\n", car2.getManufacturer(), car2.getModelName(), car2.getServiceBook());
    }
}

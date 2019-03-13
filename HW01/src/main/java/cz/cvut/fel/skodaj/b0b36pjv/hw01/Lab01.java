/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv;
//package cz.cvut.fel.skodaj.b0b36pjv.hw01;

import java.util.Scanner;

/**
 *
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class Lab01 {
    private final Scanner sc = new Scanner(System.in);
    
    public void start(String[] args)
    {
        this.homework();
    }
    
    private void homework()
    {
        System.out.print("Vyber operaci (1-soucet, 2-rozdil, 3-soucin, 4-podil):");
        int operation = this.sc.nextInt();
        System.out.println();
        switch(operation)   
        {
            case 1:
                this.addition();
                break;
            case 2:
                this.substraction();
                break;
            case 3:
                this.multiplication();
                break;
            case 4:
                this.division();
                break;
            default:
                System.out.println("Chybna volba!");
        }
    }
    
     private void addition()
     {
         System.out.print("Zadej scitanec: ");
         double operand1 = this.sc.nextDouble();
         System.out.println();
         System.out.print("Zadej scitanec: ");
         double operand2 = this.sc.nextDouble();
         System.out.println();
         System.out.print("Zadej pocet desetinnych mist: ");
         int decimals = this.sc.nextInt();
         System.out.println();
         if (decimals < 0)
         {
             System.out.println("Chyba - musi byt zadane kladne cislo!");
             return;
         }
         
System.out.printf(this.getFormat(decimals) + " + " + this.getFormat(decimals) + " = " + this.getFormat(decimals) + "\n", operand1, operand2, (operand1 + operand2));
         
     }
     
     private void substraction()
     {
         System.out.print("Zadej mensenec: ");
         double operand1 = this.sc.nextDouble();
         System.out.println();
         System.out.print("Zadej mensitel: ");
         double operand2 = this.sc.nextDouble();
         System.out.println();
         System.out.print("Zadej pocet desetinnych mist: ");
         int decimals = this.sc.nextInt();
         System.out.println();
         if (decimals < 0)
         {
             System.out.println("Chyba - musi byt zadane kladne cislo!");
             return;
         }
         
System.out.printf(this.getFormat(decimals) + " - " + this.getFormat(decimals) + " = " + this.getFormat(decimals) + "\n", operand1, operand2, (operand1 - operand2));
     }
     
     private void multiplication()
     {
         System.out.print("Zadej cinitel: ");
         double operand1 = this.sc.nextDouble();
         System.out.println();
         System.out.print("Zadej cinitel: ");
         double operand2 = this.sc.nextDouble();
         System.out.println();
         System.out.print("Zadej pocet desetinnych mist: ");
         int decimals = this.sc.nextInt();
         System.out.println();
         if (decimals < 0)
         {
             System.out.println("Chyba - musi byt zadane kladne cislo!");
             return;
         }
         
System.out.printf(this.getFormat(decimals) + " * " + this.getFormat(decimals) + " = " + this.getFormat(decimals) + "\n", operand1, operand2, (operand1 * operand2));
     }
     
     private void division()
     {
         System.out.print("Zadej delenec: ");
         double operand1 = this.sc.nextDouble();
         System.out.println();
         System.out.print("Zadej delitel: ");
         double operand2 = this.sc.nextDouble();
         System.out.println();
         if (operand2 == (double)0)
         {
             System.out.println("Pokus o deleni nulou!");
             return;
         }
         System.out.print("Zadej pocet desetinnych mist: ");
         int decimals = this.sc.nextInt();
         System.out.println();
         if (decimals < 0)
         {
             System.out.println("Chyba - musi byt zadane kladne cislo!");
             return;
         }
         
         System.out.printf(this.getFormat(decimals) + " / " + this.getFormat(decimals) + " = " + this.getFormat(decimals) + "\n", operand1, operand2, (operand1 / operand2));
     }
     
     private String getFormat(int decimals)
     {
         return "%." + decimals + "f";
     }
}

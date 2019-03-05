/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.skodaj.b0b36pjv.cv02;

import java.util.*;

/**
 *
 * @author skoda
 */
public class Solution
{
     private Scanner sc = new Scanner(System.in);
    /*public void readData()
    {
        System.out.println("Input data:");
        double x;
        double y;
        x = sc.readDouble();
        System.out.println("Input data:");
        y = sc.readDouble();
        System.out.println(x + "+" + y + "=" + (x+y));
        System.printf("%.2f + %.2f = %10.3f", x, y, (x+y));
    }*/

    public void computeCircle(double r)
    {
        double circle =  (2 * Math.PI * r);
        double volume = (Math.PI * Math.pow(r, 2));
        System.out.printf("Radius: %.3f, circle: %.3f, volume: %.3f\n", r, circle, volume);
    }
    
    public String getWeekday(int number)
    {
        String reti = "";
        switch (number)
        {
            case 1:
                reti = "Monday";
                break;
            case 2:
                reti = "Tuesday";
                break;
            case 3:
                reti = "Wednesday";
                break;
            case 4:
                reti = "Thursday";
                break;
            case 5:
                reti= "Friday";
                break;
            case 6:
                reti = "Saturday";
                break;
            case 7:
                reti = "Sunday";
                break;
        }
        return reti;
    }
    
    private void getNumbers()
    {
        int input = this.sc.nextInt();
        int sum = 0;
        int count = 0;
        int max = input;
        int max_1 = input;
        int max_2 = input;
        int prev = 0;
        boolean second = false;
        
        boolean constant = true;
        boolean asc = true;
        boolean desc = true;
        boolean not_asc = true;
        boolean not_desc = true;
        
        if (input == 0)
        {
            System.err.println("Unable to find average");
        }
        else
        {
            while (input != 0)
            {
                sum += input;
                count++;
                if (input > max_2 && input < max_1)
                {
                    max_2 = input;
                }
                else if (input > max_1 && input < max_2)
                {
                    max_1 = input;
                }
                else if (input > max)
                {
                    max_2 = max_1;
                    max_1 = max;
                    max = input;
                }
                if (second)
                {
                    if (prev != input)
                    {
                        constant = false;
                    }
                    if (input <= prev)
                    {
                        asc = false;
                    }
                    if (input >= prev)
                    {
                        desc = false;
                    }
                    if (input < prev)
                    {
                        not_desc = false;
                    }
                    if (input > prev)
                    {
                        not_asc = false;
                    }
                }
                
                prev = input;
                input = this.sc.nextInt();
                second = true;
            }
        }
        System.out.printf("Count: %d, sum: %d, average: %f, max: %d, second max: %d, ", count, sum, (double)((double)sum / (double)count), max, max_1);
        if (constant)
        {
            System.out.print(" constant ");
        }
        if (asc)
        {
            System.out.print(" ascending ");
        }
        if (desc)
        {
            System.out.print(" descending ");
        }
        if (not_asc)
        {
            System.out.print(" not ascending ");
        }
        if (not_desc)
        {
            System.out.print(" not descending ");
        }
        System.out.println();

    }
    
    public String getPrimeFactorization(int input)
    {
        String reti = "";
        for (int d = 2; d <= input; d++)
        {
            while (input % d == 0)
            {
                reti += d;
                input = (input / d);
                if (input != 1)
                {
                    reti += "×";
                }
            }
            
        }
        
        return reti;
        
    }
    
    public String writeArray(int[] input)
    {
        String reti = "";
        for (int i = 0; i < input.length; i++)
        {
            reti += input[i];
            if (i < (input.length - 1))
            {
                reti += ", ";
            }
        }
        
        return reti;
    }
    
    public void fillArray(int[] input)
    {        
        for (int i = 1; i <= input.length; i++)
        {
            input[(i - 1)] = i;
        }
    }
    
    public void randomArray(int[] array, int min, int max)
    {
        Random r = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = r.nextInt((max - min) + 1) + min;
        }
    }
    
    
    
    public void start (String[] args)
    {
        //readData();
       this.computeCircle(5);
       System.out.println(this.getWeekday(7));
       //this.getNumbers();
       int factor = 60;
       System.out.println(factor + " = " + this.getPrimeFactorization(factor));
       int[] array = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
       this.fillArray(array);
       System.out.println(this.writeArray(array));
       this.randomArray(array, 0, 10);
       System.out.println(this.writeArray(array));
       
       
       
    }
}

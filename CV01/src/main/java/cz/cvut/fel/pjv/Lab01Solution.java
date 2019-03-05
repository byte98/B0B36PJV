/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv;

/**
 *
 * @author martin
 */
public class Lab01Solution {
    public void start(String[] args) {
        
        System.out.println("Hello World!");
        int sum = 0;
        if (args.length == 0)
        {
            System.err.println("No input detected!");
        }
        for (String arg : args)
        {
            try
            {
                sum += Integer.parseInt(arg);
            }
            catch (NumberFormatException ref)
            {
                System.err.println("No input detected;");
                return;
            }
        }
        System.out.println("Součet: " + sum);
        
        
    }
    
}

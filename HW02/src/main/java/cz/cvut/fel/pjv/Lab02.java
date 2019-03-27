/*
 * File name: Lab06.java
 * Date:      2014/08/26 21:39
 * Author:    @author
 */

package cz.cvut.fel.pjv;



public class Lab02 {


  
   public void start(String[] args)
   {
       this.homework();
   }
   
   public void homework()
   {
        final int MAX_LINES = 10;

        TextIO txt = new TextIO();
        String line = txt.getLine();
        int count = 0;
        int line_nr = 0;
        double[] buffer = new double[MAX_LINES];
        while (!"".equals(line))
        {
            line_nr++;

            if (TextIO.isDouble(line) == false && TextIO.isFloat(line) == false && TextIO.isInteger(line) == false)
            {
                System.err.println("A number has not been parsed from line " + line_nr);
            }
            else
            {
                double value = (double)(TextIO.isDouble(line) ? Double.parseDouble(line) : (TextIO.isFloat(line) ? Float.parseFloat(line) : (TextIO.isInteger(line) ? Integer.parseInt(line) : 0)));
                buffer[count] = value;
                
                count++;
            }  

            if (count % MAX_LINES == 0 && count != 0)
            {
                // Evaluation
                System.out.printf("%2d ", count);
                Lab02.evaluate(buffer, count);
                buffer = new double[MAX_LINES];
                count = 0;
            }

            line = txt.getLine();
        }        
        if ("".equals(txt.getLine()))
        {
            System.err.println("End of input detected!");
        }
        if (count > 1)
        {
            System.out.printf("%2d ", count);
            Lab02.evaluate(buffer, count);
        }
        
   }
   
   public static void evaluate(double[] buffer, int count)
   {   
       //Average
       double sum = 0;
       for (int i = 0; i < count; i++)
       {
           sum += buffer[i];
       }
       double average = (sum / (double)count);
       
       //Standard deviation
       double distances = 0;
       for (int i = 0; i < count; i++)
       {
           distances += Math.pow((buffer[i] - average), 2);
       }
       double standard_deviation = Math.sqrt((distances / (double)count));
       
       //Write to standard output
       System.out.printf("%.3f %.3f\n", average, standard_deviation);
       
   }
}

/* end of Lab02.java */

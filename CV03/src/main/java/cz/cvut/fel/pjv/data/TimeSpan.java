/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv.data;

/**
 *
 * @author Jiří Škoda <skodaji4@fel.cvut.cz>
 */
public class TimeSpan
{
    private int hour;
    private int minute;
    private int second;
    
    public TimeSpan()
    {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }
    
    public TimeSpan(int seconds)
    {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        
        if (seconds < 60)
        {
            this.second = seconds;
        }
        else if (seconds > 60 && seconds < 3600)
        {
            this.minute = seconds / 60;
            this.second = seconds - (this.minute * 60);
        }
        else
        {
            this.hour = (seconds / 3600);
            this.minute = (seconds - (this.hour * 3600)) / 60;
            this.second = seconds - (this.hour * 3600) - this.minute * 60;
        }
    }
    public TimeSpan (int minutes, int seconds)
    {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        
        this.second = (seconds >= 60 ? 0 : seconds);
        if (minutes >= 60)
        {
            this.hour = minutes / 60;
            this.minute = minutes - (this.hour / 60);
        }
    }
    
    public TimeSpan (int hours, int minutes, int seconds)
    {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
        
        this.second = (seconds >= 60 ? 0 : seconds);
        this.minute = (minutes >= 60 ? 0 : minutes);
        this.hour = hours;
    }
    
    public TimeSpan (TimeSpan ts)
    {
        this.second = ts.getSecond();
        this.minute = ts.getMinute();
        this.hour = ts.getHour();
    }

    public int getHour()
    {
        return this.hour;
    }

    public int getMinute()
    {
        return this.minute;
    }

    public int getSecond()
    {
        return this.second;
    }

    public int getTotalSeconds()
    {
        return (this.hour * 3600) + (this.minute * 60) + this.second;
    }
    
    public TimeSpan add(int seconds)
    {
        if (seconds < 60)
        {
            this.second += seconds;
        }
        else if (seconds >= 60 && seconds < 3600)
        {
            int minutes = seconds / 60;
            this.minute += minutes;
            this.second += seconds - (minutes * 60);
        }
        else
        {
            int hours = seconds / 3600;
            int minutes = (seconds - (hours * 3600)) / 60;
            this.hour += hours;
            this.minute += minutes;
            this.second += seconds - (minutes * 60) - (hours * 3600);
        }
        
        return this;
    }
    
    public void setTime(int hours, int minutes, int seconds)
    {
        this.hour = hours;
        this.minute = (minutes >= 60 ? 0 : minutes);
        this.second = (seconds >= 60 ? 0 : seconds);
    }
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 11 * hash + this.hour;
        hash = 11 * hash + this.minute;
        hash = 11 * hash + this.second;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final TimeSpan other = (TimeSpan) obj;
        if (this.hour != other.hour)
        {
            return false;
        }
        if (this.minute != other.minute)
        {
            return false;
        }
        if (this.second != other.second)
        {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString()
    {
        return this.hour + " hours " + this.minute + " minutes " + this.second + " seconds";
    }
    
    public static void main(String[] args)
    {
        TimeSpan t1 = new TimeSpan(0, 0, 130);
        System.out.println("T1: " + t1);
        t1 = new TimeSpan(130);
        System.out.println("T1: " + t1);
        TimeSpan t2 = new TimeSpan(t1).add(70);
        System.out.println("T1: " + t1);
        System.out.println("T2: " + t2);
        System.out.printf("Časy se %s.\n", t1.equals(t2) ? "rovnají" : "nerovnají");
        t1 = t1.add(70);
        System.out.println("T1: " + t1);
        System.out.println("T2: " + t2);
        System.out.printf("Časy se %s.\n", t1.equals(t2) ? "rovnají" : "nerovnají");
    }
    
    
}

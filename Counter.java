/**
 * Program: Counter.java  
 * Purpose: Displays and updates timer and scoreboard.
 */

import greenfoot.*; 
public class Counter extends Actor
{
    int score;
    private int time = 3600;    //60 seconds = 3600

   public Counter(){  //Adds the score and time on the screen
        setImage(new GreenfootImage("Zombies Killed: " + score + "\n Time Left: " + (time/60), 40, Color.WHITE, new Color (0, 0, 0, 0)));
    }
    
   public void act() //Counts the time down and updates the score and time
    {
        countTime();
        setImage(new GreenfootImage("Zombies Killed: " + score + "\n Time Left: " + (time/60), 40, Color.WHITE, new Color (0, 0, 0, 0)));
    }    
    
    
   private void countTime(){   //Stops it when it gets to zero 
        time--;
        if (time == 0)
        {
            Greenfoot.setWorld(new EndScreen());
        }
    }
    
   public int getTime(){   //Allows game world to access time
       return time;
   }

 }
    
    

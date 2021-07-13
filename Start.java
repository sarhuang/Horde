/**
 * Program: Start.java
 * Purpose: The directions page before the player plays the game.
 */
import greenfoot.*; 

public class Start extends World
{
    public Start()  
    {    
        super(1080, 599, 1); 
    }
    
    public void act()   //If the player presses enter, the screen will change to the dialgoue.
    {
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new OfficeWorld());
        }
    }
}

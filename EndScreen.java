/**
 * Program: EndScreen.java
 * Purpose: Winning screen when player refuses to complete game
 */

import greenfoot.*;  

public class EndScreen extends World{
    private GreenfootSound winMusic = new GreenfootSound("Resilience.mp3");
    public EndScreen() 
    {    
        super(1080, 580, 1); 
    }
    
    public void act(){  
        winMusic.play();
        Greenfoot.stop();
    }
}

/**
 * Program: GameOver.java
 * Purpose: Game over screen when the player dies in the dungeon level
 * 
 * Game Over Music Source: https://opengameart.org/content/game-over-theme
 */

import greenfoot.*; 
public class GameOver extends World
{
    private GreenfootSound gameOverMusic = new GreenfootSound("No Hope.mp3");
    
    public GameOver()   
    {    
        super(1080, 580, 1); 
    }

    
    public void act()   //Player presses enter to try again or escape to quit. Music playing in background.
    {
        gameOverMusic.play();
        if (Greenfoot.isKeyDown("space")) {
            gameOverMusic.stop();
            Greenfoot.setWorld(new OfficeWorld());
        }
        
        if (Greenfoot.isKeyDown("escape")){
            Greenfoot.stop();
        }
        
    }
    
}

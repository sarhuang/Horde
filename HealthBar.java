/**
 * Program: HealthBar.java
 * 
 * Purpose: The class definition for the player's health.
 *          It draws the health bar and calculates the player's health.
 * Scream FX Source: http://soundbible.com/112-Female-Scream.html
 */

import greenfoot.*;  
public class HealthBar extends Actor
{   
    private int health = 100;
    private int deathDelay = 30;
    
    private GreenfootSound scream = new GreenfootSound("scream.mp3");

    
    public HealthBar(){ //Draws the health bar on screen
        //Draws the health bar on screen
        setImage(new GreenfootImage(102, 12));
        getImage().drawRect(0, 0, 101, 11);
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1, 1, health, 10);
    }
    
    public void act() //Updates health bar and follow the player's location
    {
        setImage(new GreenfootImage(102, 12));
        getImage().drawRect(0, 0, 101, 11);
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1, 1, health, 10);
        
        World world = getWorld();
        
        OfficeWorld office = (OfficeWorld)world; //Casting to access the methods from OfficeWorld
        setLocation(office.getPlayer().getX() - 30, office.getPlayer().getY() - 160);
        
        loseHealth();
    }    

    
    public void loseHealth(){  //Subtracts health and triggers game over screen if health reaches zero
        World world = getWorld();
    
        OfficeWorld office = (OfficeWorld)world; //Casting to access the methods from OfficeWorld
        setLocation(office.getPlayer().getX() - 30, office.getPlayer().getY() - 160);
        if(office.getPlayer().hitByEnemy()){
            health--;
        }
        
        if(health <= 0){
           scream.play();
           getWorld().removeObject(office.getPlayer());
           getWorld().removeObject(this);
        }
    }

    public int getHealth(){ //Allows the game world to access player's health
        return health;
    }
    
}

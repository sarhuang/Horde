/**
 * Program: RightBullet.java
 * 
 * Purpose: The player's right projectile in the game. A bullet moves right 
 * and will disappear when it reaches the edge of the world or the timer runs out.
 */

import greenfoot.*;
public class RightBullet extends Actor
{
     private int time = 50;  //How long the bullet appears on screen
    
    public RightBullet() {
        GreenfootImage rBullet = getImage();
        rBullet.scale(4, 2);
    }

    public void act() //Moves 30 units in 50 milliseconds and disappears if it touches the edge of the world
                      //or after 50 miliseconds.
    {
        move(30);
        time--;

        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        else if(time == 0){
            getWorld().removeObject(this);
        }
    }   
}

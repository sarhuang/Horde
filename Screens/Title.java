/**
 * Program: Title.java
 * Purpose: Title screen introducing game to the player 
 * Title Screen Music Source: https://soundimage.org/wp-content/uploads/2018/07/Horror-Game-Intro.mp3
 */

import greenfoot.*;

public class Title extends World
{
    private GreenfootImage bgOn = new GreenfootImage("bg_fullsize.png");
    private GreenfootImage bgOff = new GreenfootImage("bg_dark_fullsize.png");
    private GreenfootSound titleMusic = new GreenfootSound("tagmp3_Horror-Game-Intro.mp3");
    GameTitle title = new GameTitle();
    private int frame = 0;
    private int delay = 8;   

    public Title()  //Sets background and adds the game name image and instructions to advance
    {    
        super(1080, 599, 1); 
        Greenfoot.start();
        showText("-Press SPACE-", 540, 420);
        addObject(title, 540, 350);
    }
    
    public void act()   //Music playing in background. Player presses space to go to directions page.
                        //Nested if-else if statements to create flickering lights for background
    {
        titleMusic.play();
        
        frame++;
        if(frame < 1 * delay)
            setBackground(bgOff);
        else if(frame < 2 * delay)
            setBackground(bgOff);
        else if(frame < 3 * delay)
            setBackground(bgOn);
        else if(frame < 4 * delay)
            setBackground(bgOn);
        else if(frame < 5 * delay)
            setBackground(bgOn);
        else if(frame < 6 * delay)
            setBackground(bgOff);
        else if(frame < 7 * delay)
            setBackground(bgOn);
        else if(frame < 8 * delay)
            setBackground(bgOff);
        else if(frame < 9 * delay)
            setBackground(bgOff);
        else if(frame < 10 * delay)
            setBackground(bgOff);
        else if(frame < 11 * delay)
            setBackground(bgOn);
        else if(frame < 12 * delay){
            setBackground(bgOff);
            frame = 1;
        }
        
        if (Greenfoot.isKeyDown("space")) {
            titleMusic.stop();
            Greenfoot.setWorld(new Start());
        }
    }
}

/**
 * Program: OfficeWorld.java 
 * Purpose: The class definition for the first level. 
 * Music, score, health, and character placement is stored here.
 * 
 * Background Music source: https://soundimage.org/wp-content/uploads/2019/05/Creepy-Action.mp3
 */

import greenfoot.*; 

public class OfficeWorld extends World
{

   //Variables for spawnZombies()
   private int spawnTime = 35;    //How fast the enemies should appear in the world
   private int time = 0;           //Total time program has been running
   private int randomSide;         //Used to decide which side the enemy will spawn from
   private int frame = 0;           
   private int delay = 8;
   
   Counter counter = new Counter(); //Initialize Counter object so that Enemy class can use it
   HealthBar healthbar = new HealthBar();
   public Player player = new Player();
   
   private GreenfootImage bgOn = new GreenfootImage("bg_fullsize.png");
   private GreenfootImage bgOff = new GreenfootImage("bg_dark_fullsize.png");
  
   GreenfootSound bgMusic = new GreenfootSound("bg.mp3");
    
  
   public OfficeWorld() //Adds the player, score, time, and healthbar on screen
   {    
        super(1080, 599, 1); 
        addObject(player, 200, 415);
        addObject(counter, 550, 100);
        addObject(healthbar, player.getX() - 30, player.getY() - 160);
   }
    
    public void act(){   //The timer increments, background scrolls, knights spawn, music plays, and the world
                        //the game over screen when the player dies
       bgFlicker();
       if(counter.getTime() <= 3)   //Music stops once the timer reaches zero and transitions to winning screen
            bgMusic.stop();
       else
            bgMusic.play();
            
       time++;
       spawnZombies();
       showGameOver();
   }
   
   public void bgFlicker(){ //Adds lighting/flickering effect to background by switching lit and unlit backgrounds
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
   }
   
   public void spawnZombies(){  //At certain time intervals, a zombie is added on screen either on the left or 
                                //right side of the world.
        if(time % spawnTime == 0){
            randomSide = Greenfoot.getRandomNumber(2);
            switch(randomSide){
                case 0: addObject(new Enemy(counter), 1080, 415); break;
                case 1: addObject(new Enemy(counter), 0, 415); break;
            }
        }
   }
   
   public Player getPlayer(){   //OfficeWorld has access to the Player class
       return player;
    }
    
   public HealthBar getHealthBar(){   //OfficeWorld has access to the player's health bar
       return healthbar;
    }
   
   public Counter getCounter(){ //OfficeWorld has access to the Counter class
       return counter;
    }
    
   public void showGameOver(){  //Sets world to the game over screen when the player loses all health
       if(getHealthBar().getHealth() == 0){
           bgMusic.stop();
           Greenfoot.setWorld(new GameOver());
        }
    }
}

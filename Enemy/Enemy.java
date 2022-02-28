/**
 * Program: Enemy.java
 * 
 * Purpose: The class definition for the enemy zombie. The zombie can move left and right.
 * Health and hitboxes are located here.
 * 
 * Zombie Hit FX Source: http://soundbible.com/1040-Zombie-Gets-Attacked.html
 * Zombie Moan FX Source: http://soundbible.com/1029-Mindless-Zombie-Awakening.html
 */

import greenfoot.*;
public class Enemy extends Actor
{
    
    private GreenfootImage zombieGirlLeft1 = getImage();    //Instantiating the zombie businesswoman looking left images for the walking animation
    private GreenfootImage zombieGirlLeft2 = new GreenfootImage("zombieGirlWalkLeft0002.png");
    private GreenfootImage zombieGirlLeft3 = new GreenfootImage("zombieGirlWalkLeft0003.png");
    private GreenfootImage zombieGirlLeft4 = new GreenfootImage("zombieGirlWalkLeft0004.png");
    private GreenfootImage zombieGirlLeft5 = new GreenfootImage("zombieGirlWalkLeft0005.png");
    private GreenfootImage zombieGirlLeft6 = new GreenfootImage("zombieGirlWalkLeft0006.png");
    
    
    private GreenfootImage zombieManLeft1 = new GreenfootImage("zombieManlWalkLeft0001.png");
    private GreenfootImage zombieManLeft2 = new GreenfootImage("zombieManlWalkLeft0002.png");
    private GreenfootImage zombieManLeft3 = new GreenfootImage("zombieManlWalkLeft0003.png");
    private GreenfootImage zombieManLeft4 = new GreenfootImage("zombieManlWalkLeft0004.png");
    private GreenfootImage zombieManLeft5 = new GreenfootImage("zombieManlWalkLeft0005.png");
    private GreenfootImage zombieManLeft6 = new GreenfootImage("zombieManlWalkLeft0006.png");

    private boolean facingRight;    //Is zombie facing right?
    private boolean facingLeft; //Is zombie facing left?
   
    private int gender;         //Determines which zombie sprite is used
    private int speed = 2;      //How fast the zombies walk
    private int walkTime = 0;   //How long zombies walk for
    private int randomWalkTime; //The total random time the zombies walk for before turning
    private int frame = 0;      //Used to cycle through images for animation
    private int delay = 8;      //How long each image lasts for animation
    
    private int health = 1;             //zombie's health
    private boolean damaged = false;    //Double check the zombie has been hit

    Counter counter;    //Initialize Counter object to use to add score
    
    private GreenfootSound moan = new GreenfootSound("moan.mp3");
    
    
    public Enemy(Counter counter){  //Instantiates the counter as it is dependant on enemy and randomizes walking distance
        this.counter = counter; 
        randomWalkTime = Greenfoot.getRandomNumber(800);    //Sets limit for how long zombie can walk for before turning
        gender = Greenfoot.getRandomNumber(2);
    }
    
    public void act() //Enemy walks as long as health is zero, activates "guard up" animation, and detects collision
    {
        moan.play();
        if(health > 0)
            walk();
        else
            move(0);
            
        hitByPlayer();
    }    
   
    
    public void walk(){
        /*There is a timer that sets how long he walks for before walking the other way.
         *As the zombie walks, the frame variable increments to determine which image should be set
         *to simulate walking. Once the last image is set, the frame count returns back to one and repeats
         *until the timer reaches half of randomWalkTime. After that, the zombie walks right by setting the image
         *variables to the flipped versions of the sprite. Once the timer hits beyond randomWalkTime, it resets and the images
         *are set back the left sprites.*/
         
        walkTime++;
        frame++;    
        
        if(gender == 0){
            //Walk left
            if(walkTime < randomWalkTime/2){
                facingLeft = true;
                facingRight = false;
                setLocation(getX() - speed, getY());
                if(frame < 1 * delay)
                    setImage(zombieManLeft1);
                else if(frame < 2 * delay)
                    setImage(zombieManLeft2);
                else if(frame < 3 * delay)
                    setImage(zombieManLeft3);
                else if(frame < 4 * delay)
                    setImage(zombieManLeft4);
                else if(frame < 5 * delay)
                    setImage(zombieManLeft5);
                else if(frame < 6 * delay){
                    setImage(zombieManLeft6);
                    frame = 1;
                }
            }
            //Walk right
            else if (walkTime < randomWalkTime){
                facingLeft = false;
                facingRight = true;
                //Changing image variables set to the facing right sprites
                zombieManLeft1 = new GreenfootImage("zombieManlWalkRight0001.png");
                zombieManLeft2 = new GreenfootImage("zombieManlWalkRight0002.png");
                zombieManLeft3 = new GreenfootImage("zombieManlWalkRight0003.png");
                zombieManLeft4 = new GreenfootImage("zombieManlWalkRight0004.png");
                zombieManLeft5 = new GreenfootImage("zombieManlWalkRight0005.png");
                zombieManLeft6 = new GreenfootImage("zombieManlWalkRight0006.png");
                setLocation(getX() + speed, getY());
                
                if(frame < 1 * delay)
                    setImage(zombieManLeft1);
                else if(frame < 2 * delay)
                    setImage(zombieManLeft2);
                else if(frame < 3 * delay)
                    setImage(zombieManLeft3);
                else if(frame < 4 * delay)
                    setImage(zombieManLeft4);
                else if(frame < 5 * delay)
                    setImage(zombieManLeft5);
                else if(frame < 6 * delay){
                    setImage(zombieManLeft6);
                    frame = 1;
                }
            }
            //Back to left and repeats process
            else{
                GreenfootImage zombieManLeft1 = new GreenfootImage("zombieManlWalkLeft0001.png");
                GreenfootImage zombieManLeft2 = new GreenfootImage("zombieManlWalkLeft0002.png");
                GreenfootImage zombieManLeft3 = new GreenfootImage("zombieManlWalkLeft0003.png");
                GreenfootImage zombieManLeft4 = new GreenfootImage("zombieManlWalkLeft0004.png");
                GreenfootImage zombieManLeft5 = new GreenfootImage("zombieManlWalkLeft0005.png");
                GreenfootImage zombieManLeft6 = new GreenfootImage("zombieManlWalkLeft0006.png");
                walkTime = 0;
            }
        }
        
        
        else{
            //Walk left
            if(walkTime < randomWalkTime/2){
                facingLeft = true;
                facingRight = false;
                setLocation(getX() - speed, getY());
                if(frame < 1 * delay)
                    setImage(zombieGirlLeft1);
                else if(frame < 2 * delay)
                    setImage(zombieGirlLeft2);
                else if(frame < 3 * delay)
                    setImage(zombieGirlLeft3);
                else if(frame < 4 * delay)
                    setImage(zombieGirlLeft4);
                else if(frame < 5 * delay)
                    setImage(zombieGirlLeft5);
                else if(frame < 6 * delay){
                    setImage(zombieGirlLeft6);
                    frame = 1;
                }
            }
            //Walk right
            else if (walkTime < randomWalkTime){
                facingLeft = false;
                facingRight = true;
                //Changing image variables set to the facing right sprites
                zombieGirlLeft1 = new GreenfootImage("zombieGirlWalkRight0001.png");
                zombieGirlLeft2 = new GreenfootImage("zombieGirlWalkRight0002.png");
                zombieGirlLeft3 = new GreenfootImage("zombieGirlWalkRight0003.png");
                zombieGirlLeft4 = new GreenfootImage("zombieGirlWalkRight0004.png");
                zombieGirlLeft5 = new GreenfootImage("zombieGirlWalkRight0005.png");
                zombieGirlLeft6 = new GreenfootImage("zombieGirlWalkRight0006.png");
                setLocation(getX() + speed, getY());
                
                if(frame < 1 * delay)
                    setImage(zombieGirlLeft1);
                else if(frame < 2 * delay)
                    setImage(zombieGirlLeft2);
                else if(frame < 3 * delay)
                    setImage(zombieGirlLeft3);
                else if(frame < 4 * delay)
                    setImage(zombieGirlLeft4);
                else if(frame < 5 * delay)
                    setImage(zombieGirlLeft5);
                else if(frame < 6 * delay){
                    setImage(zombieGirlLeft6);
                    frame = 1;
                }
            }
            //Back to left and repeats process
            else{
                zombieGirlLeft1 = new GreenfootImage("zombieGirlWalkLeft0001.png");
                zombieGirlLeft2 = new GreenfootImage("zombieGirlWalkLeft0002.png");
                zombieGirlLeft3 = new GreenfootImage("zombieGirlWalkLeft0003.png");
                zombieGirlLeft4 = new GreenfootImage("zombieGirlWalkLeft0004.png");
                zombieGirlLeft5 = new GreenfootImage("zombieGirlWalkLeft0005.png");
                zombieGirlLeft6 = new GreenfootImage("zombieGirlWalkLeft0006.png");
                walkTime = 0;
            }
        }
    }
   
    
    public void hitByPlayer(){  //When a Bullet intersects the enemy's image, the enemy loses health.
                                //If health is zero, the enemy has a dying image facing in the direction it was facing
                                //earlier and adds to score.
                                
        //Basically isTouching but more precise
        Actor leftProjectile = getOneIntersectingObject(LeftBullet.class);   //Look out for left Bullet object intersecting enemy
        Actor rightProjectile = getOneIntersectingObject(RightBullet.class); //Look out for right Bullet object intersecting enemy
        
        //Enemy is hit with left Bullet
        if((leftProjectile != null) && !damaged){
            health--;
            counter.score++;    //Hits = increase score
            damaged = true;
            getWorld().removeObject(leftProjectile);    //Remove Bullet
        }
        //Enemy is hit with right Bullet
        else if((rightProjectile != null) && !damaged){
            health--;
            counter.score++;
            damaged = true;
            getWorld().removeObject(rightProjectile);
        }
        //Double check that no Bullets hitting the enemy means it's not hit
        else if(!isTouching(LeftBullet.class) || !isTouching(RightBullet.class)){
            damaged = false;
        }
        
        //Erase object when it is defeated
        if(health <= 0){
            moan.stop();
            getWorld().removeObject(this);
        }
    }
}

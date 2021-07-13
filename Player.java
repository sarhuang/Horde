/**
 * Program: Player.java
 * Purpose: The class definition for the player. You can move left and right, jump, and shoot bullets.
 *          The player's health and hit boxes are defined here too.
 * 
 * Zombie Bite FX Source: http://soundbible.com/950-Bite.html
 * Gunshot: http://soundbible.com/1547-M1-Garand-Single.html
 * Shell Falling: http://soundbible.com/2072-Shell-Falling.html
 *
 */

import greenfoot.*;  
public class Player extends Actor
{
    //Initializing player sprites
    private GreenfootImage playerRight = getImage();
    private GreenfootImage playerRight2 = new GreenfootImage("playerlWalkRight0002.png");
    private GreenfootImage playerRight3 = new GreenfootImage("playerlWalkRight0003.png");
    private GreenfootImage playerRight4 = new GreenfootImage("playerlWalkRight0004.png");
    private GreenfootImage playerRight5 = new GreenfootImage("playerlWalkRight0005.png");
    private GreenfootImage playerRight6 = new GreenfootImage("playerlWalkRight0006.png");
    
    private GreenfootImage playerLeft = new GreenfootImage("playerlWalkLeft0001.png");
    private GreenfootImage playerLeft2 = new GreenfootImage("playerlWalkLeft0002.png");
    private GreenfootImage playerLeft3 = new GreenfootImage("playerlWalkLeft0003.png");
    private GreenfootImage playerLeft4 = new GreenfootImage("playerlWalkLeft004.png");
    private GreenfootImage playerLeft5 = new GreenfootImage("playerlWalkLeft0005.png");
    private GreenfootImage playerLeft6 = new GreenfootImage("playerlWalkLeft0006.png");
    
  
    private int cooldownTime = 0;   //Timer for how often player can shoot bullets
    final int GROUND_LEVEL = 400;   //The y-coordinate for the "ground"
    
    private boolean facingRight;
    private boolean facingLeft;
    
    private int frame = 0;      //Used to cycle through images for animation
    private int delay = 8;      //How long each image lasts for animation
    
    GreenfootSound bulletDrop = new GreenfootSound("bullet_shot.mp3");
    GreenfootSound bullet = new GreenfootSound("shell_fall.mp3");
    GreenfootSound bite = new GreenfootSound("zombie_hurt.mp3");
    
    
    public Player(){ //Sets correct size of player when game starts
        setImage(playerRight);
        facingRight = false;
        facingLeft = false;
    }

    public void act() //Allows player to move and jump with arrow keys and spacebar and check for collisions
    {
        move();
        hitByEnemy();
    }    
    
    
    public void move()  //Player can move the girl depending on the arrow keys. Player must hold down arrow keys while
                        //shooting with spacebar to determine the direction the bullet moves.
    {
        if (Greenfoot.isKeyDown("right")) {
            facingRight = true;
            facingLeft = false;
            frame++;   
            
            playerRight = getImage();
            playerRight2 = new GreenfootImage("playerlWalkRight0002.png");
            playerRight3 = new GreenfootImage("playerlWalkRight0003.png");
            playerRight4 = new GreenfootImage("playerlWalkRight0004.png");
            playerRight5 = new GreenfootImage("playerlWalkRight0005.png");
            playerRight6 = new GreenfootImage("playerlWalkRight0006.png");
            
            
            if(frame < 1 * delay)
                setImage(playerRight);
            else if(frame < 2 * delay)
                setImage(playerRight2);
            else if(frame < 3 * delay)
                setImage(playerRight3);
            else if(frame < 4 * delay)
                setImage(playerRight4);
            else if(frame < 5 * delay)
                setImage(playerRight5);
            else if(frame < 6 * delay){
                setImage(playerRight6);
                frame = 1;
            }
            setLocation(getX() + 4, getY());

            //Hold down right key and space to shoot right unless cooldown activated
            if (cooldownTime > 0) 
                cooldownTime--;
                
            if ("space".equals(Greenfoot.getKey()) && cooldownTime == 0){
                //Slimeball facing right is created
                RightBullet rBullet = new RightBullet();
                getWorld().addObject(rBullet, getX() + 80, getY() - 75);
                bullet.play();
                bulletDrop.play();
                cooldownTime = 30;
            }
        }
        else if(Greenfoot.isKeyDown("left")) {
            facingRight = false;
            facingLeft = true;
            frame++; 
            
            playerRight = new GreenfootImage("playerlWalkLeft0001.png");
            playerRight2 = new GreenfootImage("playerlWalkLeft0002.png");
            playerRight3 = new GreenfootImage("playerlWalkLeft0003.png");
            playerRight4 = new GreenfootImage("playerlWalkLeft004.png");
            playerRight5 = new GreenfootImage("playerlWalkLeft0005.png");
            playerRight6 = new GreenfootImage("playerlWalkLeft0006.png");
          
            
            if(frame < 1 * delay)
                setImage(playerRight);
            else if(frame < 2 * delay)
                setImage(playerRight2);
            else if(frame < 3 * delay)
                setImage(playerRight3);
            else if(frame < 4 * delay)
                setImage(playerRight4);
            else if(frame < 5 * delay)
                setImage(playerRight5);
            else if(frame < 6 * delay){
                setImage(playerRight6);
                frame = 1;
            }
            
            setLocation(getX() - 4, getY());  
            
            //Hold down left key and space to shoot left unless cooldown activated
            if (cooldownTime > 0) 
                cooldownTime--;

            if ("space".equals(Greenfoot.getKey()) && cooldownTime == 0)
            {
                //Slimeball facing right is created
                LeftBullet lBullet = new LeftBullet();
                getWorld().addObject(lBullet, getX() - 80, getY() - 75);
                bullet.play();
                bulletDrop.play();
                cooldownTime = 30;
            }
        }
    }
    
    
    public boolean hitByEnemy() //Returns true or false to the health bar if it intersects enemy
    {
        //Basically isTouching but better
        Actor zombie = getOneObjectAtOffset(0, 0, Enemy.class); //If the enemy touches the center of the player
        //Enemy touches player
        if (zombie != null) {
            bite.play();
            return true;
        }
        else{
            return false;
        }
    }
}

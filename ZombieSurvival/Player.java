import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        int speed = 4;
        int time =0;
        Weapon weapon;
        SuperPower superPower;
        int superTimer;
        int animateSpeed = 100;
        int frame = 0;
        int count;
        //GreenfootSound bgm = new GreenfootSound("Music1.mp3");
    public Player(){
        setImage("survivor-move_rifle_0.png");
        getImage().scale(80,80);
    }
    public Player(Weapon weapon, SuperPower superPower){
        this.weapon = weapon;
        this.superPower = superPower;
        setImage("survivor-move_rifle_0.png");
        getImage().scale(80,80);
    }
    public void animate(){
        if(count % animateSpeed == 0){
            if(frame > 19){
                frame = 0;
            }
            setImage("survivor-move_rifle_"+frame+".png");
            frame++;
            getImage().scale(80,80);
        }
    }
    public void act()
    {
        time++;
        turnAround();
        moveAround();
        checkCollision();
        fireProjectile();
        superPowerUsed();
        hitByZombie();
        animate();
        //bgm.playLoop();
    }
    public void turnAround(){
        if(Greenfoot.getMouseInfo() != null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
    public void moveAround(){
        if(Greenfoot.isKeyDown("w"))
        setLocation(getX(),getY()-speed);
        if(Greenfoot.isKeyDown("s"))
        setLocation(getX(),getY()+speed);
        if(Greenfoot.isKeyDown("a"))
        setLocation(getX()-speed,getY());
        if(Greenfoot.isKeyDown("d"))
        setLocation(getX()+ speed, getY());
    }
    public void fireProjectile(){
        int projectileDistance = 50;
        if(Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 1){
            int projectileX = (int)(getX() + 10 + projectileDistance * Math.cos(Math.toRadians(getRotation())));
            int projectileY = (int)(getY() + projectileDistance * Math.sin(Math.toRadians(getRotation())));
            Greenfoot.playSound("GunShoot.mp3");
            Projectile projectile = new Projectile(0);
            getWorld().addObject(projectile, projectileX, projectileY);
            projectile.setRotation(getRotation());
            projectile.move(25);
        }
        if(Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 2){
        int projectileX = (int)(getX() + projectileDistance * Math.cos(Math.toRadians(getRotation())));
        int projectileY = (int)(getY() + projectileDistance * Math.sin(Math.toRadians(getRotation())));
        Greenfoot.playSound("GunShoot.mp3");
        Projectile projectile = new Projectile(0);
        getWorld().addObject(projectile, projectileX, projectileY);
        projectile.setRotation(getRotation()-10);
        projectile.move(20);
        Greenfoot.playSound("GunShoot.mp3");
        Projectile projectile2 = new Projectile(0);
        getWorld().addObject(projectile2, projectileX, projectileY);
        projectile2.setRotation(getRotation()+10);
        projectile2.move(20);
        }
        if(Greenfoot.mousePressed(null) && weapon.weaponUpgrade == 3){
        int projectileX = (int)(getX() + projectileDistance * Math.cos(Math.toRadians(getRotation())));
        int projectileY = (int)(getY() + projectileDistance * Math.sin(Math.toRadians(getRotation())));
        Greenfoot.playSound("GunShoot.mp3");
        Projectile projectile = new Projectile(0);
        getWorld().addObject(projectile, projectileX, projectileY);
        projectile.setRotation(getRotation()-10);
        projectile.move(20);
        Greenfoot.playSound("GunShoot.mp3");
        Projectile projectile2 = new Projectile(0);
        getWorld().addObject(projectile2, projectileX, projectileY);
        projectile2.setRotation(getRotation()+10);
        projectile2.move(20);
        Greenfoot.playSound("GunShoot.mp3");
        Projectile projectile3 = new Projectile(0);
        getWorld().addObject(projectile3, projectileX, projectileY);
        projectile3.setRotation(getRotation());
        projectile3.move(20);
        }   
    }
    public void superPowerUsed(){
        if(superPower.superCount > 99 && superTimer < 30){
        Projectile projectile = new Projectile(0);
        getWorld().addObject(projectile, getX(),getY());
        projectile.setRotation(getRotation()-60);
        projectile.move(20);
        Projectile projectile2 = new Projectile(0);
        getWorld().addObject(projectile2, getX(),getY());
        projectile2.setRotation(getRotation()+60);
        projectile2.move(20);
        Projectile projectile3 = new Projectile(0);
        getWorld().addObject(projectile3, getX(),getY());
        projectile3.setRotation(getRotation());
        projectile3.move(20);
        Projectile projectile4 = new Projectile(0);
        getWorld().addObject(projectile4, getX(),getY());
        projectile4.setRotation(getRotation()-180);
        projectile4.move(20);
        Projectile projectile5 = new Projectile(0);
        getWorld().addObject(projectile5, getX(),getY());
        projectile5.setRotation(getRotation()+120);
        projectile5.move(20);
        Projectile projectile6 = new Projectile(0);
        getWorld().addObject(projectile6, getX(),getY());
        projectile6.setRotation(getRotation()-120);
        projectile6.move(20);
        superTimer++;
        }
        if(superTimer > 29){
            Greenfoot.playSound("SuperPower.mp3");
            superPower.superCount = 0;
            superTimer = 0;
        }
    }
    public boolean hitByZombie(){
        Actor zombie = getOneObjectAtOffset(0,0,Zombie.class);
        if(zombie != null){
            return true;
        }else
            return false;
    }
    public void checkCollision(){
        Actor wall = getOneIntersectingObject(Wall.class);
        if (wall != null)
        {
            int playerX = getX();
            int playerY = getY();
            int wallX = wall.getX();
            int wallY = wall.getY();
            if (playerX == wallX)
            {
                if (playerY > wallY)
                {
                    setLocation(playerX, wallY + 1);
                }
                else
                {
                    setLocation(playerX, wallY - 1);
                }
            }
            else if (playerY == wallY)
            {
                if (playerX > wallX)
                {
                    setLocation(wallX + 1, playerY);
                }
                else
                {
                    setLocation(wallX - 1, playerY);
                }
            }
        }
    }
}

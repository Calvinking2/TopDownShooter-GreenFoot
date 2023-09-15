import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int frame = 0;
    int count;
    int animateSpeed = 5;
    int health = 3;
    Player player;
    Counter counter;
    public Zombie(Player mainPlayer,Counter counter){
        this.counter = counter;
        player = mainPlayer;
        setImage("skeleton-idle_16.png");
        getImage().scale(80,80);
    }
    public void act()
    {
        count++;
        animate();
        moveAround();
        hitByProjectile();
        
    }
    //animate zombie
    public void animate(){
        if(count % animateSpeed == 0){
            if(frame > 16){
                frame = 0;
            }
            setImage("skeleton-move_"+frame+".png");
            frame++;
            getImage().scale(80,80);
        }
    }
    public void moveAround(){
        move(1);
        turnTowards(player.getX(),player.getY());
    }
    public void hitByProjectile(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null){
            health--;
            getWorld().removeObject(projectile);
        }
        if(health == 0){
        counter.score++;
        counter.money+=5;
        getWorld().removeObject(this);
        }

    }
}

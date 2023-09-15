import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperPower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperPower extends Actor
{
    /**
     * Act - do whatever the SuperPower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    final int superBarLimit = 100;
    int superCount;
    int count;
    public SuperPower(){
        setImage(new GreenfootImage(superBarLimit+2,12));
        getImage().drawRect(0,0,superBarLimit+1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,superCount,10);
        
    }
    public void act()
    {
        setImage(new GreenfootImage(superBarLimit+2,12));
        getImage().drawRect(0,0,superBarLimit+1,11);
        getImage().setColor(Color.BLUE);
        getImage().fillRect(1,1,superCount,10);
        World world=getWorld();
        MyWorld myWorld = (MyWorld)world;
        setLocation(myWorld.getPlayer().getX()+10,myWorld.getPlayer().getY()-80);
        useSuper();
    }
    public void useSuper(){
        count++;
        if(count%20 == 0)
        superCount++;
    }
}

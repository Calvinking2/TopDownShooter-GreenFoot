import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Counter counter;
    int weaponUpgrade = 1;
    public Weapon(Counter counter){
        this.counter = counter;
        setImage(new GreenfootImage("Weapon Upgrade \n 250", 25, Color.WHITE, new Color(0,0,0,0)));
        
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this) && counter.money >249){
            counter.money -= 250;
            weaponUpgrade++;
        }
        if(weaponUpgrade>3)
            weaponUpgrade = 3;
    }
}

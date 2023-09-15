import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Actor;

/**
 * Write a description of class MainMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{
    private GreenfootImage backgroundImage = new GreenfootImage("mainmenu.png");
    
    // Constructor for the main menu
    public MainMenu()
    {
        
        // Set the size of the world and the background image
        super(800, 600, 1);
        backgroundImage.scale(getWidth(), getHeight());
        setBackground(backgroundImage);
        
        // Create the start game button
        Actor startButton = new Button();
        startButton.setImage("Start.png");
        startButton.getImage().scale(200,200);
        addObject(startButton, getWidth()/2,getHeight()/2);
        
        
        // Create the quit button
        Actor quitButton = new Button();
        quitButton.setImage(new GreenfootImage("Quit", 50, Color.WHITE, new Color(0,0,0,0)));
        addObject(quitButton, getWidth()/2, getHeight()/2+200);
    }
    
    public void act()
    {
        // Check if the player clicked on a button
        if (Greenfoot.mouseClicked(null))
        {
            // Get the mouse position
            MouseInfo mouse = Greenfoot.getMouseInfo();
            int x = mouse.getX();
            int y = mouse.getY();
            
            // Check if the player clicked on the start game button
            if (x >= getWidth()/2-50 && x <= getWidth()/2+50 && y >= getHeight()/2-50 && y <= getHeight()/2+50)
            {
                // Set the world to the game world
                Greenfoot.setWorld(new MyWorld());
            }
            // Check if the player clicked on the instructions button
            // Check if the player clicked on the quit button
            else if (x >= getWidth()/2-50 && x <= getWidth()/2+50 && y >=  getHeight()/2-250 && y <=  getHeight()/2+250)
            {
                // Exit the game
                Greenfoot.stop();
            }
        }
    }
}

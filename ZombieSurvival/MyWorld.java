import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class MyWorld extends World
{ 

    int count = 0;
    int spawnSpeed = 50;
    int randomSpawn;
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    Weapon weapon = new Weapon(counter);
    SuperPower superPower = new SuperPower();
    private GreenfootImage backgroundImage = new GreenfootImage("Background.png");
    GreenfootSound bgm = new GreenfootSound("Music1.mp3");
    boolean doOne = true;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        backgroundImage.scale(getWidth(), getHeight());
        setBackground(backgroundImage);
        Greenfoot.setWorld(new MainMenu());
        mainPlayer = new Player(weapon, superPower);
        addObject(mainPlayer, getWidth()/2,getHeight()/2);
        addObject(counter, 130,100);
        addObject(healthbar, mainPlayer.getX() - 5, mainPlayer.getY() - 50);
        addObject(weapon, 900,100);
        addObject(superPower, mainPlayer.getX()+10, mainPlayer.getY()-80);

        //addObject(new Wall(), getWidth()/2, 0);
        //addObject(new Wall(), getWidth()/2, getHeight());
        //addObject(new Wall(), 0, getHeight()/2);
        //addObject(new Wall(), getWidth(), getHeight()/2);

        //addObject(new Wall(), mainPlayer.getX()+10, mainPlayer.getY()-80);
        prepare();
    }

    public Player getPlayer(){
        return mainPlayer;
    }

    public void act(){
        count++;
        if(count % 600 ==0){
            spawnSpeed--;
        }
        while(Greenfoot.isKeyDown("p")){
            Greenfoot.delay(1);
        }
        while(Greenfoot.isKeyDown("m")){
            bgm.stop();
            Greenfoot.setWorld(new MainMenu());
        }
        SpawnZombie();
        Start();
    }
    public void Start(){
        if(doOne == true){
            bgm.playLoop();
            doOne = false; 
        }
    }
    public void SpawnZombie(){
        if(count % spawnSpeed == 0){
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch(randomSpawn){
                case 0: addObject(new Zombie(mainPlayer,counter),0,0);
                    break;
                case 1: addObject(new Zombie(mainPlayer,counter),getWidth()/2,0);
                    break;
                case 2: addObject(new Zombie(mainPlayer,counter),getWidth(),0);
                    break;
                case 3: addObject(new Zombie(mainPlayer,counter),0,getWidth()/2);
                    break;
                case 4: addObject(new Zombie(mainPlayer,counter),getWidth(),getHeight()/2);
                    break;
                case 5: addObject(new Zombie(mainPlayer,counter),0,getHeight());
                    break;
                case 6: addObject(new Zombie(mainPlayer,counter),getWidth()/2,getHeight());
                    break;
                case 7: addObject(new Zombie(mainPlayer,counter),getWidth(),getHeight());
                    break;
            }
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Wall wall = new Wall(100, 10);
        addObject(wall,576,258);
        wall.setLocation(597,255);
        Wall wall2 = new Wall(30, 10);
        addObject(wall2,418,254);
        wall2.setLocation(415,256);
        Wall wall3 = new Wall(30, 10);
        addObject(wall3,768,260);
        wall3.setLocation(788,256);

        WallH wallH = new WallH(10, 220);
        addObject(wallH,797,352);
        wallH.setLocation(795,378);
        WallH wallH2 = new WallH(10, 250);
        addObject(wallH2,379,348);
        wallH2.setLocation(380,371);
        wallH2.setLocation(397,375);
        Wall wall4 = new Wall(135, 10);
        addObject(wall4,727,491);
        wall4.setLocation(464,518);
        Wall wall5 = new Wall(120, 10);
        addObject(wall5,719,498);
        wall5.setLocation(734,518);
        WallH wallH3 = new WallH(10, 150);
        addObject(wallH3,76,616);
        wallH3.setLocation(60,639);
        WallH wallH4 = new WallH(10, 150);
        addObject(wallH4,1078,626);
        wallH4.setLocation(1078,639);
        WallH wallH5 = new WallH(10, 150);
        addObject(wallH5,1080,107);
        wallH5.setLocation(1093,147);
        WallH wallH6 = new WallH(10, 150);
        addObject(wallH6,129,164);
        wallH6.setLocation(53,138);
        Wall wall6 = new Wall(150, 10);
        addObject(wall6,983,625);
        wall6.setLocation(1001,708);
        Wall wall7 = new Wall(150, 10);
        addObject(wall7,155,670);
        wall7.setLocation(128,708);
        Wall wall8 = new Wall(150, 10);
        addObject(wall8,144,60);
        wall8.setLocation(119,66);
        Wall wall9 = new Wall(150, 10);
        addObject(wall9,974,100);
        wall9.setLocation(1025,67);
        WallH wallH7 = new WallH(10, 60);
        addObject(wallH7,224,678);
        wallH7.setLocation(234,688);
        Wall wall10 = new Wall(40, 10);
        addObject(wall10,116,565);
        wall10.setLocation(84,566);
        WallH wallH8 = new WallH(50, 10);
        addObject(wallH8,108,202);
        wallH8.setLocation(80,205);
        WallH wallH9 = new WallH(40, 10);
        addObject(wallH9,1046,215);
        wallH9.setLocation(1068,216);
        WallH wallH10 = new WallH(10, 40);
        addObject(wallH10,888,685);
        wallH10.setLocation(898,698);
    }
}

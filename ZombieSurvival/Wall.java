import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    public Wall(int x, int y){
        getImage().scale(x,y);
        GreenfootImage img = new GreenfootImage(x, y);
        img.setColor(new Color(0,0,0));
        setImage(img);

    }
    public void act() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        Zombie zombie = (Zombie) getOneIntersectingObject(Zombie.class);
        if (player != null) {
            int playerX = player.getX();
            int playerY = player.getY();
            int wallX = getX();
            int wallY = getY();

            //if (playerX <= wallX) {
                //player.setLocation(wallX - 5, playerY);
            //} else if (playerX >= wallX) {
                //player.setLocation(wallX + 5, playerY);
            //}
            if (playerY <= wallY) {
                player.setLocation(playerX, wallY - 65);
            } else if (playerY >= wallY) {
                player.setLocation(playerX, wallY +65);
            }
        }
        if (zombie != null) {
            int zombieX = zombie.getX();
            int zombieY = zombie.getY();
            int wallX = getX();
            int wallY = getY();

            //if (playerX <= wallX) {
                //player.setLocation(wallX - 5, playerY);
            //} else if (playerX >= wallX) {
                //player.setLocation(wallX + 5, playerY);
            //}
            if (zombieY <= wallY) {
                zombie.setLocation(zombieX, wallY - 65);
            } else if (zombieY >= wallY) {
                zombie.setLocation(zombieX, wallY +65);
            }
        }
    }
}

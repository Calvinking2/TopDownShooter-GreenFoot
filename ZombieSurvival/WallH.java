import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WallH here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallH extends Actor
{
       public WallH(int x, int y){
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

            if (playerX <= wallX) {
                player.setLocation(wallX - 55, playerY);
            } else if (playerX >= wallX) {
                player.setLocation(wallX + 55, playerY);
            }
            //if (playerY <= wallY) {
                //player.setLocation(playerX, wallY - 65);
            //} else if (playerY >= wallY) {
                //player.setLocation(playerX, wallY +65);
            //}
        }
        if (zombie != null) {
            int zombieX = zombie.getX();
            int zombieY = zombie.getY();
            int wallX = getX();
            int wallY = getY();

            if (zombieX <= wallX) {
                zombie.setLocation(wallX - 55, zombieY);
            } else if (zombieX >= wallX) {
                zombie.setLocation(wallX + 55, zombieY);
            }
            //if (playerY <= wallY) {
                //player.setLocation(playerX, wallY - 65);
            //} else if (playerY >= wallY) {
                //player.setLocation(playerX, wallY +65);
            //}
        }
    }
}

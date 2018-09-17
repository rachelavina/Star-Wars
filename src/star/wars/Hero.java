package star.wars;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

/**
 *
 * @author Rachel Avina
 */
public class Hero extends Character {
    
    private int health;
    
    //Constructor
    public Hero ()  {//no-args
        super();
        health = 3;
    }
    
    public Hero (int x, int y, Color color, int size, String name)  {
        super(x, y, color, size, name);
        health = 3;
    }
   
    //Getters
    public int getHealth ()    {
        return health;
    }
    
    //Public Methods
    public void collect()    {
        
    }
    
    public void teleport() {
        
    }
    
    //Private Methods
    private void grow() {
        
    }
    
    private void canTeleport() {
        
    }
}

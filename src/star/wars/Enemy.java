
package star.wars;

import java.awt.Color;

/**
 *
 * @author Rachel Avina
 */
public class Enemy extends Character    {
     //Constructor
    public Enemy ()  {
        super(); 
    }
     public Enemy (int x, int y, Color color, int size, String name)  {
        super(x, y, color, size, name);
     }
     
     @Override
     public void update()   {
        super.setDx( (int) (Math.random()*10) - 4);
        super.setDy( (int) (Math.random()*10) - 4);
        super.update();
     }
    
}

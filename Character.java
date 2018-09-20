
package star.wars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;

/**
 *
 * @author Rachel Avina
 */
public class Character {
    //Fields (Variables)
    private int x; 
    private int y;
    private int dx;
    private int dy;
    private Color color;
    private int size;
    private Shape shape;
    private String name;
    
    
    //Constructor
    public Character()  {//no-args
        x = 0;
        y = 0;
        dx =0;
        dy =0;
        color = Color.BLUE;
        size = 20;
        name = "enemy";
        
    }
    
    public Character(int x, int y, Color color, int size, String name)  {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
        this.name = name;
        dx =0;
        dy =0;
        
    }
    
    public Character(int x, int y)  {
        this.x = x;
        this.y = y;
        color = Color.BLUE;
        size = 20;
        name = "hero";
        
    }
    
    //Getters
    public int getX () {
        return x;
    }
    
    public int getY ()   {
        return y;
    }
    
    public Color getColor ()   {
        return color;
    }
    
    public int getSize ()  {
        return size;
    }
    
    public Shape getShape ()   {
        return shape;
    }
    
    public String getName ()   {
        return name;
    }
    
    //Setters
    public void setX (int x)  {
        this.x = x;
    }
    
    public void setY (int y)    {
        this.y = y;
    }
    
    public void setDx (int dx)  {
        this.dx = dx;
    }
    
    public void setDy (int dy)  {
        this.dy = dy;
    }
    
    public void setColor (Color color)  {
        this.color = color;
    }
    
    public void setSize (int size)  {
        this.size = size;
    }
    
    public void setName (String name)   {
        this.name = name;
    }
    
    //Public Methods
    public void draw (Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
    
    public void kill (Character c) {
        c.setSize(0);
    }
                        //1     //-1
    public void move (int dx, int dy) { 
        
        x += dx * 3;
        y += dy * 3;
    }

    //Private Methods
     public void update ()   {
        move(dx, dy);
    }
   
    public void reverseX()  {
        dx = -dx;
        move(2 * dx, 2 * dy);
            
        
    }
    public void reverseY()  {
        dy = -dy;
        move(2 * dx, 2 * dy);
        
    }
    
    private void grow()  {
        size *= 1.05;
    }
}


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
    //private int dsize;
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
        //dsize = 0;
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
        //dsize = 0;
        
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
    
    /*public void setDsize (int dsize)    {
        this.dsize = dsize;
    }*/
    
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
        g.fillOval(x, y, size, size);
    }
    
    public void kill () {
        grow();
    }
                        //1     //-1
    public void move (int dx, int dy) { 
        
        x += dx * 3;
        y += dy * 3;
    }

    //Private Methods
    /*private void grow (int dsize) {
        //size *= dsize * 1.05;
    }*/
    
     public void update ()   {
        move(dx, dy);
    }
   
    public void reverseX(int dx)  {
        x *= dx * -2;
            
        
    }
    public void reverseY(int dy)  {
        y *= dy * -2;
        
    }
    
    private void grow()  {
        size *= 1.05;
    }
}

package star.wars;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;


public class Space extends JPanel   {

    final int marginX;
    final int marginY;
    private Hero hero;
    private Enemy enemy;
    private Timer timer;
    
    public Space()  {
        super();

        marginX = 10;
        marginY = 10;
        hero = new Hero(600, 480, Color.BLUE, 20, "Steve");
        enemy = new Enemy(50, 50, Color.RED, 20, "Brad");
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 50);
    }
    
    
    public void paintComponent(Graphics g)   {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        g.setColor(Color.WHITE);
        drawStars(g);
        
        hero.draw(g);
        
        enemy.draw(g);
        
        //g.dispose();
    }

    private class ScheduleTask extends TimerTask    {
        
        @Override
        public void run()   {
           wallCollissions(hero);
           wallCollissions(enemy);
           heroVsEnemy(enemy);
           heroVsEnemy(hero);
            hero.update();
            enemy.update();
            repaint();
        }
    }
    
    public void keyPressed(KeyEvent e)    {
        if (e.getKeyCode()== KeyEvent.VK_RIGHT)   {
            hero.setDx(3);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.setDx(-3);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.setDy(3);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP)   {
            hero.setDy(-3);
        }
            //super-speed
        else if (e.getKeyCode()== KeyEvent.VK_A )    {
            hero.setDx(-10);
        }
        else if (e.getKeyCode()== KeyEvent.VK_S)    {
            hero.setDy(10);
        }
        else if (e.getKeyCode()== KeyEvent.VK_D)    {
            hero.setDx(10);
        }
        else if (e.getKeyCode()== KeyEvent.VK_W)    {
            hero.setDy(-10);
        }
        //hero grow
        if (e.getKeyCode()== KeyEvent.VK_ALT)   {
            hero.setSize(50);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT);
            hero.setDx(0);
            
        if(e.getKeyCode() == KeyEvent.VK_LEFT);
            hero.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_UP);
            hero.setDy(0);
            
        if (e.getKeyCode() == KeyEvent.VK_DOWN);
            hero.setDy(0);
            
        if (e.getKeyCode() == KeyEvent.VK_S);
            hero.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_A);
            hero.setDx(0);
            
        if (e.getKeyCode() == KeyEvent.VK_S);
            hero.setDy(0);
            
        if (e.getKeyCode() == KeyEvent.VK_W);
            hero.setDy(0);
        //hero grow
        if (e.getKeyCode()== KeyEvent.VK_ALT)   {
            hero.setSize(20);
        }
       
        
    }
    
    
    

    
    private void drawStars(Graphics g)  {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 200; i++)  {
       
            //random X and Y were made here
        int randX = (int) (Math.random() * 1200.0) + 1;
        int randY = (int) (Math.random() * 900.0) +1;
        
        int randSizeX = (int) (Math.random() * 5.0) +1;
        
            //code for different random X and Y sizes
        //int randSizeY = (int) (Math.random() * 5.0) +1;
                
        int numStars = 0;
            
            x = randX;
            y = randY;
            g.fillOval(randX, randY, randSizeX, randSizeX);
            
            System.out.println(x + " " + y);
            if ( x > 1200 || y > 960 )  {
                break;
            }
        }
    }
    
    private void heroVsEnemy (Character c)  {
        
        if (enemy.getX() == hero.getX() && enemy.getY() == hero.getY()) {
            c.kill(enemy);
        }
        
        if (enemy.getX() <= hero.getX()&& hero.getX() <= enemy.getX() + 3) {
            c.kill(enemy);
        }
        if (enemy.getY() <= hero.getY() && hero.getY() <= enemy.getY() + 3)    {
            c.kill(enemy);
        }
        if (enemy.getX() == hero.getX() + 4)   {
            c.kill(enemy);
        }
        if (enemy.getY() == hero.getY() + 4)    {
            c.kill(enemy);
        }
        
    }
    
    private void wallCollissions(Character c)   {
        //this.getWidth();
        //this.getHeigth();

        
        if (c.getX() <= 0 || c.getX() + 20 >= this.getWidth())   {
            c.reverseX();
    }

        if (c.getY() <= 0 || c.getY() + 20 >= this.getHeight())    {
            c.reverseY();
        }         
    }
    
    
    }

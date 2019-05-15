/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Master extends Thread {
    private int x,z;
    private int y;
    private int xArah;
    private int yArah;
    static int skor = BerburuIkan.skor;     
      Master() {
        x = 0;
        y = 90;       
    }
    public int getX(){return x;}
   public int getY(){return y;}
   public void setY(int set)
   {
       y=set;
   }
   public void setX(int set)
   {
       x=set;
   }
   public Rectangle getPosisi() {
        int pp = 0,l = 0;
        if(skor<100){pp=15;l=15;}
        else if(skor<200){pp=20;l=20;}
        else if(skor<300){pp=25;l=25;}
        else if(skor<400){pp=30;l=30;}
        else if(skor<500){pp=35;l=35;}
        return new Rectangle(getX(), getY(), pp, l);
       
    }
    @Override
    public void run() {
        if(skor<100){z=28;}
        else if(skor<200){z=25;}
        else if(skor<300){z=22;}
        else if(skor<400){z=19;}
        else if(skor<500){z=15;}
         Random rng = new Random();
        xArah = -1 + rng.nextInt(4);
        yArah = -1 + rng.nextInt(3);
        while (true) {
            move();
            try {
                Thread.sleep(z);
            } catch (InterruptedException ex) {
                System.err.println("Error: Thread Interrupted.");
            }
        }
    }
    
    public void move() {
        x += xArah;
        y += yArah;
        if (x <= 0)
            xArah = 1;
        if (x >= 901)
            xArah = -1;
        if (y < 0)
            yArah = 1;
        if (y > 701)
            yArah = -1;
    }
    public void draw(Graphics g) {
       
    }

}

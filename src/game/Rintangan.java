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
public class Rintangan extends Thread{
    private int x,z;
    private int y;
    private int xArah;
    private int yArah;
    static boolean status = false; 
     Rintangan () {
        x = 500;
        y = 0;
       
    }
    public int getX(){return x;}
   public int getY(){return y;}
   void setY(int set){y=set;}
   void setX(int set){x=set;}
    @Override
    public void run() {
        Random rng = new Random();
        xArah = rng.nextInt(2);
        yArah = 1 + rng.nextInt(3);
        while (true) {
            move();
            try {
                Thread.sleep(20);
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

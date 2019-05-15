/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.MakananDua.skor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author USER
 */
public class RintanganSatu extends Rintangan{
  
   Rectangle getPosisi() {        
        return new Rectangle(getX(), getY(),20,20);
       
    }
    @Override
    public void draw(Graphics g) {
        Image s = new ImageIcon(this.getClass().getResource("l1mati.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
    }
}

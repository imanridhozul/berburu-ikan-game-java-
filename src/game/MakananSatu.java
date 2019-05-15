/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.MakananDua.skor;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author user
 */
public class MakananSatu extends Master {
    public static boolean statusMakanan = false;
    private boolean xx = false;
   
    @Override
    public void draw(Graphics g) {
	Image s = null;	 
     if(getX() >= 900){xx=true;}if(getX()==0){xx=false;}
        if(skor<110){
            
            if(xx == true){    
                 s = new ImageIcon(this.getClass().getResource("fish1kiri.png")).getImage();                 
            }
            else{
                 s = new ImageIcon(this.getClass().getResource("fish1.png")).getImage();                 
            }
     
        }
        else if(skor<210){
            
            if(xx == true){    
                 s = new ImageIcon(this.getClass().getResource("fish2kiri.png")).getImage();                
            }
            else{
                s = new ImageIcon(this.getClass().getResource("fish2.png")).getImage();
            }
     
        }
        else if(skor<310){
            
            if(xx == true){    
                  s = new ImageIcon(this.getClass().getResource("fish3kiri.png")).getImage();
            }
            else{
                 s = new ImageIcon(this.getClass().getResource("fish3.png")).getImage();
            }
     
        }
        else if(skor<=410){
            
            if(xx == true){    
                  s = new ImageIcon(this.getClass().getResource("fish4kiri.png")).getImage();
            }
            else{
                 s = new ImageIcon(this.getClass().getResource("fish4.png")).getImage();
            }
     
        }/*
        else {
            
            if(xx == true){    
                  s = new ImageIcon(this.getClass().getResource("f1sh5kiri.png")).getImage();
            }
            else{
                 s = new ImageIcon(this.getClass().getResource("fish5.png")).getImage();
            }
            
        }*/
        g.drawImage(s, getX(), getY(), null);
       
    }
}
    


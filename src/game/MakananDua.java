/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author user
 */
public class MakananDua extends Master {  
   private boolean xx = false;
   
    @Override
    public void draw(Graphics g) {
     if(getX() >= 900){xx=true;}if(getX()==0){xx=false;}
        if(skor<110){
            
            if(xx == true){    
                 Image s = new ImageIcon(this.getClass().getResource("fish2kiri.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
            else{
                Image s = new ImageIcon(this.getClass().getResource("fish2.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
     
        }
        else if(skor<210){
            
            if(xx == true){    
                 Image s = new ImageIcon(this.getClass().getResource("fish3kiri.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
            else{
                Image s = new ImageIcon(this.getClass().getResource("fish3.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
     
        }
        else if(skor<310){
            
            if(xx == true){    
                 Image s = new ImageIcon(this.getClass().getResource("fish4kiri.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
            else{
                Image s = new ImageIcon(this.getClass().getResource("fish4.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
     
        }
        else if(skor<=410){
            
            if(xx == true){    
                 Image s = new ImageIcon(this.getClass().getResource("fish5kiri.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
            else{
                Image s = new ImageIcon(this.getClass().getResource("fish5.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
     
        }/*
        else {
            
            if(xx == true){    
                 Image s = new ImageIcon(this.getClass().getResource("lvl5mshk.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
            else{
                Image s = new ImageIcon(this.getClass().getResource("lvl5msh.png")).getImage();
                 g.drawImage(s, getX(), getY(), null);
            }
     
        }*/
       
     }
      
}
    


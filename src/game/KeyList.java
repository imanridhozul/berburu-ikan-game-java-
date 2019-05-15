/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.BerburuIkan.gerak;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Alan
 */
    public class KeyList extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int xx = e.getKeyCode();
            if(xx == KeyEvent.VK_UP)
            {
                BerburuIkan.yArah = -2;
            }
            else if(xx == KeyEvent.VK_DOWN)
            {
                BerburuIkan.yArah = 2;
            }
            else if(xx == KeyEvent.VK_LEFT)
            {
                BerburuIkan.xArah = -2;
                BerburuIkan.arahPlayer = true;
                gerak++;
            }
            else if(xx == KeyEvent.VK_RIGHT)
            {
                BerburuIkan.xArah = 2;
                BerburuIkan.arahPlayer = false;
                gerak++;
            }/*
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    BerburuIkan.yArah = -2;
                    break;
                case KeyEvent.VK_DOWN:
                   BerburuIkan.yArah = 2;
                    break;
                case KeyEvent.VK_LEFT:
                    BerburuIkan.xArah = -2;
                    gerak++;
                    BerburuIkan.arahPlayer = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    xArah = 2;
                    gerak++;
                    BerburuIkan.arahPlayer = false;
                    break;               
                default:
                    break;
            }*/
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
            int xx = e.getKeyCode();
            if(xx == KeyEvent.VK_UP || xx == KeyEvent.VK_DOWN)
            {
                BerburuIkan.yArah = 0;
            }          
            else if(xx == KeyEvent.VK_LEFT || xx == KeyEvent.VK_RIGHT)
            {
                BerburuIkan.xArah = 0;
               
            }
           /*
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                    yArah = 0;
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    xArah = 0;
                    break;
                default:
                    break;
            }*/
        }
}

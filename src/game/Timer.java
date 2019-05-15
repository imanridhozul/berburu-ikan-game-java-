/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import static game.BerburuIkan.flag;
/**
 *
 * @author USER
 */
public class Timer extends Thread {
    public static int waktu;
    public static boolean statusRintangan = false;
    public static int waktuRintangan = 10;
    Timer(int w)
    {
        waktu = w;
    }
    @Override
    public void run() {
         while (flag != 0) {
            waktu--;                    
            try {
             
                Thread.sleep(300);
              
            } catch (InterruptedException ex) {
                System.err.println("Error: Thread Interrupted.");
            }
        }
        if(statusRintangan == true){
            while (waktuRintangan > 0) {
              waktuRintangan--;       


              try {
                  Thread.sleep(300);
              } catch (InterruptedException ex) {
                  System.err.println("Error: Thread Interrupted.");
              }
            }           
        } 
         statusRintangan = false;
         
    }
}

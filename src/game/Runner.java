/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author USER
 */
public class Runner extends Thread{
    BerburuIkan gh;
    public Runner(BerburuIkan x)
    {
        gh = x;
    }
    @Override
    public void run() {
         while (gh.getFlag() == 1) {
                gh.munculMusuh();
                gh.munculMakanan();
                gh.munculRintangan();
           
            try {
               
                Thread.sleep(4000);
                
            } catch (InterruptedException ex) {
                System.err.println("Error: Thread Interrupted.");
            }
        }
    }
}

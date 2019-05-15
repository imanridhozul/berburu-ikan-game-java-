/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Timer.waktu;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class BerburuIkan extends JFrame implements Runnable {
    private int x; //koordinat x
    public int speed; //untuk atur kecepatn
    private int y; //koordinat yaa
    public static int xArah; //mengubah x dan yy
    public static int yArah;
    public ArrayList<MakananDua> musuhs; //arraylist untuk musuh
    public ArrayList<MakananSatu> makananSatu; //arraylist untuk makanan
    public static boolean arahPlayer; //status arah player agar bisa draw kekiri
    public ArrayList<RintanganSatu> rintang; //arraylist rintangan
    static int flag; //penanda game ovet atau tidadk       
    private Image background;
    static int gerak;
 //   public Dimension size; //pengaturan jfarame
    public AudioClip soundTrack; //lagu
    public AudioClip soundTrack2; //lagu
    public static int skor = 0;
    private int acak = 0,acakmakanan1 = 0,acakRintangan = 0; //variabel menampung skor dan acak mengacak
   Image playerIkan;
    BerburuIkan() { //
        
//        setPreferredSize(size); 
        setSize(900, 675);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Berburu Ikan");
        
        x = 320;
        y = 240;
        xArah = 0;
        yArah = 0;
        addKeyListener(new KeyList());
        flag=1;
        musuhs = new ArrayList<MakananDua>();
        makananSatu = new ArrayList<MakananSatu>();      
        rintang = new ArrayList<RintanganSatu>();  
        background = new ImageIcon(this.getClass().getResource("10.png")).getImage();
        soundTrack = Applet.newAudioClip(getClass().getResource("mainm.wav"));
        soundTrack.loop();       
    }
    @Override
     public void run() {       
        
        while (flag !=0) { //selama status game over blum nol maka akan terus berjalan
            move(); //memanggil fungsi gerak
            
         
            for (int i = 0; i < makananSatu.size(); i++) {
                Rectangle posisiMakanan = makananSatu.get(i).getPosisi(); //mendapatkan posisi makanan dengan membuat rectangle pada koordinat x dan y
                Rectangle posisiPlayer = getPosisiPlayer();
           
                    if (posisiMakanan.intersects(posisiPlayer)) //jika makanan dan player behimpitan maka makanan di hapus. status makanan true
                    {   //untuk mendraaw gambar membuka mulut player
                        makananSatu.remove(i);
                        MakananSatu.statusMakanan = true;
                         skor +=10;
                         soundTrack2 = Applet.newAudioClip(getClass().getResource("eating.wav"));
                         soundTrack2.play();
                      }                      
                    else // jika tidak berhimpitan
                    {
                        MakananSatu.statusMakanan = false;
                    }
            }
            for (int i = 0; i < rintang.size(); i++) {
                Rectangle posisiRintangan = rintang.get(i).getPosisi();
                Rectangle posisiPlayer = getPosisiPlayer();
                if(rintang.get(i).getY() == 697) //jika objek rintangan sudah sampai paling bawah layar artinya sekitar koordinat 700 mka akan dihapus dari arraylist
                {
                    rintang.remove(i); //statement hapus
                }
                else{
                    //jika posisi player dan rintangan berhimpitan maka rintangan di hapus
                     if (posisiRintangan.intersects(posisiPlayer)) 
                     {
                        rintang.remove(i);
                        //status rintangan akan menjadi true agar dapat mengubah speed dari player
                        Timer.statusRintangan = true;
                       
                      }                      
                    else
                    {
                        //jika tidak berhiimpitan maka statusnya false,
                        Timer.statusRintangan = false;
                    }
                     //jika status  rintangan true maka speed berubah jadi 1
                     if(Timer.statusRintangan == true)
                     {
                         speed=1;
                         Timer.waktuRintangan = 10;
                     }
                     //kalau tidak true maka sped = 7 dan waktu trulang pada 10
                     else{speed = 7;} 
                     if(Timer.waktuRintangan == 0)
                     {
                         //jika timer waktu rintangan sudah 0 artinya hukuman karna sudah memakan rintangan selesa
                         Timer.statusRintangan = false;
                     }
                         
                }
                   
            }
                for (int i = 0; i < musuhs.size(); i++) {
                    Rectangle posisiMusuh = musuhs.get(i).getPosisi();//posisi musuh
                    Rectangle posisiPlayer = getPosisiPlayer();                   //posisi player
                   //untuk mengetahui naik level sehingga waktu, musuh dan makanan dapat di reset kembali
                        if(skor == 100 || skor == 200 || skor == 300 || skor == 400 || skor == 500)
                        {
                            if(skor==100){waktu =140;}
                            else if(skor==200){waktu =130;}
                            else if(skor==300){waktu =120;}
                            else if(skor==400){waktu =110;}
                            else if(skor==500){waktu =100;}
                            boolean removeAll = musuhs.removeAll(musuhs);
                            boolean hapus = makananSatu.removeAll(makananSatu);
                            JOptionPane.showMessageDialog(this, "Naik LeveL");
                            skor+=10;
                        }
                        //kondisi game over dimana jika waktu adalah 0 atau musuh berhimpitn dengan pemain, 
                        //sehingga flag = 0 sehingga game over dan membuat frame game over dan 
                        //menstop soundtrrack permainan serta menuput frame ini
                        if (posisiMusuh.intersects(posisiPlayer) || waktu == 0){
                          
                            flag=0;
                            Over xx = new Over(this); //membuat frame game over
                            this.dispose(); //menutup framw
                            xx.setVisible(true);                            
                            soundTrack.stop();
                            soundTrack2.stop();
                        }   
                        if (skor == 410){
                          
                            flag=0;
                            WinWin xx = new WinWin(this); //membuat frame game over
                            this.dispose(); //menutup framw
                            xx.setVisible(true);                            
                            soundTrack.stop();
                            soundTrack2.stop();
                        }
                }
            try {
             
                Thread.sleep(speed); //mengatur speed dengan thread sleep
            } catch (InterruptedException ex) {
                System.err.println("Error: Thread Interrupted.");
            }
        }
    }//tutup run
    public int getScore()
    {
        return skor;
    }
    private void move() {
        x += xArah;
        y += yArah;
        if (x < 0)//x tidak bisa kuang dari nol
            x = 0;
        if (y < 0)
            y = 0;
        if (x > 862)
            x = 862;
        if (y > 648)
            y = 648;
    }
    @Override //merupakan method dari graphic
    public void paint(Graphics g) {
        Image dbImg = createImage(getWidth(), getHeight()); //mendapatkan lebar layar
        Graphics dbg = dbImg.getGraphics();
        gambar(dbg);        
        g.drawImage(dbImg, 0, 0, this);      
    }
    public void gambar(Graphics g) {
       
         g.drawImage(background, 0, 0, null);
          //lvl1
          if(skor<110){
              
                if (arahPlayer == true) {
                       if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l1mleft.png")).getImage();
                       }
                       else{
                            if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l1kiri.png")).getImage();
                             }
                            else{
                                 playerIkan = new ImageIcon(this.getClass().getResource("l1kiri1.png")).getImage();
                             }
                       }
                       g.drawImage(playerIkan, x, y, this);
                       
                 }
                else
                {   
                     if(MakananSatu.statusMakanan == true){
                         playerIkan = new ImageIcon(this.getClass().getResource("l1m.png")).getImage();
                       }
                       else{
                         if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("test1.png")).getImage();
                             }
                         else{
                                playerIkan = new ImageIcon(this.getClass().getResource("test2.png")).getImage();
                             }
                       }
                     g.drawImage(playerIkan, x, y, this);
                }
            }
          //lvl2
          else if(skor<210){
              background = new ImageIcon(this.getClass().getResource("p.png")).getImage();
                if (arahPlayer == true) {
                       if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l2mleft.png")).getImage();
                       }
                       else{
                            if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l2kiri.png")).getImage();
                             }
                         else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l2kiri1.png")).getImage();
                             }
                       }
                       g.drawImage(playerIkan, x, y, this);
                 }
                else
                {   
                     if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l2m.png")).getImage();
                     }
                    else{
                             if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l21.png")).getImage();
                             }
                            else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l2.png")).getImage();
                             }
                     }
                     g.drawImage(playerIkan, x, y, this);
                }
            }
          //lvl4
           else if(skor<310){
               background = new ImageIcon(this.getClass().getResource("10.png")).getImage();
                if (arahPlayer == true) {
                       if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l3mleft.png")).getImage();
                       }
                       else{
                            if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l3kiri.png")).getImage();
                             }
                         else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l3kiri1.png")).getImage();
                             }
                       }
                       g.drawImage(playerIkan, x, y, this);
                 }
                else
                {   
                     if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l3m.png")).getImage();
                       }
                       else{
                         if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l3.png")).getImage();
                             }
                         else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l31.png")).getImage();
                             }
                       }
                   g.drawImage(playerIkan, x, y, this);
                }
            }
           //lvl5
            else if(skor<410){
                background = new ImageIcon(this.getClass().getResource("1.png")).getImage();
               if (arahPlayer == true) {
                       if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l4mleft.png")).getImage();
                       }
                       else{
                              if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l4kiri.png")).getImage();
                             }
                             else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l4kiri1.png")).getImage();
                             }
                       }
                       g.drawImage(playerIkan, x, y, this);
                 }
                else
                {   
                     if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l4m.png")).getImage();
                       }
                       else{
                             if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l41.png")).getImage();
                             }
                         else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l4.png")).getImage();
                             }
                       }
                   g.drawImage(playerIkan, x, y, this);
                }
            }
         else {
               if (arahPlayer == true) {
                       if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l5mleft.png")).getImage();
                       }
                       else{
                            if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l5kiri.png")).getImage();
                             }
                            else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l5kiri1.png")).getImage();
                             }
                       }
                       g.drawImage(playerIkan, x, y, this);
                 }
                else
                {   
                     if(MakananSatu.statusMakanan == true){
                        playerIkan = new ImageIcon(this.getClass().getResource("l5m.png")).getImage();
                       }
                       else{
                             if(gerak%2==0)
                             {
                               playerIkan = new ImageIcon(this.getClass().getResource("l5.png")).getImage();
                             }
                            else{
                                playerIkan = new ImageIcon(this.getClass().getResource("l51.png")).getImage();
                             }
                       }
                     g.drawImage(playerIkan, x, y, this);
                }
               
            }
          //menggambar objek
        for (int i = 0; i < musuhs.size(); i++) {
            MakananDua e = musuhs.get(i);
            e.draw(g); //memainggil fungsi draw pada setiap class
        }
        for (int i = 0; i < makananSatu.size(); i++) {
            MakananSatu e = makananSatu.get(i);
            e.draw(g);
             
        }
        for (int i = 0; i < rintang.size(); i++) {
            RintanganSatu e = rintang.get(i);
            e.draw(g);
        }
        
        repaint();
                g.setFont(new Font("Arial",Font.BOLD,18));
		g.setColor(Color.RED);
		g.drawString("SCORE : " + Integer.toString(skor),20,50);
                g.drawString("WAKTU : " + Integer.toString(waktu),160,50);
    }
     
    public void munculMusuh() {
        MakananDua e = new MakananDua();
        MakananDua k = new MakananDua();        
        MakananDua.skor=skor;
        k.setY(190);
        if(acak%2 == 0)
        {
            e.setY(10);
        }
        else if(acak%3 == 0)
        {
            e.setY(400);
        }
        else{
            e.setY(140);
        }
        musuhs.add(e);
        musuhs.add(k);
        acak++;
        Thread t = new Thread(e);Thread tt = new Thread(k);
        t.start();
        tt.start();
    }
    public void munculRintangan() {
       RintanganSatu r = new RintanganSatu();
        if(acakmakanan1%2 == 0)
        {
            r.setX(300);
        }
        else if(acakmakanan1%3 == 0)
        {
            r.setX(8);
        }
        else{
            r.setX(670);
        }
        acakmakanan1++;
        rintang.add(r);
        Thread t = new Thread(r);
        t.start();      
    }
    public void munculMakanan() {
       MakananSatu e = new MakananSatu();
       MakananSatu ke = new MakananSatu();
       MakananSatu.skor=skor;
       ke.setY(257);
        if(acakmakanan1%2 == 0)
        {
            e.setY(500);
        }
        else if(acakmakanan1%3 == 0)
        {
            e.setY(8);
        }
        else{
            e.setY(140);
        }
        acakmakanan1++;
        makananSatu.add(e);
        makananSatu.add(ke);
        Thread t = new Thread(e);Thread tt = new Thread(ke);
        t.start(); tt.start();      
       
       
    }
     
    
    private Rectangle getPosisiPlayer() {
        int pp = 0,l = 0;
        if(skor<100){pp=12;l=12;}
        else if(skor<200){pp=16;l=16;}
        else if(skor<300){pp=22;l=22;}
        else if(skor<400){pp=27;l=27;}
        else if(skor<500){pp=35;l=35;}
        
        return new Rectangle(x, y, pp, l);
    }
    int getFlag(){
        return flag;
    }
    
}
package travel.tourism.management.system;

import java.awt.*;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        setVisible(true);
        thread = new Thread(this);
        thread.start();
        run();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
        }catch (Exception e){
            
        }
    }
    public static void main(String[] args){
        Splash f1 = new Splash();
        f1.setVisible(true);
        int i;
        int x=1;
        for(i=2; i<=600; i+=10, x+=7){
            f1.setLocation(900 - ((i+x)/2), 500 - (i/2));
            f1.setSize(i+x,i);
            try{
             Thread.sleep(10);
            }catch(Exception e){}
        }
    }  
}
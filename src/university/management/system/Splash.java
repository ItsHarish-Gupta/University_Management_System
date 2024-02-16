/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

/**
 *
 * @author Harish
 */

import javax.swing.*;
import java.awt.*;
public class Splash  extends JFrame implements Runnable {
    
    Thread t;   // Declaring Thread class object
    Splash(){
        
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image img2 = img1.getImage().getScaledInstance(1000, 650,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        add(image);
        
        t=new Thread(this);
        t.start();
        
        setVisible(true);
        
        int x=1;
        for(int i=2; i<=600; i+=4, x+=1){
            setLocation(530-((i+x)/2),350-(i/2));
            setSize(i+3*x,i+x/2);
        }
        
        
        try{
            
            Thread.sleep(10);
                  
        }catch (Exception e){}
         
    }
    
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            
            // Next Frame
            new Login();
        }catch (Exception e){}
    }
    
    public static void main(String[] args){
        new Splash();
    }
    
}




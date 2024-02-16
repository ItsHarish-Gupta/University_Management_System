
package university.management.system;

/**
 *
 * @author Harish
 */

import java.awt.*;
import javax.swing.*;

public class About extends JFrame{
    
    About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image img2 = img1.getImage().getScaledInstance(300, 200,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(350,0,300,200);
        add(image);
        
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font ("TAHOMA", Font.BOLD,30));
        add(heading);
        
        JLabel name = new JLabel("Developed By Harish");
        name.setBounds(70,220,550,40);
        name.setFont(new Font ("TAHOMA", Font.BOLD,30));
        add(name);
        
        JLabel rollNo = new JLabel("Roll No: 221050010010");
        rollNo.setBounds(70,280,550,40);
        rollNo.setFont(new Font ("TAHOMA", Font.PLAIN,30));
        add(rollNo);
        
        JLabel contact = new JLabel("Contact: itsharish2022@gmail.com");
        contact.setBounds(70,340,550,40);
        contact.setFont(new Font ("TAHOMA", Font.PLAIN,20));
        add(contact);
        
        setLayout(null);
        setVisible(true);
    }
    
    public static void main(String[] args){
        new About();
    }
}

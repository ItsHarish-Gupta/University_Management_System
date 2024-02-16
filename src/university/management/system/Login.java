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
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
    
    JButton login, cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    Login (){
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    // Creating Label for Username
    JLabel lbusername = new JLabel("Username");
    lbusername.setBounds(40,20,100,20);
    add(lbusername);
    
    // Creating Text Field for username
    tfusername = new JTextField();
    tfusername.setBounds(150, 20, 150, 20);
    add(tfusername);
    
    // Creating Label for Password
    JLabel lbpassword = new JLabel("Password");
    lbpassword.setBounds(40,70,100,20);
    add(lbpassword);
    
    // Creating Text Field for password
    tfpassword = new JPasswordField();
    tfpassword.setBounds(150,70,150,20);
    add(tfpassword);
    
    // Creating  login Button
    login = new JButton("Login");
    login.setBounds(40,140,120,30);
    login.setBackground(Color.pink);
    login.setForeground(Color.WHITE);
    login.addActionListener(this);
    login.setFont(new Font("tahoma",Font.BOLD, 15));
    add(login);
    
    //Creating Cancel Button
    cancel = new JButton("Cancel");
    cancel.setBounds(180,140,120,30);
    cancel.setBackground(Color.pink);
    cancel.setForeground(Color.WHITE);
    cancel.addActionListener(this);
    cancel.setFont(new Font("tahoma",Font.BOLD, 15));
    add(cancel);
    
    
    // Inserting User Image
    ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
    Image img2 = img1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
    ImageIcon img3 = new ImageIcon(img2);
    JLabel image = new JLabel(img3);
    image.setBounds(350,0,200,200);
    add(image);
    
    setVisible(true);
    setLocation(380,250);
    setSize(600,300);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == login){
            
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            // Writing query 
            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            
            try{
                Conctn c = new Conctn();
                ResultSet rs = c.s.executeQuery(query);
                
                // Checking entered Credentials
                if(rs.next()){
                
                    setVisible(false);
                    new Project();
                }else{
                
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
            
            }catch (Exception e){
                e.printStackTrace();
            }
        
        }else if(ae.getSource() == cancel){
        setVisible(false);
        }   
    
    }
    
    public static void main(String[] args){
        new Login();
    }
    
}

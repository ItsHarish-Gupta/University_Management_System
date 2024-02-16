package university.management.system;

/**
 *
 * @author Harish
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Marks extends JFrame implements ActionListener{
    
    String rollNo;
    JButton back;
    
    Marks(String rollNo){
        this.rollNo = rollNo;
        
        setSize(500,500);
        setLocation(500,100);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("D D U Gorakhpur University");
        heading.setBounds(100,10,500,25);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
        add(heading);
        
        JLabel subHeading = new JLabel("Result Of Examination 2022");
        subHeading.setBounds(100,50,500,20);
        subHeading.setFont(new Font("TAHOMA", Font.BOLD, 18));
        add(subHeading);
        
        JLabel lblRollNo = new JLabel("Rol Number "+rollNo);
        lblRollNo.setBounds(60,100,500,25);
        lblRollNo.setFont(new Font("TAHOMA", Font.PLAIN, 20));
        add(lblRollNo);
        
        JLabel lblSemeseter = new JLabel("Result Of Examination 2022");
        lblSemeseter.setBounds(60,130,500,20);
        lblSemeseter.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(lblSemeseter);
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(100,200,500,20);
        sub1.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(sub5);
        
        try{
            Conctn c = new Conctn();
            
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollNo+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollNo+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText() + "--------------" + rs2.getString("subMarks1"));
                sub2.setText(sub2.getText() + "--------------" + rs2.getString("subMarks1"));
                sub3.setText(sub3.getText() + "--------------" + rs2.getString("subMarks1"));
                sub4.setText(sub4.getText() + "--------------" + rs2.getString("subMarks1"));
                sub5.setText(sub5.getText() + "--------------" + rs2.getString("subMarks1"));
                lblSemeseter.setText("Semester "+ rs2.getString("semester"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        //Creating Back Button
        back = new JButton("Back");
        back.setBounds(280,360,150,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("tahoma",Font.BOLD, 15));
        add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new Marks("");
    }
    
}

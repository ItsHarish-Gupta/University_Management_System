
package university.management.system;

/**
 *
 * @author Harish
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice cRollNo;
    JComboBox cbSemester;
    JTextField tfSub1, tfSub2, tfSub3, tfSub4, tfSub5;
    JTextField tfSubMarks1, tfSubMarks2, tfSubMarks3, tfSubMarks4, tfSubMarks5;
    JButton submit, back;
    
    EnterMarks(){
        setSize(1000,500);
        setLocation(300,100);
        setLayout(null);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image img2 = img1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(500,40,400,300);       
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
        add(heading);
        
        JLabel lblRollNumber = new JLabel("Select Roll Number");
        lblRollNumber.setBounds(50,70,150,20);
        add(lblRollNumber);
        
        cRollNo = new Choice();
        cRollNo.setBounds(200,70,150,20);
        add(cRollNo);
        
        try{
            Conctn c = new Conctn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                cRollNo.add(rs.getString("rollno"));
            
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblSemester = new JLabel("Select Semester");
        lblSemester.setBounds(50,110,150,20);
        add(lblSemester);
        
        //Creating Combo box
        String semester[]={"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester","6th Semester","7th Semester","8th Semester"};
        cbSemester = new JComboBox(semester);
        cbSemester.setBounds(200,110,150,20);
        cbSemester.setBackground(Color.WHITE);
        add(cbSemester);
        
        JLabel lblEnterSubject = new JLabel("Enter Subject");
        lblEnterSubject.setBounds(100,150,200,40);
        add(lblEnterSubject);
        
        JLabel lblEnterMarks = new JLabel("Enter Marks");
        lblEnterMarks.setBounds(320,150,200,40);
        add(lblEnterMarks);
        
        tfSub1 = new JTextField();
        tfSub1.setBounds(50, 200, 200, 20);
        add(tfSub1);
        
        tfSub2 = new JTextField();
        tfSub2.setBounds(50, 230, 200, 20);
        add(tfSub2);
        
        tfSub3 = new JTextField();
        tfSub3.setBounds(50, 260, 200, 20);
        add(tfSub3);
        
        tfSub4 = new JTextField();
        tfSub4.setBounds(50, 290, 200, 20);
        add(tfSub4);
        
        tfSub5 = new JTextField();
        tfSub5.setBounds(50, 320, 200, 20);
        add(tfSub5);
        
        tfSubMarks1 = new JTextField();
        tfSubMarks1.setBounds(250, 200, 200, 20);
        add(tfSubMarks1);
        
        tfSubMarks2 = new JTextField();
        tfSubMarks2.setBounds(250, 230, 200, 20);
        add(tfSubMarks2);
        
        tfSubMarks3 = new JTextField();
        tfSubMarks3.setBounds(250, 260, 200, 20);
        add(tfSubMarks3);
        
        tfSubMarks4 = new JTextField();
        tfSubMarks4.setBounds(250, 290, 200, 20);
        add(tfSubMarks4);
        
        tfSubMarks5 = new JTextField();
        tfSubMarks5.setBounds(250, 320, 200, 20);
        add(tfSubMarks5);
        
        // Creating  submit Button
        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD, 15));
        add(submit);
    
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
        
        if(ae.getSource() == submit){
            try{
                Conctn c = new Conctn();
                
                String query1 = "insert into subject values('"+cRollNo.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"', '"+tfSub1.getText()+"', '"+tfSub2.getText()+"', '"+tfSub3.getText()+"','"+tfSub4.getText()+"', '"+tfSub5.getText()+"')";
                
                String query2 = "insert into marks values('"+cRollNo.getSelectedItem()+"', '"+cbSemester.getSelectedItem()+"', '"+tfSubMarks1.getText()+"', '"+tfSubMarks2.getText()+"', '"+tfSubMarks3.getText()+"','"+tfSubMarks4.getText()+"', '"+tfSubMarks5.getText()+"')";
     
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Marks Inserted Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    
    
    public static void main(String[] args){
        new EnterMarks();
    }
}

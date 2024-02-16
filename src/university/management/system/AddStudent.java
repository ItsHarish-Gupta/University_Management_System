
package university.management.system;

/**
 *
 * @author Harish
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{
    
    JTextField tfname, tfFname, tfPhone, tfAddress, tfEmail, tfX, tfXii;
    JTextField tfAdhar;
    JLabel labelRollNo;
    JDateChooser dcdob;
    JComboBox cbCourse, cbBranch;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddStudent(){
    
        setSize(900,700);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel lblFname = new JLabel("Father's Name");
        lblFname.setBounds(400,150,200,30);
        lblFname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblFname);
        
        tfFname = new JTextField();
        tfFname.setBounds(600,150,150,30);
        add(tfFname);
        
        JLabel lblRollNo = new JLabel("Roll Number");
        lblRollNo.setBounds(50,200,200,30);
        lblRollNo.setFont(new Font("serif", Font.BOLD, 20));
        add(lblRollNo);
        
        labelRollNo = new JLabel("2324"+first4);
        labelRollNo.setBounds(200,200,200,30);
        labelRollNo.setFont(new Font("serif", Font.BOLD, 20));
        add(labelRollNo);
        
        JLabel lblDob = new JLabel("Date of Birth");
        lblDob.setBounds(400,200,200,30);
        lblDob.setFont(new Font("serif", Font.BOLD, 20));
        add(lblDob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(50,250,200,30);
        lblAddress.setFont(new Font("serif", Font.BOLD, 20));
        add(lblAddress);
        
        tfAddress = new JTextField();
        tfAddress.setBounds(200,250,150,30);
        add(tfAddress);
        
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(400,250,200,30);
        lblPhone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblPhone);
        
        tfPhone = new JTextField();
        tfPhone.setBounds(600,250,150,30);
        add(tfPhone);
                  
        JLabel lblEmail = new JLabel("Email Id");
        lblEmail.setBounds(50,300,200,30);
        lblEmail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblEmail);
        
        tfEmail = new JTextField();
        tfEmail.setBounds(200,300,150,30);
        add(tfEmail);
        
        JLabel lblX = new JLabel("Class X (%)");
        lblX.setBounds(400,300,200,30);
        lblX.setFont(new Font("serif", Font.BOLD, 20));
        add(lblX);
        
        tfX = new JTextField();
        tfX.setBounds(600,300,150,30);
        add(tfX);
        
        JLabel lblXii = new JLabel("Class XII (%)");
        lblXii.setBounds(50,350,200,30);
        lblXii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblXii);
        
        tfXii = new JTextField();
        tfXii.setBounds(200,350,150,30);
        add(tfXii);
        
        JLabel lblAdhar = new JLabel("Adhar Number");
        lblAdhar.setBounds(400,350,200,30);
        lblAdhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblAdhar);
        
        tfAdhar = new JTextField();
        tfAdhar.setBounds(600,350,150,30);
        add(tfAdhar);
        
        JLabel lblCourse = new JLabel("Course");
        lblCourse.setBounds(50,400,200,30);
        lblCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblCourse);
        
        String course[]= {"B.Tech", "BBA", "BCA", "B.sc", "BA", "M.Tech", "MBA", "MCA", "M.Sc", "MA"};
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(200,400,150,30);
        add(cbCourse);
        
        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setBounds(400,400,200,30);
        lblBranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblBranch);
        
        String branch[]= {"Computer Science", "Information Technology", "Elecetronics", "Mechanical", "Civil", "Chemical"};
        cbBranch = new JComboBox(branch);
        cbBranch.setBounds(600,400,150,30);
        add(cbBranch);
        
        // Creating  submit Button
        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD, 15));
        add(submit);
    
        //Creating Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD, 15));
        add(cancel);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tfFname.getText();
            String rollno = labelRollNo.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String x = tfX.getText();
            String xii = tfXii.getText();
            String adhar = tfAdhar.getText();
            String course = (String) cbCourse.getSelectedItem();
            String branch = (String) cbBranch.getSelectedItem();
            
            try{
                String query = "insert into student values ('"+name+"','"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+adhar+"', '"+course+"', '"+branch+"' )";
                
                Conctn con = new Conctn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
        
            setVisible(false);
        }
          
    }
    
    public static void main(String[] args){
    
        new AddStudent();
    
    }
    
}


package university.management.system;

/**
 *
 * @author Harish
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
    JTextField tfBranch, tfPhone, tfAddress, tfEmail;
    JTextField  tfCourse;
    JLabel labelRollNo;
    JButton update, cancel;
    Choice cRollNo;
       
    UpdateStudent(){
    
        setSize(900,650);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("TAHOMA", Font.ITALIC, 30));
        add(heading);
        
        JLabel lblRollNumber = new JLabel("Select Roll Number");
        lblRollNumber.setBounds(50,100,200,20);
        lblRollNumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblRollNumber);
        
        cRollNo = new Choice();
        cRollNo.setBounds(250,100,200,20);
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
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        JLabel labelName = new JLabel();
        labelName.setBounds(200,150,150,30);
        labelName.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(labelName);
        
        JLabel lblFname = new JLabel("Father's Name");
        lblFname.setBounds(400,150,200,30);
        lblFname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblFname);
        
        JLabel labelFname = new JLabel();
        labelFname.setBounds(600,150,150,30);
        labelFname.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(labelFname);
        
        JLabel lblRollNo = new JLabel("Roll Number");
        lblRollNo.setBounds(50,200,200,30);
        lblRollNo.setFont(new Font("serif", Font.BOLD, 20));
        add(lblRollNo);
        
        labelRollNo = new JLabel();
        labelRollNo.setBounds(200,200,200,30);
        labelRollNo.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(labelRollNo);
        
        JLabel lblDob = new JLabel("Date of Birth");
        lblDob.setBounds(400,200,200,30);
        lblDob.setFont(new Font("serif", Font.BOLD, 20));
        add(lblDob);
        
        JLabel labelDob = new JLabel();
        labelDob.setBounds(600,200,150,30);
        labelDob.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(labelDob);
        
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
        
        JLabel labelX = new JLabel();
        labelX.setBounds(600,300,150,30);
        labelX.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(labelX);
        
        JLabel lblXii = new JLabel("Class XII (%)");
        lblXii.setBounds(50,350,200,30);
        lblXii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblXii);
        
        JLabel labelXii = new JLabel();
        labelXii.setBounds(200,350,150,30);
        labelXii.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(labelXii);
        
        JLabel lblAdhar = new JLabel("Adhar Number");
        lblAdhar.setBounds(400,350,200,30);
        lblAdhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblAdhar);
        
        JLabel labelAdhar = new JLabel();
        labelAdhar.setBounds(600,350,150,30);
        labelAdhar.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(labelAdhar);
        
        JLabel lblCourse = new JLabel("Course");
        lblCourse.setBounds(50,400,200,30);
        lblCourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblCourse);
        
         
        tfCourse = new JTextField();
        tfCourse.setBounds(200,400,150,30);
        add(tfCourse);
        
        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setBounds(400,400,200,30);
        lblBranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblBranch);
        
        tfBranch = new JTextField();
        tfBranch.setBounds(600,400,150,30);
        add(tfBranch);
        
        try{
            Conctn c = new Conctn();
            String query = "select * from student where rollno = '"+cRollNo.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelName.setText(rs.getString("name"));
                labelFname.setText(rs.getString("fname"));
                labelDob.setText(rs.getString("dob"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
                labelX.setText(rs.getString("class_x"));
                labelXii.setText(rs.getString("class_xii"));
                labelAdhar.setText(rs.getString("aadhar"));
                labelRollNo.setText(rs.getString("rollno"));
                tfCourse.setText(rs.getString("course"));
                tfBranch.setText(rs.getString("branch"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cRollNo.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conctn c = new Conctn();
                    String query = "select * from student where rollno = '"+cRollNo.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelName.setText(rs.getString("name"));
                        labelFname.setText(rs.getString("fname"));
                        labelDob.setText(rs.getString("dob"));
                        tfAddress.setText(rs.getString("address"));
                        tfPhone.setText(rs.getString("phone"));
                        tfEmail.setText(rs.getString("email"));
                        labelX.setText(rs.getString("class_x"));
                        labelXii.setText(rs.getString("class_xii"));
                        labelAdhar.setText(rs.getString("aadhar"));
                        labelRollNo.setText(rs.getString("rollno"));
                        tfCourse.setText(rs.getString("course"));
                        tfBranch.setText(rs.getString("branch"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }       
        });
        
        // Creating  submit Button
        update = new JButton("Update");
        update.setBounds(250,550,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("tahoma",Font.BOLD, 15));
        add(update);
    
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
    
        if(ae.getSource() == update){
            String rollno = labelRollNo.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String course = tfCourse.getText();
            String branch = tfBranch.getText();
            
            try{
                String query = "update student set address='"+address+"',phone= '"+phone+"',email= '"+email+"',course= '"+course+"',branch= '"+branch+"' where rollno='"+rollno+"'";
                
                Conctn con = new Conctn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
        
            setVisible(false);
        }
          
    }
    
    public static void main(String[] args){
    
        new UpdateStudent();
    
    }
    
}

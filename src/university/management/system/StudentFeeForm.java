package university.management.system;

/**
 *
 * @author Harish
 */

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentFeeForm extends JFrame implements ActionListener {
    
    Choice cRollNo;
    JComboBox cbCourse,cbBranch, cbSemester;
    JLabel lblTotal;
    JButton getFee, pay, back;
    
    StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image img2 = img1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(450,50,500,300);
        add(image);
        
        JLabel lblRollNumber = new JLabel("Select Roll No");
        lblRollNumber.setBounds(40,60,150,20);
        lblRollNumber.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(lblRollNumber);
        
        cRollNo = new Choice();
        cRollNo.setBounds(200,60,150,16);
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
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(lblname);
        
        JLabel labelName = new JLabel();
        labelName.setBounds(200,100,150,20);
        labelName.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(labelName);
        
        JLabel lblFname = new JLabel("Father's Name");
        lblFname.setBounds(40,140,150,20);
        lblFname.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(lblFname);
        
        JLabel labelFname = new JLabel();
        labelFname.setBounds(200,140,150,20);
        labelFname.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(labelFname);
        
        try{
            Conctn c = new Conctn();
            String query = "select * from student where rollno = '"+cRollNo.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelName.setText(rs.getString("name"));
                labelFname.setText(rs.getString("fname"));
                               
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
                        }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }       
        });
        
        JLabel lblCourse = new JLabel("Course");
        lblCourse.setBounds(40,180,150,20);
        lblCourse.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(lblCourse);
        
        String course[]= {"B.Tech", "BBA", "BCA", "B.sc", "BA", "M.Tech", "MBA", "MCA", "M.Sc", "MA"};
        cbCourse = new JComboBox(course);
        cbCourse.setBounds(200,180,150,20);
        cbCourse.setBackground(Color.WHITE);
        add(cbCourse);
        
        JLabel lblBranch = new JLabel("Branch");
        lblBranch.setBounds(40,220,150,20);
        lblBranch.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(lblBranch);
        
        String branch[]= {"Computer Science", "Information Technology", "Elecetronics", "Mechanical", "Civil", "Chemical"};
        cbBranch = new JComboBox(branch);
        cbBranch.setBounds(200,220,150,20);
        cbBranch.setBackground(Color.WHITE);
        add(cbBranch);
        
        JLabel lblSemester = new JLabel("Semester");
        lblSemester.setBounds(40,260,150,20);
        add(lblSemester);
        
        //Creating Combo box
        String semester[]={"Semester1", "Semester2", "Semester3", "Semester4", "Semester5","Semester6","Semester7","Semester8"};
        cbSemester = new JComboBox(semester);
        cbSemester.setBounds(200,260,150,20);
        cbSemester.setBackground(Color.WHITE);
        add(cbSemester);
        
        lblTotal = new JLabel();
        lblTotal.setBounds(200,300,150,20);
        lblTotal.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        add(lblTotal);
        
        JLabel sub2 = new JLabel("Total Payable");
        sub2.setBounds(40,300,150,20);
        sub2.setFont(new Font("TAHOMA", Font.BOLD, 16));
        add(sub2);
        
        // Creating  GetFee Button
        getFee = new JButton("Get Fee");
        getFee.setBounds(30,380,100,25);
        getFee.setBackground(Color.BLACK);
        getFee.setForeground(Color.WHITE);
        getFee.addActionListener(this);
        getFee.setFont(new Font("tahoma",Font.BOLD, 15));
        add(getFee);
    
        //Creating Pay Fee Button
        pay = new JButton("Pay Fee");
        pay.setBounds(150,380,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("tahoma",Font.BOLD, 15));
        add(pay);
        
        //Creating Back Button
        back = new JButton("Back");
        back.setBounds(270,380,100,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("tahoma",Font.BOLD, 15));
        add(back);
        
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == getFee){
            String course = (String)cbCourse.getSelectedItem();
            String semester = (String)cbSemester.getSelectedItem();
            try{
                Conctn c = new Conctn();
                ResultSet rs = c.s.executeQuery("select * from fee where course = '"+course+"'");
                while(rs.next()){
                    lblTotal.setText(rs.getString(semester));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == pay){
          
            String rollNo = cRollNo.getSelectedItem();
            String course = (String)cbCourse.getSelectedItem();
            String semester = (String)cbSemester.getSelectedItem();
            String branch = (String)cbBranch.getSelectedItem();
            String total = lblTotal.getText();
            
            try{
                Conctn c = new Conctn();
                String query = "insert into payFee values('"+rollNo+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Fee Submitted Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new StudentFeeForm();
    }
    
}

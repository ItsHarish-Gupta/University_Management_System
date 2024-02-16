
package university.management.system;

/**
 *
 * @author Harish
 */

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class TeacherLeave extends JFrame implements ActionListener {
    
    Choice cEmpId, cTime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    TeacherLeave(){
        setSize(500,550);
        setLocation(420,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);
        
        JLabel lblRollNo = new JLabel("Search by Employee Id");
        lblRollNo.setBounds(60,100,200,20);
        lblRollNo.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(lblRollNo);
        
        cEmpId = new Choice();
        cEmpId.setBounds(60,130,200,20);
        add(cEmpId);
        
        try{
            Conctn c = new Conctn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("empid"));
            
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(60,180,200,20);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(lblDate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,23);
        add(dcdate);
        
        JLabel lblTime = new JLabel("Time Duration of Leave ");
        lblTime.setBounds(60,260,200,20);
        lblTime.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(lblTime);
        
        cTime = new Choice();
        cTime.setBounds(60,290,200,20);
        cTime.add("Full Day");
        cTime.add("Half Day");
        add(cTime);
        
        // Creating  submit Button
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("tahoma",Font.BOLD, 15));
        add(submit);
    
        //Creating Cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("tahoma",Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String empid = cEmpId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = cTime.getSelectedItem();
            
            String query = "insert into teacherLeave values('"+empid+"', '"+date+"', '"+duration+"')";
            
            try{
                
                Conctn con = new Conctn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new TeacherLeave();
    }
    
}


package university.management.system;

/**
 *
 * @author Harish
 */

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    
    Choice cRollNo;
    JTable table;
    JButton search, print, cancel;
    
    StudentLeaveDetails(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search By roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cRollNo = new Choice();
        cRollNo.setBounds(180,20,150,20);
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
        
        // Creating Table
        table = new JTable();
        
        try{
            Conctn c = new Conctn();
            ResultSet rs = c.s.executeQuery("select * from studentLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        // Creating Button
        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
             
 
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from studentLeave where rollno = '"+cRollNo.getSelectedItem()+"'";
            try{
                Conctn c = new Conctn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        
        }else if(ae.getSource() == print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        
        }
        else{
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
    
        new StudentLeaveDetails();
        
    }
    
}

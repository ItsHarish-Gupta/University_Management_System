
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

public class ExaminationDetails extends JFrame implements ActionListener {
    
    JTextField search;
    JButton seeResult, back;
    JTable table;
    
    ExaminationDetails(){
        setSize(1000,475);
        setLocation(300,100);
        
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80,15,400,50);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 24));
        add(heading);
        
        search = new JTextField();
        search.setBounds(80,90,200,30);
        search.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(search);
        
        // Creating  See Result Button
        seeResult = new JButton("See Result");
        seeResult.setBounds(300,90,120,30);
        seeResult.setBackground(Color.BLACK);
        seeResult.setForeground(Color.WHITE);
        seeResult.addActionListener(this);
        seeResult.setFont(new Font("tahoma",Font.BOLD, 15));
        add(seeResult);
    
        //Creating Back Button
        back = new JButton("Back");
        back.setBounds(440,90,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("tahoma",Font.BOLD, 15));
        add(back);
        
        table = new JTable();
        table.setFont(new Font("TAHOMA", Font.PLAIN, 16));
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);
        
        try{
            Conctn c = new Conctn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
        }
        
        );
        
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==seeResult){
            setVisible(false);
            new Marks(search.getText());
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new ExaminationDetails();
    }
}

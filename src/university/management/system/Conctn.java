
package university.management.system;

/**
 *
 * @author Harish
 */

import java.sql.*;

public class Conctn {
    
    Connection c;
    Statement s;
    
    Conctn(){
    
        try{
            // Registering the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connecting the JDBC Driver
            c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem", "root", "Mysql@#$89");
            
            // Creating Statement
            s = c.createStatement();
            
            
        }catch(Exception e){
        
            e.printStackTrace();
        }
    }
    
}

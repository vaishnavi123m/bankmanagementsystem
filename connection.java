package bank.management.system;
import java.sql.*;
 
public class connection {
 
    
    Connection con = null;
 
    public static Connection connectDB()
 
    {try {
 
            Class.forName("com.mysql.jdbc.Driver");
 
            
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmangement",
                "root", "gayathri@03");
             return con;
        }
 
        // Catch block to handle the exceptions
        catch (SQLException | ClassNotFoundException e) {
 
            // Print the exceptions
            System.out.println(e);
 
            return null;
        }
    }}
 
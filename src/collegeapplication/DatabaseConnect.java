 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeapplication;

/**
 *18285
 * @author raju
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseConnect {

    /**
     * @param args the command line arguments
     */      
      Connection conn = null;
      //remember to change password
      
    public Connection connect() {
        try {
          
          String jdbc = "jdbc:mysql://localhost:8889/college?user=root&password=root";
          conn = DriverManager.getConnection(jdbc);

    // Do something with the Connection
    
          System.out.println("Database Loading Successful");
          
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }
      
    public void close(Connection conn) throws SQLException {
        conn.close();
        System.out.println("Database Closed!");
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeapplication;
import java.util.Scanner;
import java.sql.*;

/**
 *  18285
 * @author raju
 */
public class CollegeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to VGC College");
        Loginform l = new Loginform();
        l.setVisible(true);
    }
    
}

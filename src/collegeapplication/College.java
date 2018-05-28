/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegeapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 18285
 * @author raju
 */
public class College {
    Statement stmt;
    Connection conn;
    
    void viewLoginMenu(Connection c) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your login credential");
        System.out.println("Username?");
        int username;
        String password;
        Statement stmt;
        username =  input.nextInt();
        
        System.out.println("Password?");
        password =  input.next();
        
        try {
            stmt = c.createStatement();
            String sql;
            
            sql = "SELECT privilegeId, name FROM user WHERE id=" + username +  " AND password='" + password + "'" ;
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()){
            //Retrieve by column name
                String name = rs.getString("name");
                int privid = rs.getInt("privilegeID");

                //Display values
                System.out.println("Hello "+ name);
                System.out.println("Your ID = " + username);
                if (privid == 1) {
                    System.out.println("Status: Super Administrator");
                    viewAdminMenu(c, input);
                }
                else if(privid ==2) {
                    System.out.println("Status: Faculty Member");
                    viewFacultyMenu(c);
                }
                else if (privid == 3) {
                    System.out.println("Status: Student");
                    viewStudentMenu(c);
                }

            }
            else {
                System.out.println("User credential invalid. Please try again.");
                viewLoginMenu(c);
            }
        }
        catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }
        
             
    }  
    void viewStudentMenu(Connection c){
        System.out.println("This is your Student menu");
    }
    
    void viewAdminMenu(Connection c, Scanner in){
        System.out.println("This is your Admin menu");
        System.out.println("Press 1 to Add New Admin");
        int entry = in.nextInt();
        if (entry == 1) {
            addSuperAdmin(c, in);
        }
    }
    
    void viewFacultyMenu(Connection c){
        System.out.println("This is your Faculty menu");
    }
    
    void addSuperAdmin(Connection c, Scanner in){
        System.out.println("Enter name");
        String name;
        name = in.nextLine();
        System.out.println("Enter Password");
        String password;
        password= in.nextLine();
        
        try {
            stmt = c.createStatement();
            String sql;
            
            sql = "INSERT INTO user(name,password, privilegeID, branchId) VALUES('" + name +  "' , '" + password + "', 1, 1)" ;
            System.out.println(sql);
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
            sql = "SELECT id FROM user WHERE name='" + name +  "' AND password='" + password + "' ORDER BY id DESC" ;
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                int count = rs.getInt("id");
                System.out.println("The new user ID is: " + count);
            }
            
        }
        catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }
        
    }
}

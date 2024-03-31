/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CA2;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Justin
 * 
 */

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     * 
     */
    
    public static void main(String[] args) throws SQLException, IOException {
        
               
        // Start the menu
        Menu mainMenu = new Menu();

        // Connect to database
        MySQLDatabaseConnection conn = new MySQLDatabaseConnection();              
        conn.connect();
        
        // Test get course data
        ArrayList<CourseModule> cd = conn.getCourseData(1);
        System.out.println(cd);
        ReportGenerator.generateReportData(cd);
        
        // Get login credentials and store in a HashMap
        HashMap credentials = mainMenu.getLoginCredentials();
        
        // Cast HashMap values to strings and login
        conn.login((String) credentials.get("username"), (String) credentials.get("password"));

        // Check if logged in
        if (conn.isLoggedIn()) {
            
            // Get user role from the database
            String role = conn.getRole();
            mainMenu.setRole(role);
            
            
            // Display main menu
            mainMenu.displayMainMenu();
            
            
            // Display

            
        }         
        
        // Disconnect from database
        conn.disconnect();
    }
        
}
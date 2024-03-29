/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CA2;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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
        
        // Get login credentials and store in a HashMap
        HashMap credentials = conn.getLoginCredentials();
        
        // Cast HashMap values to strings and login
        conn.login((String) credentials.get("username"), (String) credentials.get("password"));

        // Check if logged in
        if (conn.isLoggedIn()) {
            
            // Get user role from the database
            String role = conn.getRole();
            mainMenu.setRole(role);
            
            // Testing
            ResultSet rs = conn.getReportData("COURSE", 1);
            System.out.println(rs);
            
            DynamicResultHandler drh = new DynamicResultHandler();  
            drh.processResultSet(rs, DynamicResultHandler.OutputFormat.CONSOLE);
            
            // Display main menu
            mainMenu.displayMainMenu();
            
        }         
        
        // Disconnect from database
        conn.disconnect();
    }
        
}
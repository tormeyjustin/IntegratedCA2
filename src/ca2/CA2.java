/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Justin
 * 
 */

public class CA2 {

    /**
     * @param args the command line arguments
     * 
     */
    
    public static void main(String[] args) {
        
        // Start the menu
        Menu mainMenu = new Menu();
        
        // Get login credentials saved in a HashMap
        HashMap credentials = mainMenu.getLoginCredentials();
        
        // Connect to database
        DbConnector dbConn = new DbConnector();        
        dbConn.connect();       
        
        // Cast HashMap values to strings and login
        dbConn.login((String) credentials.get("username"), (String) credentials.get("password"));

        // Check if logged in
        if (dbConn.isLoggedIn()) {
            
            // Get user role from the database
            String role = dbConn.getRole();
            
            // Main menu options filtered by role
            char selected = mainMenu.mainMenuOptions(role);
            
            // Display 
            mainMenu.mainSelectedOption(selected);
        }
        
        
        // Disconnect from database
        dbConn.disconnect();
    }
        
}
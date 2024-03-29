/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Justin
 * 
 */

public class Main {

    /**
     * @param args the command line arguments
     * 
     */
    
    public static void main(String[] args) {
        
               
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
            
            // Display main menu
            mainMenu.displayMainMenu();
        }         
        
        // Disconnect from database
        conn.disconnect();
    }
        
}
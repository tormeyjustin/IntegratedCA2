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
        
        // Connect to database
        DbConnector dbConn = new DbConnector();              
        dbConn.connect();
        
        // Get login credentials and store in a HashMap
        HashMap credentials = mainMenu.getLoginCredentials();
        
        // Cast HashMap values to strings and login
        dbConn.login((String) credentials.get("username"), (String) credentials.get("password"));

        // Check if logged in
        if (dbConn.isLoggedIn()) {
            
            // Get user role from the database
            String role = dbConn.getRole();
            
            // Main menu options filtered by role
            char selected = mainMenu.mainMenuOptions(role);
            
            // Display second level menus
            switch(selected) {
                case 'x':
                    // Exit application
                    System.out.println("Exiting application");
                    System.exit(0);
                case 'a':
                    mainMenu.manageAccountMenu();
                    // Do account managment
                    break;
                case 'r':
                    HashMap report = mainMenu.reportFormatOptions();
                    // Ouput report
                    break;
                case 'u':
                    mainMenu.manageUsersMenu();
                    // Manage users
                    break;
            }

            // Do something with menu selections
        }         
        
        // Disconnect from database
        dbConn.disconnect();
    }
        
}
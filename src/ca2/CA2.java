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
        
        // Get login credentials
        HashMap credentials = mainMenu.getLoginCredentials();
        System.out.println(credentials);
        
        // Connect to database
        DbConnector dbConn = new DbConnector();        
        dbConn.connect();
        
        // Cast HashMap values to strings and login
        dbConn.login((String) credentials.get("username"), (String) credentials.get("password"));
        //System.out.println(dbConn.getRole());
        
        
        // Test getCourseData
        //dbConn.getCourseData(1);
        
        dbConn.disconnect();
    }
        
}
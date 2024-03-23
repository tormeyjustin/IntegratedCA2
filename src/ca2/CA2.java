/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

import java.sql.ResultSet;

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
        
        // Testing DB
        DbConnector dbConn = new DbConnector();
        System.out.println("Logged in: " + dbConn.isLoggedIn());
        System.out.println("Connected: " + dbConn.isConnected());
        
        // Connect to the database
        dbConn.connect();
        
        ResultSet rs = dbConn.executeQuery("SELECT * FROM collegelms.modules");
        System.out.println(rs);
        
        System.out.println("Logged in: " + dbConn.isLoggedIn());
        System.out.println("Connected: " + dbConn.isConnected());
        
        // Disconnect from the database
        dbConn.disconnect();
        System.out.println("Logged in: " + dbConn.isLoggedIn());
        System.out.println("Connected: " + dbConn.isConnected());
    }
    
}

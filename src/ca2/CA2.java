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
        
        DbConnector dbConn = new DbConnector();
        dbConn.connect();
        
        // Test login credentials
        dbConn.login("admin", "java");
        System.out.println(dbConn.getRole());
        
        dbConn.disconnect();
    }
        
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca2;

/**
 *
 * @author Justin
 * 
 */

public class CA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Testing DB
        DbConnector dbConnector = new DbConnector();
        
        // Connect to the database
        dbConnector.connect();
        
        // Disconnect from the database
        dbConnector.disconnect();
    }
    
}

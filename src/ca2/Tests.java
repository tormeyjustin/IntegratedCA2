/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

/**
 *
 * @author Justin
 * 
 */

public class Tests {
    
    public void testCSV() {
        // Connect to database
        DbConnector dbConn = new DbConnector();        
        dbConn.connect();
        
        // Get data
        dbConn.getCourseData(1);
        
        // Disconnect from database
        dbConn.disconnect();
    }
    
}

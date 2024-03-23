/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.sql.ResultSet;


/**
 *
 * @author Justin
 * 
 */

public interface DatabaseAccess {
        
    /* Start database connnection */  
    
    void connect();
    
    /* Execute a databse query and return a ResultSet*/  
    
    ResultSet executeQuery(String query);
    
    /* Handles login */
    
    void login(String username, String password);
    
    /* End database connection */   
    
    void disconnect();
    
}

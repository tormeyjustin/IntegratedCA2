/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author Justin
 * 
 */

public interface DatabaseConnection {
    
    public void connect();
    
    public HashMap<String, String>getLoginCredentials();
    
    public void login(String username, String password);
    
    public ResultSet getCourseData(int id);
    
    public void disconnect();
    
    // Getter method to check if the user is logged in
    boolean isLoggedIn();
    
    // Getter for user ID
    public int getId();
    
    // Getter for user role
    String getRole();
    
}

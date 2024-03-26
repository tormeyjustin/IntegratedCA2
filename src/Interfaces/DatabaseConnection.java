/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.HashMap;

/**
 *
 * @author Justin
 */
public interface DatabaseConnection {
    
    public void connect();
    
    public HashMap<String, String>getLoginCredentials();
    
    public void login(String username, String password);
    
    public void executeQuery(String sqlQuery);
    
    public void disconnect();
    
}

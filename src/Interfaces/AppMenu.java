/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Justin
 */
public interface AppMenu {
    
    // Request user input and return a Hashmap with key / value pairs for username and password
    public HashMap<String, String> getLoginCredentials();
    
    //  Display menu options based on role  
    public char mainOptions(String role);
    
}

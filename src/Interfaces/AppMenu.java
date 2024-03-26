/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.HashMap;

/**
 *
 * @author Justin
 * 
 */

public interface AppMenu {
    
    // Enum declarations
    
    // Report types
    public enum ReportType {
        COURSE,
        STUDENT,
        LECTURER
    }
    
    // Report formats
    public enum ReportFormat {
        TXT,
        CSV,
        CONSOLE
    }
    
         
    // Request user input and return a Hashmap with key / value pairs for username and password
    public HashMap<String, String> getLoginCredentials();
    
    //  Display filtered menu options based based on user role  
    public char mainMenuOptions(String role);
    
   
    // Manage account menu
    public void manageAccountMenu();
    
    
    // Choose report type
    public HashMap<String, String> reportFormatOptions();
    
    // Manage Users
    public void manageUsersMenu();
}

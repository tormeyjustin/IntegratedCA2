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
public interface AppMenu {
    
    // Request user input and return a Hashmap with key / value pairs for username and password
    public HashMap<String, String> getLoginCredentials();
    
    //  Display filtered menu options based based on user role  
    public char mainMenuOptions(String role);
    
    // Process main menu selected option
    public void mainSelectedOption(char opt);
    
    // Manage account menu
    public void manageAccountMenu();
        
    // Run a report menu
    public void runReportMenu();
    
    // Choose report type
    public int reportTypeOptions();
    
    // Choose report type
    public int reportFormatOptions();
    
    // Manage Users
    public void manageUsersMenu();
}

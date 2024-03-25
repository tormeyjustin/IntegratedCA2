/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Justin
 * 
 */

public class Menu implements Interfaces.AppMenu {
    public static String MenuRole;


    @Override
    public HashMap<String, String> getLoginCredentials() {
        String username;
        String password;
        HashMap<String, String> credentials = new HashMap();
        
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter username:");
        
        // Read the username provided by the user
        username = scanner.nextLine();
        
        System.out.println("Enter password:");
        
        // Read the username provided by the user
        password = scanner.nextLine();
        
        // Add keys and values
        credentials.put("username", username);
        credentials.put("password", password);

        // Close the scanner
        scanner.close();
        
        return credentials;
        
    }


    @Override
    public int mainOptions() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

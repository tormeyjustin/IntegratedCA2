/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Justin
 * 
 */

public class Menu implements Interfaces.AppMenu {
    private final Scanner scanner = new Scanner(System.in);
    public static String appRole;
    public static char selectedOption;
    public static String reportType = null;
    public static String reportFormat = null;
    private final String separator = "-------------------------------";


    @Override
    public HashMap<String, String> getLoginCredentials() {
        String username;
        String password;
        
        System.out.println(separator);
        System.out.println(separator);
        System.out.println("  College LMS");
        System.out.println(separator);
        System.out.println(separator);
        
        HashMap<String, String> credentials = new HashMap();
        
        System.out.println("Enter username:");
        
        // Read the username provided by the user
        username = scanner.nextLine();
        
        System.out.println("Enter password:");
        
        // Read the username provided by the user
        password = scanner.nextLine();
        
        // Add keys and values
        credentials.put("username", username);
        credentials.put("password", password);
        
        return credentials;
        
    }

    @Override
    public void displayMenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void handleAction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

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
    public static String appRole;
    public static char selectedOption = 'x';


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
    public char mainOptions(String role) {
        Menu.appRole = role;
        boolean validOption = false;
        
        // String to hold the avilable options
        // each chracter represents an option
        String availableOptions = "ax";
        
        // (a) Option for all users
        System.out.println("Please choose from the following options");
        System.out.println("(a) Manage my account");
        
        // (r) Option for "office" or "lecturer" only
        // TEMPORARILY ADDED ADMIN FOR TESTING
        if (role.equals("office") || (role.equals("lecturer")) || (role.equals("admin"))) {
            availableOptions = availableOptions + "r";
            System.out.println("(r) Run reports");
        }
        
        // (u) Option for "admin" only
        if (role.equals("admin")) {
            availableOptions = availableOptions + "u";
            System.out.println("(u) Manage users");
        }
        
        // (x) Option for all users
        System.out.println("(x) Exit"); 
        
        // Get a single character option and check
        Scanner sc = new Scanner(System.in);
        
        do {
            // Get the option
            selectedOption = sc.next().toLowerCase().charAt(0);

            // Check if the input character is present in the availableOptions
            if (availableOptions.indexOf(selectedOption) != -1) {
                validOption = true;
            } else {
                System.out.println("Invalid selection. Please choose from the options above");
            }
        } while (validOption == false);

        sc.close();
       
        return selectedOption;
    }

    @Override
    public void mainSelectedOption(char opt) {
        switch(opt) {
            case 'x':
                // Exit application
                System.out.println("Exiting application");
                System.exit(0);
            case 'a':
                manageAccount();
                break;
            case 'r':
                System.out.println("Run a Report");
                break;
            case 'u':
                System.out.println("Manage Users");
                break;
        }
     
    }

    @Override
    public void manageAccount() {
        System.out.println("Manage Account\n==============");
    }

    @Override
    public void runReport() {
        System.out.println("Run a Reportr\n==============");
    }
    
}

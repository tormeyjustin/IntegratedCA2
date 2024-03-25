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
    private Scanner scanner = new Scanner(System.in);
    public static String appRole;
    public static char selectedOption = 'x';
    private String separator = "-------------------------------";


    @Override
    public HashMap<String, String> getLoginCredentials() {
        String username;
        String password;
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
    public char mainMenuOptions(String role) {
        Menu.appRole = role;
        boolean validOption = false;
        
        // String to hold the avilable options
        // each chracter represents an option
        String availableOptions = "ax";
        
        // (a) Option for all users
        System.out.println("Main Menu");
        System.out.println(separator);
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
        do {
            // Get the option
            selectedOption = scanner.next().toLowerCase().charAt(0);

            // Check if the input character is present in the availableOptions
            if (availableOptions.indexOf(selectedOption) != -1) {
                validOption = true;
            } else {
                System.out.println("Invalid selection. Please choose from the options above");
            }
        } while (validOption == false);
       
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
                manageAccountMenu();
                break;
            case 'r':
                runReportMenu();
                break;
            case 'u':
                manageUsersMenu();
                break;
        }
     
    }

    @Override
    public void manageAccountMenu() {
        System.out.println(separator);
        System.out.println("Manage Account");
        System.out.println(separator);
    }

    @Override
    public void runReportMenu() {
        System.out.println(separator);
        System.out.println("Run a Report");
        System.out.println(separator);
        
        // Display available report format options
        reportTypeOptions();
    }
    
    @Override
    public int reportTypeOptions() {
        int selection;
        
        System.out.println("Available Report Types:");
        System.out.println("(1) Course Report");
        System.out.println("(2) Student Report");
        System.out.println("(3) Lecturer Report");
        
        selection = getMenuOption(3);
        return selection;
    }
    
    @Override
    public int reportFormatOptions() {
        System.out.println("Availale Report Formats:");
        System.out.println("(1) Text file");
        System.out.println("(2) CSV File");
        System.out.println("(3) Console Output");
        
        int selection = getMenuOption(3); 
        return selection;
    }
    
    @Override
    public void manageUsersMenu() {
        System.out.println(separator);
        System.out.println("Manage Users");
        System.out.println(separator);
    } 
    
    public int getMenuOption(int max) {
        int userInput;
        
        do {
            System.out.print("Enter a number between 1 and " + max + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number! Please enter a valid number: ");
                scanner.next();
            }
            userInput = scanner.nextInt();
        } while (userInput < 1 || userInput > max);
        
        return userInput;
    }
           
}

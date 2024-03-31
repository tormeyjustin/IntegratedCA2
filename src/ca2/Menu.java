/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Justin
 * 
 */

public class Menu implements Interfaces.AppMenu {
    private String role;
    private int user_id;
    private static final Scanner scanner = new Scanner(System.in);
    
    
    @Override
    public HashMap<String, String> getLoginCredentials() { 
        HashMap<String, String> credentials;
            String username;
            String password;
            System.out.println("----------------");
            System.out.println("  College LMS");
            System.out.println("----------------");
            credentials = new HashMap();
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
    public void displayMainMenu() {
        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Manage Account");
            System.out.println("2. Generate Reports");
            System.out.println("3. Add / Modify Users");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manageAccount();
                    break;
                case 2:
                    generateReports();
                    break;
                case 3:
                    addModifyUsers();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-4.");
            }
        } while (choice != 4); // Exit when 4 is selected
        
    }
    
    public void manageAccount() {
        int choice;
        do {
            System.out.println("\n--- Manage Account ---");
            System.out.println("1. Change username");
            System.out.println("2. Change password");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("Change username");
                        break;
                    case 2:
                        System.out.println("Change password");
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-3.");
            }
        } while (choice != 3); // Exit when 3 is selected
    }
    
    public void generateReports() {
        int choice;
        do {
            System.out.println("\n--- Generate Reports ---");
            System.out.println("1. Course Report");
            System.out.println("2. Student Report");
            System.out.println("3. Lecturer Report");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("Course Report");
                        break;
                    case 2:
                        System.out.println("Student Report");
                        break;
                    case 3:
                        System.out.println("Lecturer Report");
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-4.");
            }
        } while (choice != 4); // Exit when 4 is selected  
    }
    
    public void addModifyUsers() {
        int choice;
        do {
            System.out.println("\n--- Add Modify Users ---");
            System.out.println("1. Add User");
            System.out.println("2. Modify User");
            System.out.println("3. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.println("Add User");
                        break;
                    case 2:
                        System.out.println("Modify User");
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1-4.");
            }
        } while (choice != 3); // Exit when 3 is selected  
    }
         
    // Getters
    public String getRole() {
        return this.role;
    }

    // Setters 
    public void setRole(String role) {
        this.role = role;
    }
}

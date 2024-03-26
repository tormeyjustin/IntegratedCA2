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
    public char mainMenuOptions(String role) {
        Menu.appRole = role;
        boolean validOption = false;
        
        // String to hold the avilable options
        // each chracter represents an option
        String availableOptions = "ax";
        
        // (a) Option for all users
        System.out.println(separator);
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
    public void manageAccountMenu() {
        System.out.println(separator);
        System.out.println("Manage Account");
        System.out.println(separator);
        
        System.out.println("Account Options:");
        System.out.println("(1) Change username");
        System.out.println("(2) Change password");
        
        getMenuOption(2);
    }
        
    
    @Override
    public HashMap<String, String>  reportFormatOptions() {
        System.out.println(separator);
        System.out.println("Run a Report");
        System.out.println(separator);
        
        System.out.println("Available Report Types:");
        System.out.println("(1) Course Report");
        System.out.println("(2) Student Report");
        System.out.println("(3) Lecturer Report");
        
        while (reportType == null) {
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    reportType = ReportType.COURSE.name();
                    break;
                case 2:
                    reportType = ReportType.STUDENT.name();
                    break;
                case 3:
                    reportType = ReportType.LECTURER.name();
                    break;
                default:
                    System.out.println("Please choose one of the options.");
                    break;
            }
        }
        
        HashMap<String, String> report = new HashMap();
        
        System.out.println("Available Report Formats:");
        System.out.println("(1) Text file");
        System.out.println("(2) CSV File");
        System.out.println("(3) Console Output");
            
        while (reportFormat == null) {
            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    reportFormat = ReportFormat.TXT.name();
                    break;
                case 2:
                    reportFormat = ReportFormat.CSV.name();
                    break;
                case 3:
                    reportFormat = ReportFormat.CONSOLE.name();
                    break;
                default:
                    System.out.println("Please choose from one of the options.");
                    break;
            }
        }
        
        System.out.println("You have selected " + reportType + " report, in " + reportFormat + " format.");
        
        // Add keys and values
        report.put("type", reportType);
        report.put("format", reportFormat);
        return report;
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
                System.out.println("Please enter a valid number: ");
                scanner.next();
            }
            userInput = scanner.nextInt();
        } while (userInput < 1 || userInput > max);
        
        return userInput;
    }
    
    public String getReportType(){
        return reportType;
    }
    
    public String getReportFormat(){
        return reportFormat;
    }
}

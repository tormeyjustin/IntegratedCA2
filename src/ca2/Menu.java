/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Justin
 * 
 */

public class Menu implements Interfaces.AppMenu {
    private String role;
    private int user_id;
    private List<String> options;


    @Override
    public void displayMainMenu() {
        System.out.println(this.role);
        
        options = Arrays.asList("Manage Account", "Generate Reports", "Add / Modify Users", "Exit");
        
        System.out.println("Please choose one of the following options:");
        for (int i = 0; i < options.size(); i++ ) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        
        
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

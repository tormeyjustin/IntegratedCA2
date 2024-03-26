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
    
    public HashMap<String, String>getLoginCredentials();
    
    void displayMenu();
    
    void handleAction();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author Justin
 * 
 */

public interface DatabaseAccess {
    
    /* Start database connnection */    
    void connect();
    
    /* Handle database query */    
    void executeQuery();
    
    /* End database connnection */    
    void disconnect();
    
}

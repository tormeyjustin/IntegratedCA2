/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Justin
 * Timestamp to be appended to output files to avoid overwriting existing files
 * 
 */

public class Timestamp {
    
    public static String getStamp() {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        
        // Format the timestamp and return as a string
        return now.format(formatter);
    }
}

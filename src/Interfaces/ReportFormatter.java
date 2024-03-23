/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.sql.ResultSet;

/**
 *
 * @author Justin
 * 
 */

public interface ReportFormatter {
    
    // Generate .txt report
    void txtOutput(ResultSet rs);
    
    // Generate .csv report
    void csvOutput(ResultSet rs);
    
    // Output to console
    void consoleOutput(ResultSet rs);
    
}

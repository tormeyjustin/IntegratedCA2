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

public interface DatabaseAccess {
        
    /* Start database connnection */  
    void connect();
    
    /* Handles login */
    void login(String username, String password);
    
    /* Get data for a course */
    void getCourseData(int courseId);
    
    /* Get data for a student */
    void getStudentData(int studentId);
    
    /* Get data for a lecturer */
    void getLecturerData(int lecturerId);
    
    /* End database connection */   
    void disconnect();
    
}

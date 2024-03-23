/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import ca2.User;
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
    
    /* Get data for a course report */
    void getCourseData(int courseId);
    
    /* Get data for a student report */
    void getStudentData(int studentId);
    
    /* Get data for a lecturer report */
    void getLecturerData(int lecturerId);
    
    /* Get a user from the database */
    User getUser(int userId);
    
    /* Add a new user */
    void addUser(User user);
    
    /* End database connection */   
    void disconnect();
    
}

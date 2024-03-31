/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import CA2.CourseModule;
import CA2.Lecturer;
import CA2.Student;
import CA2.User;
import java.util.ArrayList;

/**
 *
 * @author Justin
 * 
 */

public interface DatabaseConnection {
      
    public User login(String username, String password);
    
    public ArrayList<CourseModule> getCourseData(int id);
    
    public Student getStudentData(String email);
    
    public Lecturer getLecturerData(int id);
    
    // Getter method to check if the user is logged in
    boolean isLoggedIn();
    
    // Getter for user ID
    public int getId();
    
    // Getter for user role
    public String getRole();
    
}

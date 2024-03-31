/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

/**
 *
 * @author Justin
 * 
 */


public class CourseModule {
    String moduleName;
    private String programme;
    private int enrolledStudents;
    private String lecturerName;
    private String room;
    
    public CourseModule (String module, String programme, int numStudents, String lecturer, String room) {
        this.moduleName = module;
        this.programme = programme;
        this.enrolledStudents = numStudents;
        this.lecturerName = lecturer;
        this.room = room;
    }
    
    
    // Getters
    
    public String getModuleName() {
        return moduleName;
    }

    public String getProgramme() {
        return programme;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public String getRoom() {
        return room;
    }
   
}

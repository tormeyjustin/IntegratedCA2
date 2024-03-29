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
    
    
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String Programme) {
        this.programme = Programme;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(int enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
    
}

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

public class Student {
    private final String firstName;
    private final String lastName;
    private final int studentNumber;
    private final String studentCourse;
    
    public Student(String firstName, String lastName, int studentNumber, String studentCourse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.studentCourse = studentCourse;

    } 
    

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * @return the studentCourse
     */
    public String getStudentCourse() {
        return studentCourse;
    }

}

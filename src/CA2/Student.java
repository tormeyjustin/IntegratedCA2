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

    public String prepareOutput() {
        // Create a StringBuilder object
        StringBuilder builder = new StringBuilder();

        builder.append("Student name: ").append(firstName).append(" ").append(lastName);
        builder.append("\n");
        builder.append("Student number: ").append(studentNumber);
        builder.append("\n");
        builder.append("Course enrolled: ").append(studentCourse);
        builder.append("\n");

        // Convert StringBuilder to String
        String outputString = builder.toString();
        return outputString;
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

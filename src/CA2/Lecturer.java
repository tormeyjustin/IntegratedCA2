/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.util.List;
import java.util.StringJoiner;

/**
 *
 * @author Justin
 *
 */
public class Lecturer {

    private String firstName;
    private String lastName;
    private String role;
    private List<String> modulesTeaching;
    private List<String> skills;

    public Lecturer(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
    
    
    public String prepareOutput() {
        // Create a StringBuilder object
        StringBuilder builder = new StringBuilder();

        builder.append("Lecturer name: ").append(firstName).append(" ").append(lastName);
        builder.append("\n");
        builder.append("Lecturer role: ").append(role);
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
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @return the modulesTeaching
     */
    public List getModulesTeaching() {
        return modulesTeaching;
    }

    /**
     * @return the skills
     */
    public List getSkills() {
        return skills;
    }

}

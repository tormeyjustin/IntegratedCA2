/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.util.List;

/**
 *
 * @author Justin
 * 
 */

public class Lecturer {
    private String firstName;
    private String lastName;
    private String role;
    private List modulesTeaching;
    private List skills;
    
    public Lecturer (String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

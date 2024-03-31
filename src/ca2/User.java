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

public class User {
    
    enum userRole {
        ADMIN,
        OFFICE,
        LECTURER
    }
    
    private final int user_id;
    private final String first_name;
    private final String last_name;
    private final String username;
    private String user_email;
    private final String password;
    private final String user_role;
    
    public User (int id, String user_role ) {
        this.user_id = id;
        this.first_name = null;
        this.last_name = null;
        this.username = null;
        this.password = null;
        this.user_role = user_role;
    }
    
    
    public User (int id, String first_name, String last_name, String username, String password, String user_role) {
        this.user_id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
        this.user_role = user_role;
    }
    
}

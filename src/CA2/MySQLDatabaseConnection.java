/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import Utils.PasswordEncrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author Justin
 * 
 */

public class MySQLDatabaseConnection implements Interfaces.DatabaseConnection {
    // DB credentials
    private final String DB_URL = "jdbc:mysql://localhost/collegelms";
    private final String USER = "pooa";
    private final String PASSWORD = "pooa";
    private Connection conn;
    private final String separator = "-------------------------------";
    
    // Logged in to DB status for an app user
    public boolean loggedIn = false;
    
    // Logged in role
    private String userRole;
    private int userId;

    @Override
    public void connect() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database sucessfully connected;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public HashMap<String, String> getLoginCredentials() {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        
        System.out.println(separator);
        System.out.println(separator);
        System.out.println("  College LMS");
        System.out.println(separator);
        System.out.println(separator);
        
        HashMap<String, String> credentials = new HashMap();
        
        System.out.println("Enter username:");
        
        // Read the username provided by the user
        username = sc.nextLine();
        
        System.out.println("Enter password:");
        
        // Read the username provided by the user
        password = sc.nextLine();
        
        // Add keys and values
        credentials.put("username", username);
        credentials.put("password", password);
        
        sc.close();
        return credentials;
        
    }

    @Override
    public void login(String username, String password){
        // Check connection status
        if(conn == null) {
            System.out.println("Database not connnected.");
        } else {
            // SHA256 encrypt the input password for comparison
            PasswordEncrypt pse = new PasswordEncrypt();
            String inputPasswordHash = pse.getSHA256Hash(password);
                        
            // Get hashed password from database
            String sql =    "SELECT u.id, u.password_hash, r.role_name " + 
                            "FROM collegelms.users u " + 
                            "LEFT JOIN collegelms.user_roles r " +
                            "ON u.user_role = r.id WHERE u.username = ?;";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                
                // Set the value of the placeholder to username
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String dbPasswordHash = rs.getString("password_hash");
                    
                    
                    // Check password hashes for a match and set loggedIn to true
                    if (inputPasswordHash.equals(dbPasswordHash)) {
                        loggedIn = true;
                        userRole = rs.getString("role_name");
                        userId = Integer.valueOf(rs.getString("id"));
                        
                        System.out.println("Logged in successfully");
                    } else {
                        System.out.println("Username or password not found.");
                    }
                    
                } else {
                    System.out.println("Username or password not found.");
                }
                 
            } catch (SQLException ex) {
                System.out.println("Error " + ex);
            }
            
        }
        
    }
    
    @Override
    public void executeQuery(String sqlQuery) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void disconnect() {
       try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Disconnected from the database.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    // Getters

    public boolean isLoggedIn() {
        return this.loggedIn;
    }
    
    public int getId(){
        return this.userId;
    }
    public String getRole() {
        return this.userRole;
    }  
}

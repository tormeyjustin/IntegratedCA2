/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Justin
 * 
 */

public class DbConnector implements Interfaces.DatabaseAccess {
    // DB credentials
    private final String DB_URL = "jdbc:mysql://localhost/collegelms";
    private final String USER = "pooa";
    private final String PASSWORD = "pooa";
    private String role;

    @Override
    public void connect() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database sucessfully connected;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeQuery(String query) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {

        while (rs.next()) {
            String moduleId = rs.getString("module_id");
            String moduleName = rs.getString("module_name");
            System.out.println("Module ID: " + moduleId + ", Module Name: " + moduleName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean login(String username, String password){
        // Check username
        
        // Check password (SHA256)
        
        // Check role/access level
        
        return true;
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
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    private Connection conn;
    private boolean loggedIn;
    private String role;

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
    public ResultSet executeQuery(String query) {
       if (conn == null ) {
            System.out.println("Database Connnection Error");
        } else {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet;
            } catch (SQLException ex) {
                Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        return null;
    }
    
    @Override
    public void login(String username, String password){
        // Check username
        
        // Check password (SHA256)
        
        // Check role/access level
        
        // If logged in 
        this.loggedIn = true;
        
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
    
    public boolean isConnected() {
        return false;
    }
    
    public boolean isLoggedIn() {
        return this.loggedIn;
    }
    
}

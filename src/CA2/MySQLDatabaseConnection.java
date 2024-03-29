/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

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
        HashMap<String, String> credentials;
        try (Scanner sc = new Scanner(System.in)) {
            String username;
            String password;
            System.out.println(separator);
            System.out.println(separator);
            System.out.println("  College LMS");
            System.out.println(separator);
            System.out.println(separator);
            credentials = new HashMap();
            System.out.println("Enter username:");
            // Read the username provided by the user
            username = sc.nextLine();
            System.out.println("Enter password:");
            // Read the username provided by the user
            password = sc.nextLine();
            // Add keys and values
            credentials.put("username", username);
            credentials.put("password", password);
        }
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
    public ResultSet getReportData(String reportType, int id) {
        // Define an empty result set
        ResultSet rs = null;
        if(conn == null) {
            System.out.println("Database not connnected.");
        } else {
            
            switch (reportType) {
                case "COURSE":
                    // Get course data
                    System.out.println("Get course data");
                    rs = getCourseData(id);
                    break;
                case "STUDENT":
                    // Get student data
                    System.out.println("Get Student data");
                    break;
                case "LECTURER":
                    // Get lecturer data
                    System.out.println("Get Lecturer data");
                    break;
            }
             
        }
        
        return rs;
    }
    
    private ResultSet getCourseData(int id) {
        ResultSet rs = null;
        
        String sqlquery = "SELECT m.module_name AS \"Module Name\", "
             + "c.course_title AS \"Programme\", "
             + "COUNT(DISTINCT em.student_id) AS \"Number of Students Enrolled\", "
             + "CONCAT(u.first_name, ' ', u.last_name) AS \"Lecturer\", "
             + "ro.room_name AS \"Room Assigned\" "
             + "FROM collegelms.modules m "
             + "JOIN collegelms.course_modules cm ON m.id = cm.module_id "
             + "JOIN collegelms.courses c ON cm.course_id = c.id "
             + "LEFT JOIN collegelms.enrolment_modules em ON cm.id = em.course_id "
             + "JOIN collegelms.lecturers l ON cm.lecturer_id = l.id "
             + "JOIN collegelms.users u ON l.user_id = u.id "
             + "JOIN collegelms.rooms ro ON cm.room_id = ro.id "
             + "WHERE c.id = ? " // Placeholder for the course ID
             + "GROUP BY m.module_name, c.course_title, u.first_name, u.last_name, ro.room_name "
             + "ORDER BY \"Module Name\"";
        
        try (PreparedStatement stmt = conn.prepareStatement(sqlquery)) {
                
                // Convert the id to String and insert into SQL statement
                stmt.setString(1, String.valueOf(id));
                
                rs = stmt.executeQuery();
        } catch (SQLException ex) {
                System.out.println("Error " + ex);
            }
        
        return rs;
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

    @Override
    public boolean isLoggedIn() {
        return this.loggedIn;
    }
    
    @Override
    public int getId(){
        return this.userId;
    }
    
    @Override
    public String getRole() {
        return this.userRole;
    }  

}

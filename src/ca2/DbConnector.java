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
                Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
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

    @Override
    public void getCourseData(int courseId) {
        // Check connection status
        if(conn == null) {
            System.out.println("Database not connnected.");
        } else {
            String sql =    "SELECT m.module_name AS 'Module Name', c.course_title AS 'Programme', COUNT(DISTINCT em.student_id) AS 'Number of Students Enrolled', CONCAT(u.first_name, ' ', u.last_name) AS 'Lecturer', ro.room_name AS 'Room Assigned' " +
                            "FROM collegelms.modules m " +
                            "JOIN collegelms.course_modules cm ON m.id = cm.module_id " +
                            "JOIN collegelms.courses c ON cm.course_id = c.id " +
                            "LEFT JOIN collegelms.enrolment_modules em ON cm.id = em.course_id " +
                            "JOIN collegelms.lecturers l ON cm.lecturer_id = l.id " +
                            "JOIN collegelms.users u ON l.user_id = u.id " +
                            "JOIN collegelms.rooms ro ON cm.room_id = ro.id " +
                            "GROUP BY m.module_name, c.course_title, u.first_name, u.last_name, ro.room_name " +
                            "ORDER BY 'Module Name'";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
        }   catch (SQLException ex) {
                Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void modifyUser(String userId, String username, String password) {
        // Check connection status
        if(conn == null) {
            System.out.println("Database not connnected.");
        } else {
            String sql =    "";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Set the value of the placeholder to user ID
                stmt.setString(1, userId);
                ResultSet rs = stmt.executeQuery();
        }   catch (SQLException ex) {
                Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public ResultSet getReportData(String reportType) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        

    @Override
    public void getStudentData(int studentId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getLecturerData(int lecturerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUser(int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

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

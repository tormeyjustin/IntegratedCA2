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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    
    // Logged in to DB status for an app user
    public boolean loggedIn = false;
    
    // Logged in role
    private String userRole;
    private int userId;
    

    @Override
    @SuppressWarnings("empty-statement")
    public void login(String username, String password){
        try {
            // Connect to database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
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
                        userId = Integer.parseInt(rs.getString("id"));
                        
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
            
        } catch (SQLException ex) {
            System.out.println("Error "+ ex);;
        }  
    }
    
//    
//    public ArrayList<CourseModule> getCourseData(int id) throws SQLException {
//        
//        String sqlquery = "SELECT m.module_name AS \"module_name\", "
//             + "c.course_title AS \"programme\", "
//             + "COUNT(DISTINCT em.student_id) AS \"number_students\", "
//             + "CONCAT(u.first_name, ' ', u.last_name) AS \"lecturer\", "
//             + "ro.room_name AS \"room_name\" "
//             + "FROM collegelms.modules m "
//             + "JOIN collegelms.course_modules cm ON m.id = cm.module_id "
//             + "JOIN collegelms.courses c ON cm.course_id = c.id "
//             + "LEFT JOIN collegelms.enrolment_modules em ON cm.id = em.course_id "
//             + "JOIN collegelms.lecturers l ON cm.lecturer_id = l.id "
//             + "JOIN collegelms.users u ON l.user_id = u.id "
//             + "JOIN collegelms.rooms ro ON cm.room_id = ro.id "
//             + "WHERE c.id = ? " // Placeholder for the course ID
//             + "GROUP BY m.module_name, c.course_title, u.first_name, u.last_name, ro.room_name "
//             + "ORDER BY \"module_name\"";
//        
//        try (PreparedStatement stmt = conn.prepareStatement(sqlquery)) {
//            
//
//                // Insert the id into SQL statement
//                stmt.setInt(1, id);
//                
//                ResultSet rs = stmt.executeQuery();
//                System.out.println(rs);
//                
//                ArrayList<CourseModule> courseData = new ArrayList<>();
//                
//                while (rs.next()) {
//                    String moduleName = rs.getString("module_name");
//                    String programme = rs.getString("programme");
//                    int numStudents = rs.getInt("number_students");
//                    String lecturer = rs.getString("lecturer");
//                    String room = rs.getString("room_name");
//                    
//                    courseData.add(new CourseModule(moduleName, programme, numStudents, lecturer, room));
//                }
//                
//                return courseData;
//                
//        } catch (SQLException ex) {
//                System.out.println("Error " + ex);
//            }
//        return null;
//        
//    }
    
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

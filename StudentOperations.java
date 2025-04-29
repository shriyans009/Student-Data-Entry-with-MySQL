// StudentOperations.java

import java.sql.*;
import java.util.*;

public class StudentOperations {

    // Add Student
    public void addStudent(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO students (prn, name, dept, batch, cgpa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, student.getPRN());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getDept());
            stmt.setString(4, student.getBatch());
            stmt.setFloat(5, student.getCGPA());
            stmt.executeUpdate();
            System.out.println("Student added successfully to the database.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    
}

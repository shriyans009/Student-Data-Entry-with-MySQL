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

    // Display all students
    public void displayStudents() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") + " | PRN: " + rs.getInt("prn") +
                        " | Dept: " + rs.getString("dept") + " | Batch: " + rs.getString("batch") +
                        " | CGPA: " + rs.getFloat("cgpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    // Search Student by PRN
    public void searchByPRN(int prn) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM students WHERE prn = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, prn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Student Found: ");
                System.out.println("Name: " + rs.getString("name") + " | PRN: " + rs.getInt("prn") +
                        " | Dept: " + rs.getString("dept") + " | Batch: " + rs.getString("batch") +
                        " | CGPA: " + rs.getFloat("cgpa"));
            } else {
                System.out.println("Student with PRN " + prn + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }

    
    
}

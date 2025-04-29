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

    // Search by Name
    public void searchByName(String name) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM students WHERE name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("Student Found: ");
                System.out.println("Name: " + rs.getString("name") + " | PRN: " + rs.getInt("prn") +
                        " | Dept: " + rs.getString("dept") + " | Batch: " + rs.getString("batch") +
                        " | CGPA: " + rs.getFloat("cgpa"));
            }
            if (!found) {
                System.out.println("Student with name " + name + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching student: " + e.getMessage());
        }
    }

    // Search by Position (row number)
    public void searchByPosition(int position) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM students LIMIT 1 OFFSET ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, position);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Student at Position " + position + ":");
                System.out.println("Name: " + rs.getString("name") + " | PRN: " + rs.getInt("prn") +
                        " | Dept: " + rs.getString("dept") + " | Batch: " + rs.getString("batch") +
                        " | CGPA: " + rs.getFloat("cgpa"));
            } else {
                System.out.println("No student found at the given position.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Update Student
    public void updateStudent(int prn) {
        Scanner scan = new Scanner(System.in);
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM students WHERE prn = ?";
            PreparedStatement checkStmt = conn.prepareStatement(query);
            checkStmt.setInt(1, prn);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                System.out.println("Enter new Name (leave blank to keep current): ");
                String name = scan.nextLine();
                if (name.isEmpty()) name = rs.getString("name");

                System.out.println("Enter new Dept (leave blank to keep current): ");
                String dept = scan.nextLine();
                if (dept.isEmpty()) dept = rs.getString("dept");

                System.out.println("Enter new Batch (leave blank to keep current): ");
                String batch = scan.nextLine();
                if (batch.isEmpty()) batch = rs.getString("batch");

                System.out.println("Enter new CGPA (or -1 to keep current): ");
                String input = scan.nextLine();
                float cgpa = input.isEmpty() || Float.parseFloat(input) == -1 ? rs.getFloat("cgpa") : Float.parseFloat(input);

                String updateQuery = "UPDATE students SET name=?, dept=?, batch=?, cgpa=? WHERE prn=?";
                PreparedStatement stmt = conn.prepareStatement(updateQuery);
                stmt.setString(1, name);
                stmt.setString(2, dept);
                stmt.setString(3, batch);
                stmt.setFloat(4, cgpa);
                stmt.setInt(5, prn);
                stmt.executeUpdate();
                System.out.println("Student details updated successfully.");
            } else {
                System.out.println("Student with PRN " + prn + " not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    // Delete Student
    public void deleteStudent(int prn) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "DELETE FROM students WHERE prn=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, prn);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0)
                System.out.println("Student deleted successfully.");
            else
                System.out.println("Student with PRN " + prn + " not found.");
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}

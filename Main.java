// Main.java
import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        StudentOperations operations = new StudentOperations();
        int choice;

        do {
            System.out.println("\n========= Student Management System =========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Search Student by Position");
            System.out.println("6. Update Student Details");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scan.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = scan.nextLine();
                        System.out.print("Enter PRN: ");
                        int prn = Integer.parseInt(scan.nextLine());
                        System.out.print("Enter Dept: ");
                        String dept = scan.nextLine();
                        System.out.print("Enter Batch: ");
                        String batch = scan.nextLine();
                        System.out.print("Enter CGPA: ");
                        float cgpa = Float.parseFloat(scan.nextLine());

                        Student student = new Student(name, prn, dept, batch, cgpa);
                        operations.addStudent(student);
                        break;

                    case 2:
                        operations.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter PRN to search: ");
                        prn = Integer.parseInt(scan.nextLine());
                        operations.searchByPRN(prn);
                        break;

                    case 4:
                        System.out.print("Enter Name to search: ");
                        name = scan.nextLine();
                        operations.searchByName(name);
                        break;

                    case 5:
                        System.out.print("Enter position to search: ");
                        int position = Integer.parseInt(scan.nextLine());
                        operations.searchByPosition(position);
                        break;

                    case 6:
                        System.out.print("Enter PRN to update details: ");
                        prn = Integer.parseInt(scan.nextLine());
                        operations.updateStudent(prn);
                        break;

                    case 7:
                        System.out.print("Enter PRN to delete student: ");
                        prn = Integer.parseInt(scan.nextLine());
                        operations.deleteStudent(prn);
                        break;

                    case 8:
                        System.out.println("Exiting Program. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numeric input.");
                choice = -1; // Reset choice so loop continues
            }
        } while (choice != 8);

        scan.close();
    }
}

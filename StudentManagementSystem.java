import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    static final String URL =
        "jdbc:mysql://localhost:3306/student_management";
    static final String USER = "root";
    static final String PASSWORD = "123456789";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(
                 URL, USER, PASSWORD);
             Scanner sc = new Scanner(System.in)) {

            System.out.println("Connected to MySQL!");

            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";

                        try (PreparedStatement ps =
                                 con.prepareStatement(sql)) {
                            ps.setInt(1, id);
                            ps.setString(2, name);
                            ps.setString(3, course);
                            ps.setDouble(4, marks);
                            ps.executeUpdate();
                            System.out.println("Student added successfully!");
                        }
                    }

                    case 2 -> {
                        String sql = "SELECT * FROM students";

                        try (Statement st = con.createStatement();
                             ResultSet rs = st.executeQuery(sql)) {
                            System.out.println("\nID | Name | Course | Marks");

                            while (rs.next()) {
                                System.out.println(
                                    rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getString("course") + " | " +
                                    rs.getDouble("marks"));
                            }
                        }
                    }

                    case 3 -> {
                        System.out.print("Enter student ID to update: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter new Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter new Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter new Marks: ");
                        double marks = Double.parseDouble(sc.nextLine());

                        String sql =
                            "UPDATE students SET name=?, course=?, marks=? WHERE id=?";

                        try (PreparedStatement ps =
                                 con.prepareStatement(sql)) {
                            ps.setString(1, name);
                            ps.setString(2, course);
                            ps.setDouble(3, marks);
                            ps.setInt(4, id);

                            int rows = ps.executeUpdate();
                            System.out.println(rows > 0
                                ? "Student updated successfully!"
                                : "Student ID not found.");
                        }
                    }

                    case 4 -> {
                        System.out.print("Enter student ID to delete: ");
                        int id = Integer.parseInt(sc.nextLine());

                        try (PreparedStatement ps = con.prepareStatement(
                                 "DELETE FROM students WHERE id=?")) {
                            ps.setInt(1, id);

                            int rows = ps.executeUpdate();
                            System.out.println(rows > 0
                                ? "Student deleted successfully!"
                                : "Student ID not found.");
                        }
                    }

                    case 5 -> {
                        System.out.println("Program closed.");
                        return;
                    }

                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }
}
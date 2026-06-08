import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Grade Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAll();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine();
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No students to calculate average!");
            return;
        }
        double sum = 0;
        for (Student s : students) {
            sum += s.getMarks();
        }
        System.out.println("Average Marks: " + (sum / students.size()));
    }
}
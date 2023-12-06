package myproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceTracker {
    public HashMap<String, HashMap<String, Integer>> userAttendance;
    public int totalClasses = 30;
    public static AttendanceTracker tracker = new AttendanceTracker();

    Map<String, Integer> subjectConstraints = new HashMap<>();

    public AttendanceTracker() {
        userAttendance = new HashMap<>();
        subjectConstraints.put("Microprocessor and embedded system", totalClasses);
        subjectConstraints.put("Container Orchestration", totalClasses);
        subjectConstraints.put("Compiler design", totalClasses);
        subjectConstraints.put("Cloud performance tuning", totalClasses);
        subjectConstraints.put("CSF", totalClasses);
    }

    public void addUser(String userName) {
        userAttendance.put(userName, new HashMap<>());
    }

    public void updateAttendance(String userName, String subject) {
        if (userAttendance.containsKey(userName)) {
            if (subjectConstraints.containsKey(subject)) {
                userAttendance.get(userName).put(subject, userAttendance.get(userName).getOrDefault(subject, 0) + 1);
                System.out.println("Attendance updated successfully.");
            } else {
                System.out.println("Subject not found in constraints.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void viewAttendance(String userName) {
        if (userAttendance.containsKey(userName)) {
            HashMap<String, Integer> userSubjects = userAttendance.get(userName);
            for (Map.Entry<String, Integer> entry : userSubjects.entrySet()) {
                String subject = entry.getKey();
                int attendedClasses = entry.getValue();
                System.out.printf("%s's attendance in %s: %d out of %d classes\n", userName, subject, attendedClasses,
                        totalClasses);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    public void viewAttendanceForAllStudents(String subject) {
        if (subjectConstraints.containsKey(subject)) {
            System.out.println("Attendance for all students in " + subject + ":");
            for (Map.Entry<String, HashMap<String, Integer>> entry : userAttendance.entrySet()) {
                String userName = entry.getKey();
                if (entry.getValue().containsKey(subject)) {
                    int attendedClasses = entry.getValue().get(subject);
                    System.out.printf("%s's attendance in %s: %d out of %d classes\n", userName, subject,
                            attendedClasses, totalClasses);
                } else {
                    System.out.printf("%s has not attended %s\n", userName, subject);
                }
            }
        } else {
            System.out.println("Subject not found in constraints.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.println("Attendance Tracking:");
            System.out.println("1. Update Attendance");
            System.out.println("2. Add Student Name");
            System.out.println("3. View Attendance Subject-wise");
            System.out.println("4. View Attendance for All Students in a Subject");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Consume newline character
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    tracker.updateAttendance(studentName, subject);
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    String newStudentName = scanner.nextLine();
                    tracker.addUser(newStudentName);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    String viewStudentName = scanner.nextLine();
                    tracker.viewAttendance(viewStudentName);
                    break;
                case 4:
                    System.out.print("Enter subject: ");
                    String viewSubject = scanner.nextLine();
                    tracker.viewAttendanceForAllStudents(viewSubject);
                    break;
                case 5:
                    System.out.println("Exiting");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

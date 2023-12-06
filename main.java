package myproject;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LoginSystem loginSystem = new LoginSystem();
        AttendanceTracker attendanceTracker = new AttendanceTracker();
        progress_leaderboards progressLeaderboards = new progress_leaderboards();

        while (true) {
            System.out.println("Project Workflow:");
            System.out.println("1. Login System");
            System.out.println("2. Attendance Tracker");
            System.out.println("3. Progress Leaderboards");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    loginSystemWorkflow(loginSystem, scanner);
                    break;
                case 2:
                    attendanceTrackerWorkflow(attendanceTracker, scanner);
                    break;
                case 3:
                    progressLeaderboardsWorkflow(progressLeaderboards, scanner);
                    break;
                case 4:
                    System.out.println("Exiting the project.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void loginSystemWorkflow(LoginSystem loginSystem, Scanner scanner) {
        while (true) {
            System.out.println("Login System:");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    loginSystem.registerUser(scanner);
                    break;
                case 2:
                    loginSystem.loginUser(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void attendanceTrackerWorkflow(AttendanceTracker attendanceTracker, Scanner scanner) {
        while (true) {
            System.out.println("Attendance Tracker:");
            System.out.println("1. Update Attendance");
            System.out.println("2. Add Student Name");
            System.out.println("3. View Attendance Subject-wise");
            System.out.println("4. View Attendance for All Students in a Subject");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    attendanceTracker.updateAttendance(studentName, subject);
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    String newStudentName = scanner.nextLine();
                    attendanceTracker.addUser(newStudentName);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    String viewStudentName = scanner.nextLine();
                    attendanceTracker.viewAttendance(viewStudentName);
                    break;
                case 4:
                    System.out.print("Enter subject: ");
                    String viewSubject = scanner.nextLine();
                    attendanceTracker.viewAttendanceForAllStudents(viewSubject);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void progressLeaderboardsWorkflow(progress_leaderboards progressLeaderboards, Scanner scanner) {
        while (true) {
            System.out.println("Progress Leaderboards:");
            System.out.println("1. Enter User Progress");
            System.out.println("2. Display Overall Progress for a User");
            System.out.println("3. Display Leaderboard (Subject-wise)");
            System.out.println("4. Display Leaderboard (Overall)");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    progressLeaderboards.enterUserProgress(progressLeaderboards.subjectConstraints,
                            progressLeaderboards.userProgressMap, scanner);
                    break;
                case 2:
                    progressLeaderboards.displayUserProgress(progressLeaderboards.userProgressMap,
                            progressLeaderboards.subjectConstraints, scanner);
                    break;
                case 3:
                    //functionality for subject-wise leaderboard
                    break;
                case 4:
                    //functionality for overall leaderboard
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


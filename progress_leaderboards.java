package myproject;

import java.util.*;

public class progress_leaderboards {

     public static Map<String, int[]> subjectConstraints = new HashMap<>();
     public static Map<String, Map<String, Integer>> userProgressMap = new HashMap<>();
    public static void main(String[] args) {

            subjectConstraints.put("Microprossesor and embedded system", new int[5]);
            subjectConstraints.put("Conatiner Orchestration", new int[5]);
            subjectConstraints.put("Complier design", new int[5]);
            subjectConstraints.put("Cloud performance tuning", new int[5]);
            subjectConstraints.put("CSF", new int[5]);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Enter User Progress");
            System.out.println("2. Display Overall Progress for a User");
            System.out.println("3. Display Leaderboard (Subject-wise)");
            System.out.println("4. Display Leaderboard (Overall)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    enterUserProgress(subjectConstraints, userProgressMap, scanner);
                    break;
                case 2:
                    displayUserProgress(userProgressMap, subjectConstraints, scanner);
                    break;
                //case 3:
                //  displaySubjectWiseLeaderboard();
                //  break;
                //case 4:
                //   displayOverallLeaderboard();
                //   break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    static void enterUserProgress(Map<String, int[]> subjectConstraints,
                                          Map<String, Map<String, Integer>> userProgressMap, Scanner scanner) {
        System.out.print("Enter the user's name: ");
        String username = scanner.nextLine();

        Map<String, Integer> userProgress = new HashMap<>();
        for (Map.Entry<String, int[]> entry : subjectConstraints.entrySet()) {
            String subject = entry.getKey();
            int[] constraints = entry.getValue();
            
            System.out.println("Enteries for " + subject + " progress ");

            System.out.print("Enter marks of assignment out of 30: ");
            constraints[0]=scanner.nextInt();

            System.out.print("Enter submission time of assignment out of 10: ");
            constraints[1]=scanner.nextInt();

            System.out.print("Enter class test marks out of 30: ");
            constraints[2]=scanner.nextInt();

            System.out.print("Enter quiz scores out of 30: ");
            constraints[3]=scanner.nextInt();

            int progress=0;
            
            for(int i=0;i<4;i++){
                progress += constraints[i];
            }
            
            userProgress.put(subject, progress);
            System.out.println("progress:"+ progress);
        }
        
        userProgressMap.put(username, userProgress);
        System.out.println("User progress for " + username + " has been recorded.");
    }

    static void displayUserProgress(Map<String, Map<String, Integer>> userProgressMap,
                                            Map<String, int[]> subjectConstraints, Scanner scanner) {
        System.out.print("Enter the user's name to display progress: ");
        String username = scanner.nextLine();

        Map<String, Integer> userProgress = userProgressMap.get(username);

        if (userProgress == null) {
            System.out.println("User not found.");
        } else {
            System.out.println("Progress for " + username + ":");
            for (Map.Entry<String, Integer> entry : userProgress.entrySet()) {
                String subject = entry.getKey();
                int progress = entry.getValue();
                System.out.println(subject + ": " + progress + "/100");
            }
        }
    }

}


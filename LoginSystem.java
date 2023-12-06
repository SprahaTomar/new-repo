package myproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginSystem {
    public static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void registerUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            users.put(username, hashedPassword);
            System.out.println("Registration successful!");
            System.out.println("Password: " + password);
            System.out.println("Hashed Password: " + hashedPassword);
        }
    }

    public static void loginUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine(); 
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        String hashedPassword = hashPassword(password);


        if (users.containsKey(username) && users.get(username).equals(hashedPassword)) {
            System.out.println("Login successful!");
            System.out.println("Password: " + password);
            System.out.println("Hashed Password: " + hashedPassword);

            

        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] passwordBytes = password.getBytes();

            messageDigest.update(passwordBytes);

            byte[] hashBytes = messageDigest.digest();

            StringBuilder hashStringBuilder = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hashStringBuilder.append('0');
                }
                hashStringBuilder.append(hex);
            }

            return hashStringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        String user = "", pass = "";
        String[][] users = {
                {"202310370311460", "Tia"},
                {"admin", "admin"}
        };

        while (!exit) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.println("Choose option (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter your NIM: ");
                    user = scanner.next();
                    pass = "Student";
                    break;
                case 2:
                    System.out.print("Enter your username (admin): ");
                    user = scanner.next();
                    System.out.print("Enter your password (admin): ");
                    pass = scanner.next();
                    break;
                case 3:
                    exit = true;
                    System.out.println("adios");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

            if (!exit) {
                boolean found = false;
                for (String[] u : users) {
                    if (u[0].equals(user) && u[1].equals(pass)) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("Successful Login as " + pass);
                } else {
                    System.out.println("User Not Found");
                }
            }
        }

        scanner.close();
    }
}
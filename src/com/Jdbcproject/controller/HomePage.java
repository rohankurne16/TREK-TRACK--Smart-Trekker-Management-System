package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;

public class HomePage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println(" TREKKER MANAGEMENT SYSTEM ");
            System.out.println("1. Register new Trekker");
            System.out.println("2. Alreday Registered?? Login here");
            System.out.println("3. Forgot Password");
            System.out.println("4. Edit Personal Details");
            System.out.println("5. Show your info");
            System.out.println("6. Delete Trekker");
            System.out.println("7. Admin Login");
            System.out.print("Enter your choice: ");
            
            choice = Integer.parseInt(sc.nextLine());

            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Register new Trekker");
                    TrekkerController.main(args);
                    break;

                case 2:
                    System.out.println("Login for already registered trekker");
                    Logincontroller.main(args);
                    break;

                case 3:
                    System.out.println("Forgot Password");
                    ForgotController.main(args);
                    break;

                case 4:
                    System.out.println("Edit personal details");
                    EditController.main(args);
                    break;

                case 5:
                    System.out.println("Show your info");
				try {
					PersonalController.main(args);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;

                case 6:
                    System.out.println("Delete existing trekker");
                    DeleteController.main(args);
                    
                    break;
                    
                case 7:
                    System.out.println("Admin login:");
                    AdminController.main(args);
                    
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

        } while (choice != 6);

        sc.close();
    }
}

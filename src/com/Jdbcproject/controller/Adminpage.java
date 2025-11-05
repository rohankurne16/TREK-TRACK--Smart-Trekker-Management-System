package com.Jdbcproject.controller;

import java.util.Scanner;

public class Adminpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		        Scanner sc = new Scanner(System.in);
		        int choice;

		        do {
		            System.out.println("ADMIN PAGE");
		                     
		            System.out.println("1. Show all trekkers");
		           
		            System.out.println("2. Delete a trekker");
		            
		            System.out.println("3. Export Trekkers Data");
		            
		            System.out.print("Enter your choice: ");
		            
		            choice = sc.nextInt();

		            

		            switch (choice) {

		                case 1:
		                    System.out.println("Show all trekkers");
		                    Showinfo.main(args);
		                    break;

		                case 2:
		                    System.out.println("Delete a trekker");
		                     DeleteController.main(args);
		                    break;
		                
		               
		                    
		                case 3:
		                    System.out.println("Export Report");
		                    ExportController.main(args);
		                    break;


		            }

		        } while (choice != 4);

		            sc.close();
		            System.out.println("Admin logged out successfully");
	}
		        

}

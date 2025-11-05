package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.Jdbcproject.DAO.EditDAO;
import com.Jdbcproject.bean.Trekker;

public class EditController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trekker t = new Trekker();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your registered mail:");
		t.setEmail(sc.nextLine());
		
		System.out.println("enter new name:");
		t.setName(sc.nextLine());
		
		System.out.println("enter new city:");
		t.setCity(sc.nextLine());
		
		System.out.println("enter new address:");
		t.setAddress(sc.nextLine());
		
		System.out.println("enter new contact:");
		t.setContact(sc.nextLine());
		
		System.out.println("enter new adhaar:");
		t.setAdhar(sc.nextLine());
		
		EditDAO e = new EditDAO();
		
		try {
			
			
			boolean st = e.edit(t);
			
			if(st==true) {
				
				System.out.println("Info edited Successfully");
				
			}
			else {
				
				System.out.println("please try again..");
				
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}

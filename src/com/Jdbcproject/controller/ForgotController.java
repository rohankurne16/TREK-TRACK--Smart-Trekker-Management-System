package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.Jdbcproject.DAO.ForgotDAO;
import com.Jdbcproject.bean.Trekker;

public class ForgotController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trekker t = new Trekker();
		
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("enter registered mail:");
		t.setEmail(sc.nextLine());
		
		System.out.println("enter new pass:");
		t.setPass(sc.nextLine());
		
		ForgotDAO f = new ForgotDAO();
		try {
			boolean st = f.forgot(t);
			
			if(st == true) {
				
				System.out.println("pass updated successfully...");
			}
			
			else {
				
				System.out.println("mail not registered");
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.Jdbcproject.DAO.AdminloginDAO;
import com.Jdbcproject.bean.Trekker;

public class AdminController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trekker t = new Trekker();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your email:");
		t.setEmail(sc.nextLine());
		
		System.out.println("enter your pass:");
		t.setPass(sc.nextLine());
		
		AdminloginDAO ad = new AdminloginDAO();
		try {
			boolean st = ad.login(t);
			
			if(st==true) {
				
				Adminpage.main(args);
				
			}
			else{
				
				System.out.println("invalid login credentials..please check your credentials");
				
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

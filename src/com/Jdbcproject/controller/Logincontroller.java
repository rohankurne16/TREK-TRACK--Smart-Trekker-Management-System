package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.Jdbcproject.DAO.LoginDAO;
import com.Jdbcproject.bean.Trekker;



public class Logincontroller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trekker t = new Trekker();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter your registered mail:");
		
		t.setEmail(sc.nextLine());
		
		System.out.println("enter your pass:");
		
		t.setPass(sc.nextLine());
		
		LoginDAO ld = new LoginDAO();
		
		try {
			String name = ld.login(t);
			
			if(name != null ) {
				
				System.out.println("login successfull...." );
				System.out.println("Hello "+ name);
				
				
				
			}
			
			else{
				
				System.out.println("Invalid Login credentials do the Registration ");
				
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

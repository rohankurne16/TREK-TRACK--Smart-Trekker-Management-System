package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.Jdbcproject.DAO.DeleteDAO;
import com.Jdbcproject.bean.Trekker;

public class DeleteController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trekker  t =new Trekker();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter your email:");
		t.setEmail(sc.nextLine());
		
		
		
		DeleteDAO d = new DeleteDAO();
		
		
		try {
			
			
			
			boolean st = d.delete(t);
			
			if(st==true) {
				
				System.out.println("User deleted successfully...");
				
			}
			else{
				
				System.out.println("please delete again..");
				
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

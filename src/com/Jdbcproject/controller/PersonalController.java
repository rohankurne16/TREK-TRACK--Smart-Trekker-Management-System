package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;


import com.Jdbcproject.DAO.PersonalInfo;
import com.Jdbcproject.bean.Trekker;

public class PersonalController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Trekker t = new Trekker();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter your registered mail:");
		t.setEmail(sc.nextLine());
		
		PersonalInfo pi = new PersonalInfo();
		
	 pi.info(t);
			
		
		
		

	}

}

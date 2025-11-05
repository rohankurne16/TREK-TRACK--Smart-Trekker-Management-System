package com.Jdbcproject.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.Jdbcproject.DAO.ExportDAO;

public class ExportController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExportDAO e = new ExportDAO();
		try {
			boolean st = e.export();
			
			if(st==true) {
				
				System.out.println("data exported successfully...");
				
			}
			else {
				
				System.out.println("can't export data try again..");
				
			}
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}

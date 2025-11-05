package com.Jdbcproject.controller;


import java.sql.SQLException;

import com.Jdbcproject.DAO.ShowinfoDAO;
import com.Jdbcproject.bean.Trekker;

public class Showinfo {

	public static void main(String[] args) {
		
		Trekker t = new Trekker();
		// TODO Auto-generated method stub
		
		ShowinfoDAO sd = new ShowinfoDAO();
		
		try {
			sd.show();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

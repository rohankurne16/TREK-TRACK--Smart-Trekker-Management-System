package com.Jdbcproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ShowinfoDAO {
	
	public void show() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1","root","root");
		
		java.sql.Statement stmt = con.createStatement();
		
		ResultSet rs =  stmt.executeQuery("select * from trekker");
		
		
		
		while(rs.next()) {
			
			System.out.println("ID:"+rs.getInt(1)+" \t NAME:"+rs.getString(2)+" \t CITY:"+rs.getString(3)+" \t ADDRESS:"+rs.getString(4)+"\t AADHAR:"+rs.getString(5)+"\t CONTACT:"+rs.getString(6)+" \t EMAIL:"+rs.getString(7));
			
		}
		
		
	}

}

package com.Jdbcproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Jdbcproject.bean.Trekker;

public class PersonalInfo {

	
	public void info(Trekker t) throws ClassNotFoundException, SQLException {
		
		

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1","root","root");
		
		PreparedStatement ps=con.prepareStatement("Select * from trekker where email=?");
		
		ps.setString(1, t.getEmail());
	
		
		ResultSet re = ps.executeQuery();
		
		while(re.next()) {
			
			System.out.println("Your Details:");
            System.out.println("Name          : " + re.getString(2));
            System.out.println("Email         : " + re.getString(3));
            System.out.println("Password      : " + re.getString(4));
            System.out.println("Contact No.   : " + re.getLong(5));  
            System.out.println("Aadhar No.    : " + re.getLong(6));  
            System.out.println("Address       : " + re.getString(7));
		}
		
	}
	
}

package com.Jdbcproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Jdbcproject.bean.Trekker;

public class EditDAO {
	
	public boolean edit(Trekker t) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1","root","root");
		
		
		PreparedStatement ep = con.prepareStatement("update trekker set name=?, city=?, address=?,adhar=?, contact=? where email = ?");
		
		ep.setString(1, t.getName());
		ep.setString(2, t.getCity());
		ep.setString(3, t.getAddress());
		ep.setString(4, t.getContact());
		ep.setString(5, t.getAdhar());
		ep.setString(6, t.getEmail());
		
		
		int re = ep.executeUpdate();
		
		if(re>0) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
	}
	

}

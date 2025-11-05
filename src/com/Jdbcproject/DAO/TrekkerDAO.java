package com.Jdbcproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Jdbcproject.bean.Trekker;

public class TrekkerDAO {
	
	
	public boolean insert(Trekker t) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1","root","root");
		
	
		
		PreparedStatement ps = con.prepareStatement("insert into trekker values(?,?,?,?,?,?,?,?)");
		
		
		ps.setInt(1, t.getId());
		ps.setString(2, t.getName());
		ps.setString(3, t.getCity());
		ps.setString(4, t.getAddress());
		ps.setString(5, t.getAdhar());
		ps.setString(6, t.getContact());
		ps.setString(7, t.getEmail());
		ps.setString(8, t.getPass());
		
		
		
		
		int rs = ps.executeUpdate();
		
		if(rs>0) {
			
			return true;
			
		}
		else {
			
			return false;
			
		}
		
		
	}
	

}

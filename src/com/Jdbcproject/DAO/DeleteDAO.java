package com.Jdbcproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Jdbcproject.bean.Trekker;

public class DeleteDAO {

	public boolean delete(Trekker t) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1","root","root");
		
		PreparedStatement ps=con.prepareStatement("delete from trekker where email=?");
		
		ps.setString(1, t.getEmail());
		
		
		int re = ps.executeUpdate();
		
		if(re>0) {
			
			return true;
			
		}
		else{
			
			return false;
			
		}
	}

	
}

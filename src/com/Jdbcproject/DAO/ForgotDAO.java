package com.Jdbcproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Jdbcproject.bean.Trekker;

public class ForgotDAO {

	public boolean forgot(Trekker t) throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1","root","root");
			
			PreparedStatement ps = con.prepareStatement("select * from trekker where email = ?");
			ps.setString(1, t.getEmail());
	        ResultSet rs = ps.executeQuery();

	        if (!rs.next()) {
	            
	            return false;
	        }
	        
	        
	        PreparedStatement updateps = con.prepareStatement("update trekker set pass = ? where email = ?");
	        updateps.setString(1, t.getPass());
	        updateps.setString(2, t.getEmail());

	        int re = updateps.executeUpdate();

	       

	        return re > 0;  
			
		}
	
}


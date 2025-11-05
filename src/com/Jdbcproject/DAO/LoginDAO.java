package com.Jdbcproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Jdbcproject.bean.Trekker;

public class LoginDAO {

	public String login(Trekker t) throws ClassNotFoundException, SQLException {
		

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC1","root","root");
		
		PreparedStatement ps=con.prepareStatement("Select * from trekker where email = ? and pass =?");
		
		ps.setString(1, t.getEmail());
		ps.setString(2, t.getPass());
		
		ResultSet re = ps.executeQuery();
		
		if(re.next()) {
			
			
			return re.getString("name");
			
				
		}
		
		else{
			
			return null;
			
		}
		
		
		
	}
}

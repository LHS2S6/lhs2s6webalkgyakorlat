package crud;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

public class DbMethods {
	
	public Statement s=null;
	public Connection conn=null;
	
	
	
	
	
	public void Connect() {
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cats","lhs2s6","lhs2s6");
			SM("Connection OK!");
		} catch (SQLException e) {
			SM("JDBC Connect: "+e.getMessage());
			}
		
	}
	
	
	public void DisConnect() {
		try {
			conn.close();
			SM("DisConnection OK!");
		} catch (SQLException e) {
			SM(e.getMessage());
		}
		
	}
	public void SM(String msg) {
		System.out.println(msg);
	}

}

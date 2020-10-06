package crud;

import java.sql.*;

public class Select {

	public static DbMethods db = new DbMethods();
	
	public static void main(String[] args) {
		
		
		
		db.Connect();
		System.out.println("Elso statement:");
		Statement1();
		System.out.println("Masodik statement:");
		Statement2();
		db.DisConnect();

	}
	
	
	public static void Statement1() {
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		try {
			String sqlp = "Select * from cats where age>?";
			ps=db.conn.prepareStatement(sqlp);
			ps.setInt(1, 1);
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				
			}
		} catch (SQLException e) {
			db.SM("Hibas lekerdezes!"+e.getMessage());
		}
	}
	
public static void Statement2() {
	ResultSet rs=null;
	PreparedStatement ps=null;
		
		try {
			String sqlp = "Select * from cats where age>?";
			ps=db.conn.prepareStatement(sqlp);
			ps.setInt(1, 5);
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
		} catch (SQLException e) {
			db.SM("Hibas lekerdezes!"+e.getMessage());
		}
	}
	
	
	
	

}

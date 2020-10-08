package crud;

import java.sql.*;

public class Update {
	
	public static DbMethods db = new DbMethods();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		db.Connect();
		System.out.println("Update:");
		UpdateMethod();
		db.DisConnect();
	}
	
	public static void UpdateMethod() {
		Statement s=null;
		try {
		String sqlp="Update cats set owner='Piros Ferenc' where breed='sziami'";
		s=db.conn.createStatement();
		s.executeUpdate(sqlp);
		System.out.println("Update OK!");
		} catch (SQLException e) {
			db.SM("Update hiba: "+e.getMessage());
			}
	}
	
	
	
}

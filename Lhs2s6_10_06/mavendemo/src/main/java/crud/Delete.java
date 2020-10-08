package crud;

import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static DbMethods db = new DbMethods();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		db.Connect();
		System.out.println("Update:");
		UpdateMethod();
		db.DisConnect();
	}
	
	public static void UpdateMethod() {
		System.out.println("Update:");
		Statement s=null;
		try {
		String sqlp="Delete from cats where name='Perzsa' and owner='Gal Dora'";
		s=db.conn.createStatement();
		s.executeUpdate(sqlp);
		System.out.println("Update OK!");
		} catch (SQLException e) {
			db.SM("Update hiba: "+e.getMessage());
			}
	}

}

package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static DbMethods db = new DbMethods();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		db.Connect();
		System.out.println("Update:");
		UpdateMethod();
		Query();
		db.DisConnect();
	}
	
	public static void UpdateMethod() {
		System.out.println("Update:");
		Statement s=null;
		try {
		String sqlp="Delete from cats where breed='Perzsa' and owner='Gal Dora'";
		s=db.conn.createStatement();
		s.executeUpdate(sqlp);
		System.out.println("Update OK!");
		} catch (SQLException e) {
			db.SM("Update hiba: "+e.getMessage());
			}
	}
	
	public static void Query() {
		Statement s=null;
		ResultSet rs=null;
		try {
			String sqlp = "Select * from cats";
			s=db.conn.createStatement();
			rs=s.executeQuery(sqlp);
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
				
			}
		} catch (SQLException e) {
			db.SM("Hibas lekerdezes!"+e.getMessage());
		}
	}

}

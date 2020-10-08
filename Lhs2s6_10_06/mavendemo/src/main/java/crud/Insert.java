package crud;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	
	public static DbMethods db = new DbMethods();

	public static void main(String[] args) {
		
		db.Connect();
		System.out.println("Insert:");
		Insertmethod();
		System.out.println("Lekerdezes:");
		Query();
		db.DisConnect();

	}
	
	
	public static void Insertmethod() {
		Statement s=null;
		try {
			String sqlp = "Insert into cats values(7,'Macsek3','Perzsa',4,'Localhost')";
			s=db.conn.createStatement();
			s.executeUpdate(sqlp);
			System.out.println("Insert OK!");
		} catch (SQLException e) {
			db.SM("Hibas Insert!"+e.getMessage());
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

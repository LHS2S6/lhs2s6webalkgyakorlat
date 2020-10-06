package storedProcedure;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud.DbMethods;
public class InResultSet {
	
	public static DbMethods db = new DbMethods();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		db.Connect();
		System.out.println("Stored Procedure 1:");
		Procedure();
		db.DisConnect();
	}
	
	public static void Procedure() {
		try {
			CallableStatement cs=db.conn.prepareCall("{call storedProcedure(?)}");
			cs.setString(1, "Mekk Elek");
			ResultSet rs=cs.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));	
			}
			
		} catch (SQLException e) {
			db.SM("Hibas lekerdezes!"+e.getMessage());
	}

}
}

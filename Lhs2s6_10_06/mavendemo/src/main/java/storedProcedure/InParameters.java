package storedProcedure;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crud.DbMethods;

public class InParameters {

	public static DbMethods db = new DbMethods();
	
	public static void main(String[] args) {
		
		db.Connect();
		System.out.println("Two in parameters with stored procedure:");
		twoin();
		db.DisConnect();

	}
	
	
	public static void twoin() {
		try {
			CallableStatement cs=db.conn.prepareCall("{call twoinparams(?,?)}");
			cs.setString(1, "Gal Dora");
			cs.setString(2, "Perzsa");
			cs.execute();
			System.out.println("Update OK!");
		} catch (SQLException e) {
			db.SM("Hibas Update!"+e.getMessage());
	}
		
		
	}
	

}

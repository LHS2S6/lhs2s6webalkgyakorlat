package storedProcedure;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import crud.DbMethods;

public class OutParameter {

	public static DbMethods db = new DbMethods();
	
	public static void main(String[] args) {
		
		db.Connect();
		System.out.println("Out parameter with stored procedure:");
		out();
		db.DisConnect();

	}

	public static void out() {
		try {
			CallableStatement cs=db.conn.prepareCall("{call inoutparams(?,?)}");
			cs.setString(1, "Perzsa");
			cs.registerOutParameter(2, Types.INTEGER);
			cs.execute();
			int x=cs.getInt(2);
			cs.close();
			System.out.println("Breed count: "+x);
		} catch (SQLException e) {
			db.SM("Hibas Lekerdezes!"+e.getMessage());
	}
	}
}

package cons;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testDB {
	public static void main(String[] args) {
		ConnMysql test1 = new ConnMysql();
		test1.OpenMysql();
		ResultSet res1= test1.select("select * from user_account");
		try {
			while(res1.next()) {
				System.out.print(res1.getString(1) + "    ");
				System.out.println(res1.getString(2));
			}
			test1.closeMysql();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

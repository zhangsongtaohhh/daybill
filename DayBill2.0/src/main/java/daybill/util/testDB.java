package daybill.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class testDB {
	public static void main(String[] args) {
		ConnMysql test1 = new ConnMysql();
		test1.OpenMysql();
		String sql = null;
		float dress=600;
		float food=700;
		float live=800;
		float transportation=900;
		float study=1000;
		float sum=4000;
		for(int i = 1; i <= 15; i++) {
			sql = "insert into zhangsan_tb values("
					+ dress + "," + food + "," + live + "," + transportation + "," + study + "," + sum + ",'2021-06-" + i + "','" + "zhangsan');";
//			System.out.println(sql);
			test1.update(sql);
			dress++;
			food++;
			live++;
			transportation++;
			study++;
			sum += 5 * i;
		}
		test1.closeMysql();
	}
}
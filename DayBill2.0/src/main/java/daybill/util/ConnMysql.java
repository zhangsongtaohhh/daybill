package daybill.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnMysql {
	Connection con = null;
	Statement sta = null;
	ResultSet res = null;
	  
	//打开数据库连接
	public Connection OpenMysql() {
		try {
			final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			final String DB_URL = "jdbc:mysql://localhost:3306/daybill?characterEncoding=UTF-8";
			//数据库用户名、密码
			final String user = "root";
			final String password = "2333";
			
			//加载驱动
			Class.forName(JDBC_DRIVER);
			//连接数据库
			con = DriverManager.getConnection(DB_URL, user, password);
			
		} catch (Exception e) {
		}  
		return con;
	}
	
	//增删改
	public int update(String sql) {
		int re = 0;
		//创建执行对象
		try {
			sta = con.createStatement();
			re = sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	
	//查询
	public ResultSet select(String sql) {
		//创建执行对象
		try {
			sta = con.createStatement();
			res = sta.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//关闭数据库连接
	public void closeMysql() {
		try {
//			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
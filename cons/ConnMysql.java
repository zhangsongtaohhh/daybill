package cons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnMysql {
	Connection con = null;
	Statement sta = null;
	ResultSet res = null;
	  
	//�����ݿ�����
	public Connection OpenMysql() {
		try {
//			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			final String DB_URL = "jdbc:mysql://localhost:3306/daybill_db?characterEncoding=UTF-8";
			//���ݿ��û���������
			final String user = "root";
			final String password = "2333";
			
			//��������
//			Class.forName(JDBC_DRIVER);
			//�������ݿ�
			con = DriverManager.getConnection(DB_URL, user, password);
			
		} catch (Exception e) {
			// TODO: handle exception
		}  
		return con;
	}
	
	//��ɾ��
	public int update(String sql) {
		int re = 0;
		//����ִ�ж���
		try {
			sta = con.createStatement();
			re = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}
	
	//��ѯ
	public ResultSet select(String sql) {
		//����ִ�ж���
		try {
			sta = con.createStatement();
			res = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
	
	//�ر����ݿ�����
	public void closeMysql() {
		try {
			res.close();
			sta.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

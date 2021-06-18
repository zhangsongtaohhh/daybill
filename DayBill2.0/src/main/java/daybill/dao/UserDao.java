package daybill.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import daybill.entity.Bills;
import daybill.entity.Users;
import daybill.util.ConnMysql;

public class UserDao {
	private ConnMysql conMysql = new ConnMysql();
	//用户注册
	public int add(Users user) {
		int result = 0;
		conMysql.OpenMysql();
		result = conMysql.update("insert into user_table values"
				+ "('" + user.getUserName() + "', '" + user.getPassword() + "', '" + user.getSex() + "', '" + user.getEmail() + "');");
		conMysql.closeMysql();
		return result;
	}
	
	//用户登录
	public int login(Users user) {
		ResultSet result = null;
		conMysql.OpenMysql();
		int loginValue = 0;
		result = conMysql.select("select user_password from user_table where user_name='" + user.getUserName() + "';");
		try {
			while(result.next()){
				if(result.getString(1) == null) {
					loginValue = 0;
				}else {
//	                System.out.println(result.getString(1));
	                if(user.getPassword().equals(result.getString(1))) {
	                	loginValue = 1;
	                }else {
	                	loginValue = 2;
	                }
	            }
	        }
	     } catch (SQLException throwables) {
	            throwables.printStackTrace();
	      }
		conMysql.closeMysql();
		return loginValue;
	}
	
	//用户注册
	public int register(Users user) {
		ResultSet result;
		conMysql.OpenMysql();
		int registerValue = 0;
		result = conMysql.select("select user_name from user_table where username = '" + user.getUserName() + "';");
		if(result == null) {
			conMysql.update("insert into user_table(user_name, user_password) "
					+ "values('" + user.getUserName() + "','" + user.getPassword() + "');");
			registerValue = 1;
		}else {
			registerValue = 0;
		}
		conMysql.closeMysql();
		return registerValue;
	}
	
	//新增账单
	public int addBill(Bills bill) {
		int result;
		conMysql.OpenMysql();
		result = conMysql.update("insert into zhangsan_tb values(" + bill.getDress() + "," + bill.getFood() +
				"," + bill.getLive() + "," + bill.getTransportation() + "," + bill.getStudy() + "," + 
				bill.getSum() + ",'" + bill.getDate() + "','zhangsan'" + ");");
		return result;
	}
	
	//查看账单
	public List<Bills> checkBill() {
		conMysql.OpenMysql();
		List<Bills> billList = new ArrayList<Bills>();
		ResultSet res = conMysql.select("select * from zhangsan_tb;");
		
		try {
			while(res.next()) {
				float dress = res.getFloat(1);
				float food = res.getFloat(2);
				float live = res.getFloat(3);
				float transportation = res.getFloat(4);
				float study = res.getFloat(5);
				float sum = res.getFloat(6);
				String date = res.getDate(7).toString();
				int no = res.getInt(9);
				Bills bill = new Bills(dress, food, live, transportation, study, sum, date, no);
				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}
	
	//删除记录
	public void delete(int no) {
		conMysql.OpenMysql();
		conMysql.update("delete from zhangsan_tb where no=" + no);
		
	}
}

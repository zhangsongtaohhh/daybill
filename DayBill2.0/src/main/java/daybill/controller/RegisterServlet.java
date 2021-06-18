package daybill.controller;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daybill.dao.UserDao;
import daybill.entity.Users;
import daybill.util.ConnMysql;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet{


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username,password;
		Users user = null;
		UserDao dao = new UserDao();
		int registerValue;
        username = request.getParameter("username");
        password = request.getParameter("password");/*获取网页输入的用户名和密码*/
        user = new Users(username, password);
        registerValue = dao.register(user);
        if(registerValue == 1){
            request.setAttribute("yes","注册成功！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }else{
            request.setAttribute("no","用户名已存在 请重新输入用户名！");
        }
    }
}
package daybill.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daybill.dao.UserDao;
import daybill.entity.Users;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username,password;
		Users user = null;
		UserDao dao = new UserDao();
		int loginValue;
		username = request.getParameter("username");
        password = request.getParameter("password");
//        System.out.println("username:" + username);
//        System.out.println("password:" + password);
        user = new Users(username, password);
        loginValue = dao.login(user);
        if(loginValue == 0){
        	request.setAttribute("no","用户不存在 请注册！！");
            try {
            	request.getRequestDispatcher("/login.jsp").forward(request,response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else if(loginValue == 1) {
            try {
            	Cookie nameCookie = new Cookie("name", URLEncoder.encode(username, "utf-8"));
                // 新建名为password的Cookie
                Cookie passwordCookie = new Cookie("password", password);

                // 设置Cookie的使用路径
                nameCookie.setPath(request.getContextPath() + "/");
                passwordCookie.setPath(request.getContextPath() + "/");
                String checkbox1 = request.getParameter("checkbox1");
                System.out.println(checkbox1);// 判断是否保存cookie
                if (checkbox1!=null&&checkbox1.equals("checkbox")) {
                    // 设置保存Cookie的时间长度，单位为秒 设置为7天
                    nameCookie.setMaxAge(7 * 24 * 60 * 60);
                    passwordCookie.setMaxAge(7 * 24 * 60 * 60);
                } else if(checkbox1==null){
                    // 设置将不保存Cookie
                    nameCookie.setMaxAge(0);
                    passwordCookie.setMaxAge(0);
                }
                // 传到前端
                response.addCookie(nameCookie);
                response.addCookie(passwordCookie);
            	request.getRequestDispatcher("/home.html").forward(request,response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }else {
        	request.setAttribute("error","密码错误 请重新输入！");
        	request.setAttribute("username",username);
            try {
            	request.getRequestDispatcher("/login.jsp").forward(request,response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}

}

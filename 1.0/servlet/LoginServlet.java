package servlet;
import cons.ConnMysql;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");/*获取网页输入的用户名和密码*/
        System.out.println("name:"+ username);
        System.out.println("password:"+ password);
        ConnMysql con=new ConnMysql(); /*创建连接数据库*/
        con.OpenMysql();
        String upass="";
        /*获取数据库密码信息*/
        ResultSet res=con.select("select password from account where username='"+username+"'");
        while(true)
        {
            try {
                if (!res.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
//                将获取到的密码传给upass
                upass=res.getString("password");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        //--------------------------
        if(upass.equals("")||upass.equals(null))
        {
            req.setAttribute("no","用户不存在 请注册！！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }else if(upass.equals(password))
        {

            Cookie nameCookie = new Cookie("name", URLEncoder.encode(username, "utf-8"));
            // 新建名为password的Cookie
            Cookie passwordCookie = new Cookie("password", password);

            // 设置Cookie的使用路径
            nameCookie.setPath(req.getContextPath() + "/");
            passwordCookie.setPath(req.getContextPath() + "/");
            String checkbox1 = req.getParameter("checkbox1");
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
            resp.addCookie(nameCookie);
            resp.addCookie(passwordCookie);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else
        {
            req.setAttribute("error","密码错误 请重新输入！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}

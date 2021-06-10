package servlet;
import cons.ConnMysql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

            req.setAttribute("username",username);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);

        }else
        {
            req.setAttribute("error","密码错误 请重新输入！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }


    }
}

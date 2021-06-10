package servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("name:"+ username);
        System.out.println("password:"+ password);
        //根据用户名查询数据库 没有结果 说明用户不存在
        //如果查询到 再对比密码
        if("admin".equals(username)&&"123456789".equals(password)){
            req.setAttribute("username",username);
            req.getRequestDispatcher("/mainpage.html").forward(req,resp);
        }else{
            req.setAttribute("error","密码错误 请重新输入！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}

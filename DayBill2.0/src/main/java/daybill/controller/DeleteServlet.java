package daybill.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daybill.dao.UserDao;
import daybill.entity.Bills;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		int no;
		no = Integer.parseInt(request.getParameter("no"));
		dao.delete(no);
		PrintWriter out;
		List<Bills> billList = dao.checkBill();
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		out.print(" <link rel=\"stylesheet\" type=\"text/css\" href=\"mainpage.css\"/>"
				+ "    <span class=\"top\">天天记账</span>\r\n"
				+ "	<span class=\"left\">\r\n"
				+ "        <ul>\r\n"
				+ "            <br>\r\n"
				+ "            <li>\r\n"
				+ "            	<a href=\"./addBill.html\">新增账单</a>\r\n"
				+ "            </li><br>\r\n"
				+ "            <li>\r\n"
				+ "            	<a href=\"./checkBill.html\">查看账单</a>\r\n"
				+ "            </li><br>\r\n"
				+ "            <li>\r\n"
				+ "            	<a href=\"./manageBill.html\">管理帐单</a>\r\n"
				+ "            	<ul>\r\n"
				+ "            		<br><li><a href=\"delete\">删除账单</a></li>\r\n"
				+ "            	</ul>\r\n"
				+ "            </li><br>\r\n"
				+ "            <li>\r\n"
				+ "            	<a href=\"./userInfo.html\">个人信息</a>\r\n"
				+ "            </li>\r\n"
				+ "        </ul>\r\n"
				+ "    </span>\r\n"
				+ "    <span class=\"right\" style=\"height:95%;overflow-y:auto\">");
		out.print("<table class=\"tab\" align='center' width=70% bgcolor=aliceblue > ");
		out.print("<tr align=\"center\">");
		out.print("<td>日期</td>");
		out.print("<td>序号</td>");
		out.print("<td>衣</td>");
		out.print("<td>食</td>");
		out.print("<td>住</td>");
		out.print("<td>行</td>");
		out.print("<td>学习</td>");
		out.print("<td>合计</td>");
		out.print("<td>操作</td>");
		out.print("</tr>");
		for (Bills bill: billList) {
			out.print("<tr align=\"center\">");
			out.print("<td>" + bill.getDate() + "</td>");
			out.print("<td>" + bill.getNo() + "</td>");
			out.print("<td>" + bill.getDress() + "</td>");
			out.print("<td>" + bill.getFood() + "</td>");
			out.print("<td>" + bill.getLive() + "</td>");
			out.print("<td>" + bill.getTransportation() + "</td>");
			out.print("<td>" + bill.getStudy() + "</td>");
			out.print("<td>" + bill.getSum() + "</td>");
			out.print("<td>" + "<a text-decoration=none href=\"delete?no="+ bill.getNo() + "\">删除记录</a>" + "</td>");
			out.print("</tr>");
		}
		out.print("</tabel>\n</span>");
		
	}
}

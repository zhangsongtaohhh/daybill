package daybill.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daybill.dao.UserDao;
import daybill.entity.Bills;
import daybill.entity.Users;

/**
 * Servlet implementation class AddBillServlet
 */
public class AddBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBillServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float dress, live,food, transportation, sum, study;
		String date;
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		date = dateFormat.format(now); 
		UserDao dao = new UserDao();
		Bills bill = null;
		int result = 0;
		PrintWriter out = null;
		//【调用请求对象】读取【请求头】参数信息，得到用户输入信息
		dress = Float.parseFloat(request.getParameter("dress"));
		live = Float.parseFloat(request.getParameter("live"));
		food = Float.parseFloat(request.getParameter("food"));
		transportation = Float.parseFloat(request.getParameter("transportation"));
		study = Float.parseFloat(request.getParameter("study"));
		sum = dress + live + food + transportation + study;
		bill = new Bills(dress, food, live, transportation, study, sum, date);
		result = dao.addBill(bill);
		if(result == 1) {
			
		}
	}
}

package employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/servlet/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		EmployeeDao ed = new EmployeeDao();
		List<Employee> eList = new ArrayList<Employee>();
		eList = ed.getEmployee();
		request.setAttribute("elist", eList);
		// (6)ServletからJSPを呼び出します。JSPを呼び出す際はrequestスコ
		// ープのデータを引き継ぐ必要からforwardメソッドを使用します。
		RequestDispatcher rd = request.getRequestDispatcher("../DisplayEmployee.jsp");
		rd.forward(request, response);
	}

}

package manages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manages.jdbc.Manager;
import manages.jdbc.ManagerDaoImp;

public class Saveservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Saveservlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("change");
		String change = request.getParameter("change");
		String name = request.getParameter("name"+change);
		String identity = request.getParameter("identity"+change);
		String phone = request.getParameter("phone"+change);
		String password = request.getParameter("password"+change);
		ManagerDaoImp dao = new ManagerDaoImp();
		PrintWriter ps = response.getWriter();

		try {
			Manager user = new Manager();
		
			user.setId(id);
			user.setName(name);
			user.setIdentity(identity);
			user.setPhone(phone);
			user.setPassword(password);
			dao.ChangeManager(user);
		response.sendRedirect("wait.html");
			
		} catch (Exception e) {
			e.printStackTrace();
			ps.write("<a href='login.html'>出现未知错误，请返回登陆界面</a>");
			ps.flush();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package manages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manages.jdbc.Manager;
import manages.jdbc.ManagerDaoImp;
public class Createservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Createservlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("newname");
		String identity = request.getParameter("newidentity");
		String phone = request.getParameter("newphone");
		String password = request.getParameter("newpassword");
		ManagerDaoImp dao = new ManagerDaoImp();
		PrintWriter ps = response.getWriter();

		try {
			Manager user = new Manager();
		
			user.setName(name);
			user.setIdentity(identity);
			user.setPhone(phone);
			user.setPassword(password);
			System.out.println(user.toString());
			dao.SavaManager(user);
	    	response.sendRedirect("wait.html");
			
		} catch (Exception e) {
			e.printStackTrace();
			ps.write("<a href='login.html'>出现未知错误，请返回登陆界面</a>");
			ps.flush();
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPut(request, response);
	}

}

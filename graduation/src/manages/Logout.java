package manages;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.logs.Logmonth;
import equipment.logs.Logsave;

public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		Logsave save=null;
		Logmonth month =null;
		PrintWriter ps = response.getWriter();
		try {
			save = new Logsave();
			month= new Logmonth();
			Date b = new Date();
			 SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			  String c = format.format(b);
	        save.save("管理员:"+(String)session.getAttribute("name")+">>>"+"注销,注销时间："+c);
	         save.close();
	         month.save("管理员:"+(String)session.getAttribute("name")+">>>"+"注销,注销时间："+c);
	         month.close();
		} catch (Exception e) {
			ps.write("<a href='login.html'>出现未知错误，请返回登陆界面</a>");
			ps.flush();
		}
		
		session.invalidate();
		response.sendRedirect("login.html");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

}

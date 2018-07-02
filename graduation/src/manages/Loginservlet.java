package manages;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manages.jdbc.Manager;
import manages.jdbc.ManagerDaoImp;
import equipment.logs.Logmonth;
import equipment.logs.Logsave;

public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Loginservlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		ManagerDaoImp dao = new ManagerDaoImp();
		PrintWriter ps = response.getWriter();
       
		try {
			Manager user = dao.find(name);
			String name1 = user.getName();
			String password1 = user.getPassword();
			if (name1 == null) {
				response.sendRedirect("error.html");
			} else if (name1.equals(name)) {
				if (password1.equals(password)) {
					HttpSession session = request.getSession();
					session.setAttribute("name", user.getName());
					session.setAttribute("identity", user.getIdentity());
					session.setAttribute("phone", user.getPhone());
					session.setAttribute("password", user.getPassword());
					session.setMaxInactiveInterval(60 * 30);
					ServletContext con = session.getServletContext();
				
					//登陆日志
					Logsave save= new Logsave();
					Date b = new Date();
					
					SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					 String c = format.format(b);
	           	save.save("管理员:"+(String)session.getAttribute("name")+">>>"+"上线，上线时间："+c);
		            
		       	 
					 //月日志
		            Logmonth month = new Logmonth();
					SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
					String d = format1.format(b);
					String time= (String)con.getAttribute("time");
					if(time==null||(!time.equals(d))){
						con.setAttribute("time", d);
						month.savetime();
					}
					month.save("管理员:"+(String)session.getAttribute("name")+">>>"+"上线，上线时间："+c);
					
		            
		            //判断管理员
					if (name.equals("xmh") && identity.equalsIgnoreCase("manage_max") ){
						save.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进入权限管理，上线时间："+c);
						month.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进入权限管理，上线时间："+c);
						response.sendRedirect("manages_max.jsp");
					} else {
						response.sendRedirect("manages.jsp");
					}
				     save.close();
				     month.close();
				     }
				else {
					ps.write("<a href='login.html'>账户密码错误，点击返回登陆界面</a>");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			ps.write("<a href='login.html'>服务器出现未知错误，请返回登陆界面</a>");
			ps.flush();
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

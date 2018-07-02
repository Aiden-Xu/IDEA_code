package equipment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import equipment.jdbc.Equipment;
import equipment.jdbc.EquipmentDaoImp;
import equipment.logs.Logsave;
public class Addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Addservlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	
	
	String newname = request.getParameter("newname");
	String newstatus = request.getParameter("newstatus");
	HttpSession session = request.getSession();
	EquipmentDaoImp dao = new EquipmentDaoImp();
	PrintWriter ps = response.getWriter();
	
	//add
	try {
		
		Equipment user = new Equipment();
		user.setName(newname);
		user.setStatus(newstatus);
		user.setLoanstudent((String)session.getAttribute("name"));
		user.setInout("0");
		Logsave save= new Logsave();
		save.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进行添加设备操作,增加设备："+newname);
		save.close();
		dao.SaveEquipment(user);
	response.sendRedirect("wait1.html");
		
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

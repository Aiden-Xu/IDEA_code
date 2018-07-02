package equipment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import equipment.jdbc.Equipment;
import equipment.jdbc.EquipmentDaoImp;
import equipment.logs.Logmonth;
import equipment.logs.Logsave;



public class ChangeAddservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeAddservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id =request.getParameter("change").substring(6);
		String change = request.getParameter("change").substring(0,6);
		String name = request.getParameter("name"+id);
		String Loantime = request.getParameter("Loantime"+id);
		String Returntime = request.getParameter("Returntime"+id);
		String Status = request.getParameter("select"+id);
		String Loanclass = request.getParameter("Loanclass"+id);
		String Loanstudentid = request.getParameter("Loanstudentid"+id);
		String Loanstudent = request.getParameter("Loanstudent"+id);
		String inout = request.getParameter("inout"+id);
		
		EquipmentDaoImp dao = new EquipmentDaoImp();
		Equipment ins=null;
			
			try {
				 ins = dao.findbyid(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		PrintWriter ps = response.getWriter();
		//change
		try {
			Equipment user = new Equipment();
			user.setId(id);
			user.setName(name);
			user.setInout(inout);
			user.setLoanclass(Loanclass);
			user.setLoanstudent(Loanstudent);
			user.setLoanstudentid(Loanstudentid);
			//日志
			HttpSession session = request.getSession();
			Logsave save= new Logsave();
            Logmonth month = new Logmonth();
		
			if(!Loantime.equals("null")){
				user.setLoantime(Loantime);
			}
			if(!Returntime.equals("null")){
				user.setReturntime(Returntime);
			}
			if(Status.equals("完好")){
				user.setStatus("1");
			}else if(Status.equals("良好")){
				user.setStatus("2");
			}else{
				user.setStatus("3");
			}
			if(change.equals("change") ){
				if(Loantime.equals("null") || Loantime.equals("") ) {
					
					dao.ChangeManager_noloan(user);
				}else if (Returntime.equals("null")||Returntime.equals("")){
					dao.ChangeManager_noreturn(user);
				}
				save.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备修改操作,设备ID："+id+">>>"+"将原数据："+ins.toString()
						+">>>"+"修改为："+user.toString());
				month.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备修改操作,设备ID："+id+">>>"+"将原数据："+ins.toString()
						+">>>"+"修改为："+user.toString());
				
			}else if(change.equals("delete")){
				save.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备删除操作,设备ID："+id);
				month.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备删除操作,设备ID："+id);

				dao.DeleteEquipment(id);
			}
			save.close();
			month.close();
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

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
import equipment.jdbc.student.Student;
import equipment.jdbc.student.StudentDaoImp;
import equipment.logs.Logmonth;
import equipment.logs.Logsave;

public class Returnservlet extends HttpServlet {
	private   String class1=  null;
	private    String name1 =  null;
	private   String studentid1 = null;
	private static final long serialVersionUID = 1L;
    public Returnservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id =request.getParameter("change");
		String Returntime = request.getParameter("Returntime"+id);
		String Loanclass = request.getParameter("Loanclass"+id);
		String Status = request.getParameter("select"+id);
		String Loanstudentid = request.getParameter("Loanstudentid"+id);
		String Loanstudent = request.getParameter("Loanstudent"+id);
		
		EquipmentDaoImp dao = new EquipmentDaoImp();
		StudentDaoImp studao = new StudentDaoImp();
		PrintWriter ps = response.getWriter();
		try {
			Student stu = studao.IdenStudent(Loanstudentid);
		      class1= stu.getClass1();
		     name1 = stu.getName();
		   studentid1 = stu.getStudentid();
		} catch (Exception e1) {
			e1.printStackTrace();
			ps.write("<a href='manages.jsp'>学号不存在，请重新核对</a>");
			ps.flush();
		}
		
		Equipment ins=null; //获取更改前的实例状态，写入日志
		String a=null; 
	
		try {
			ins = dao.findbyid(id);
			String status2 = ins.getStatus();
			if(status2.equals("1")){
				a="完好";
			}else if(status2.equals("2")){
				a="良好";
			}else{
				a="损坏";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(class1!=null&&class1.equals(Loanclass)&&name1.equals(Loanstudent)){
		//change
		try {
			Equipment user = new Equipment();
			user.setId(id);
			user.setLoanclass(Loanclass);
			user.setLoanstudent(Loanstudent);
			user.setLoanstudentid(Loanstudentid);
			if(Status.equals("完好")){
				user.setStatus("1");
			}else if(Status.equals("良好")){
				user.setStatus("2");
			}else{
				user.setStatus("3");
			}
			if(Returntime.equals("")){
				user.setReturntime("");
			}else{
				user.setReturntime(Returntime);
			}
			//日志，month为月日志
			HttpSession session = request.getSession();
			Logsave save= new Logsave();
			Logmonth month = new Logmonth();
            save.save2("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备归还操作,设备ID："+id+">>>"+"归还人为："+Loanclass+"班，学号为："+Loanstudentid+
            		  "，学生："+ Loanstudent+"，归还时间："+Returntime);
            month.save2("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备归还操作,设备ID："+id+">>>"+"归还人为："+Loanclass+"班，学号为："+Loanstudentid+
          		  "，学生："+ Loanstudent+"，归还时间："+Returntime);
            if(!a.equals(Status)){
            	save.save(",状态由："+a+",更改为："+Status);
            	month.save(",状态由："+a+",更改为："+Status);
            }else{
            	save.save("");
            	month.save("");
            }
            save.close();
            month.close();
			dao.Change_in(user);
		response.sendRedirect("wait1.html");
			
		} catch (Exception e) {
			e.printStackTrace();
			ps.write("<a href='login.html'>出现未知错误，请返回登陆界面</a>");
			ps.flush();
		}
		
		}else{
			ps.write("<a href='equipment_in.jsp'>学生信息有误，请重新核对</a>");
		ps.flush();
		}
		
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

}

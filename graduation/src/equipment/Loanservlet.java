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

public class Loanservlet extends HttpServlet {
	private   String class1=  null;
	private    String name1 =  null;
	private   String studentid1 = null;
	private static final long serialVersionUID = 1L;
    public Loanservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id =request.getParameter("change");
		String Loantime = request.getParameter("Loantime"+id);
		String Loanclass = request.getParameter("Loanclass"+id);
		String Loanstudentid = request.getParameter("Loanstudentid"+id);
		String Loanstudent = request.getParameter("Loanstudent"+id);
		
		EquipmentDaoImp dao = new EquipmentDaoImp();
		PrintWriter ps = response.getWriter();
        
		StudentDaoImp studao = new StudentDaoImp();
		try {
			Student stu = studao.IdenStudent(Loanstudentid);
		      class1= stu.getClass1();
		     name1 = stu.getName();
		   studentid1 = stu.getStudentid();
		} catch (Exception e1) {
			e1.printStackTrace();
			ps.write("<a href='manages.jsp'>学生信息有误，请重新核对</a>");
			ps.flush();
		}
		
		if(class1!=null&&class1.equals(Loanclass)&&name1.equals(Loanstudent)){
		//change
		try {
			Equipment user = new Equipment();
			user.setId(id);
			user.setLoanclass(Loanclass);
			user.setLoanstudent(Loanstudent);
			user.setLoanstudentid(Loanstudentid);
			if(Loantime.equals("")){
				user.setLoantime("");
			}else{
				user.setLoantime(Loantime);
			}
			//日志
			HttpSession session = request.getSession();
			
			Logsave save= new Logsave();
			 Logmonth month = new Logmonth();
            save.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备借出操作,设备ID："+id+">>>"+"将设备借给："+Loanclass+"班，学号为："+Loanstudentid+
            		  "，学生："+ Loanstudent+"，借出时间："+Loantime);
            save.close();
            month.save("管理员:"+(String)session.getAttribute("name")+">>>"+"进行设备借出操作,设备ID："+id+">>>"+"将设备借给："+Loanclass+"班，学号为："+Loanstudentid+
          		  "，学生："+ Loanstudent+"，借出时间："+Loantime);
            month.close();
            
            //存储入数据库
			dao.Change_out(user);
		response.sendRedirect("wait1.html");
			
		} catch (Exception e) {
			e.printStackTrace();
			ps.write("<a href='login.html'>出现未知错误，请返回登陆界面</a>");
			ps.flush();
		}
		
		}//判断学生结束
		else{
			
			ps.write("<a href='equipment_out.jsp'>学生信息有误，请重新核对</a>");
			ps.flush();
		}
		
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		}

}

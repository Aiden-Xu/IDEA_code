package equipment.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import equipment.jdbc.Equipment;
public class StudentDaoImp implements StudentDao {
	Student user= new Student();
	 private String name;
	 private String class1;
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;

	
	
	//验证学生信息
	@Override
	public Student IdenStudent(String studentid) throws Exception {
		confactory();
		String sql="select t.name,t.class from student t where t.studentid=?";
		pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1,studentid);
		res= pstmt.executeQuery();
		while(res.next()){
			 name=res.getString(1);
			 class1=res.getString(2);
			 user.setClass1(class1);
			 user.setName(name);
			 user.setStudentid(studentid);
		}
		conclose();
		return user;
		
	}
	
	public void confactory() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
		 conn = DriverManager.getConnection(url,"xmh","xmh");
		
	}
	public void conclose() throws Exception{
		if(res!=null){
			res.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(conn!=null){
			conn.close();
		}
		
	}
		



	
}

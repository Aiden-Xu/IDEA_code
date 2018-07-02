package equipment.jdbc;

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
public class EquipmentDaoImp implements EquipmentDao {
	Equipment user= new Equipment();
	String id;
	String uname;
	String Loantime;
	String Returntime;
	String Status;
	String Loanclass;
	String Loanstudentid;
	String Loanstudent;
	String inout;
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;

	//存一个新的设备
	@Override
	public void SaveEquipment(Equipment user) throws Exception {
	confactory();
	String sql="insert into Equipment values(Equipment_id.nextval,?,?,?,?,?,?,?,?)";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,user.getName());
	pstmt.setString(2,user.getLoantime());
	pstmt.setString(3,user.getReturntime());
	pstmt.setString(4,user.getStatus());
	pstmt.setString(5,user.getLoanclass());
	pstmt.setString(6,user.getLoanstudentid());
	pstmt.setString(7,user.getLoanstudent());
	pstmt.setString(8,user.getInout());
	pstmt.executeQuery();
	conclose();
	}

  
	//通过名称查找设备
	@Override
	public List<Equipment> find(String name) throws Exception {
	confactory();
		String sql="select id,name,Loantime,Returntime,Status,Loanclass,Loanstudentid,Loanstudent,inout from Equipment where name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
	    res= pstmt.executeQuery();
		
		List<Equipment> list = new ArrayList<Equipment>();
		while(res.next()){
			 id=res.getString(1);
			 uname=res.getString(2);
			 Loantime=res.getString(3);
			 Returntime=res.getString(4);
			 Status=res.getString(5);
			 Loanclass=res.getString(6);
			 Loanstudentid=res.getString(7);
			 Loanstudent=res.getString(8);
			 inout=res.getString(9);
			 Equipment user= new Equipment();
			 user.setId(id);;
			user.setName(uname);
			user.setLoantime(Loantime);
			user.setReturntime(Returntime);
			user.setStatus(Status);
			user.setLoanclass(Loanclass);
			user.setLoanstudentid(Loanstudentid);
			user.setLoanstudent(Loanstudent);
			user.setInout(inout);
			list.add(user);
		}
		conclose();
		
	
		return list;
	}
	
	//通过ID查找设备
		public Equipment findbyid(String id) throws Exception {
			confactory();
				String sql="select id,name,Loantime,Returntime,Status,Loanclass,Loanstudentid,Loanstudent,inout from Equipment where id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
			    res= pstmt.executeQuery();
			    Equipment user1=null;
				while(res.next()){
					 id=res.getString(1);
					 uname=res.getString(2);
					 Loantime=res.getString(3);
					 Returntime=res.getString(4);
					 Status=res.getString(5);
					 Loanclass=res.getString(6);
					 Loanstudentid=res.getString(7);
					 Loanstudent=res.getString(8);
					 inout=res.getString(9);
					  user1= new Equipment();
					 user1.setId(id);
					user1.setName(uname);
					user1.setLoantime(Loantime);
					user1.setReturntime(Returntime);
					user1.setStatus(Status);
					user1.setLoanclass(Loanclass);
					user1.setLoanstudentid(Loanstudentid);
					user1.setLoanstudent(Loanstudent);
					user1.setInout(inout);
				}
				conclose();
				return user1;
 
	}
		
		
		//显示所有设备
	public List<Equipment> findAll() throws Exception{
	confactory();
		String sql="select id,name,Loantime,Returntime,Status,Loanclass,Loanstudentid,Loanstudent,inout from Equipment order by id";
		pstmt = conn.prepareStatement(sql);
		res= pstmt.executeQuery(sql);
		
		List<Equipment> list = new ArrayList<Equipment>();
		while(res.next()){
			 id=res.getString(1);
			 uname=res.getString(2);
			 Loantime=res.getString(3);
			 Returntime=res.getString(4);
			 Status=res.getString(5);
			 Loanclass=res.getString(6);
			 Loanstudentid=res.getString(7);
			 Loanstudent=res.getString(8);
			 inout=res.getString(9);
			 Equipment user= new Equipment();
			 user.setId(id);;
			user.setName(uname);
			user.setLoantime(Loantime);
			user.setReturntime(Returntime);
			user.setStatus(Status);
			user.setLoanclass(Loanclass);
			user.setLoanstudentid(Loanstudentid);
			user.setLoanstudent(Loanstudent);
			user.setInout(inout);
			list.add(user);
		}
		conclose();
		
		return list;
		
	}

	
	//删除一个设备
	@Override
	public void DeleteEquipment(String id) throws Exception {
	confactory();
		String sql="delete from equipment where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.executeQuery();
		conclose();
		
	}
	//更改设备信息
	public void ChangeManager(Equipment user) throws Exception {
	confactory();
		String sql="update Equipment set name=?,Loantime=?,Returntime=?,Status=?,Loanclass=?,Loanstudentid=?,Loanstudent=?,inout=? where id =?";
		 pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getName());
		java.util.Date d = null;
		java.util.Date d1 = null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 d=format.parse(user.getLoantime());
		 java.sql.Timestamp date = new java.sql.Timestamp(d.getTime());
		 d1=format.parse(user.getReturntime());
		 java.sql.Timestamp date1 = new java.sql.Timestamp(d1.getTime());
		 pstmt.setTimestamp(2, date);
		 pstmt.setTimestamp(3,date1);
	
	pstmt.setString(4,user.getStatus());
		pstmt.setString(5,user.getLoanclass());
		pstmt.setString(6,user.getLoanstudentid());
		pstmt.setString(7,user.getLoanstudent());
		pstmt.setString(8,user.getInout());
		pstmt.setString(9,user.getId());
		pstmt.executeQuery();
	conclose();
		
	}
	//修改时不要loantime
	public void ChangeManager_noloan(Equipment user) throws Exception {
		confactory();
			String sql="update Equipment set name=?,Loantime='',Returntime=?,Status=?,Loanclass=?,Loanstudentid=?,Loanstudent=?,inout=? where id =?";
			 pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getName());
			java.util.Date d1 = null;
			 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 try {
				d1=format.parse(user.getReturntime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 java.sql.Timestamp date1 = new java.sql.Timestamp(d1.getTime());
			 pstmt.setTimestamp(2,date1);
		pstmt.setString(3,user.getStatus());
			pstmt.setString(4,user.getLoanclass());
			pstmt.setString(5,user.getLoanstudentid());
			pstmt.setString(6,user.getLoanstudent());
			pstmt.setString(7,user.getInout());
			pstmt.setString(8,user.getId());
			pstmt.executeQuery();
		conclose();
		}
	//修改时不要Returntime
		public void ChangeManager_noreturn(Equipment user) throws Exception {
			confactory();
				String sql="update Equipment set name=?,Loantime=?,Returntime='',Status=?,Loanclass=?,Loanstudentid=?,Loanstudent=?,inout=? where id =?";
				 pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,user.getName());
				java.util.Date d1 = null;
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 d1=format.parse(user.getLoantime());
				 java.sql.Timestamp date1 = new java.sql.Timestamp(d1.getTime());
				 pstmt.setTimestamp(2,date1);
			pstmt.setString(3,user.getStatus());
				pstmt.setString(4,user.getLoanclass());
				pstmt.setString(5,user.getLoanstudentid());
				pstmt.setString(6,user.getLoanstudent());
				pstmt.setString(7,user.getInout());
				pstmt.setString(8,user.getId());
				pstmt.executeQuery();
			conclose();
			}
	
	//只保存Loantime
	public void save_loan(Equipment user) throws Exception {
		confactory();
		String sql="update Equipment set Loantime=? where id =?";
		pstmt = conn.prepareStatement(sql);
		java.util.Date d1 = null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 d1=format.parse(user.getLoantime());
		 java.sql.Timestamp date1 = new java.sql.Timestamp(d1.getTime());
		 pstmt.setTimestamp(1,date1);
		pstmt.setString(2,user.getId());
		pstmt.executeQuery();
	conclose();
	}
	
	//只保存Returntime
	public void save_return(Equipment user) throws Exception {
		confactory();
		String sql="update Equipment set Returntime=? where id =?";
		pstmt = conn.prepareStatement(sql);
		java.util.Date d1 = null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 d1=format.parse(user.getReturntime());
		 java.sql.Timestamp date1 = new java.sql.Timestamp(d1.getTime());
		 pstmt.setTimestamp(1,date1);
		pstmt.setString(2,user.getId());
		pstmt.executeQuery();
	conclose();
	}
	
	
	//为了下来菜单选择，不用自己写
	public List<String> SelectName(String name ) throws Exception {
		confactory();
		String sql="select distinct  name from equipment";
		pstmt = conn.prepareStatement(sql);
		res= pstmt.executeQuery();
		List<String> list = new ArrayList<String>();
		while(res.next()){
			 uname=res.getString(1);
			list.add(uname);
		}
		conclose();
		
		return list;
	}
	
	//查找已经借出的设备
	public List<Equipment> Selectin() throws Exception {
		confactory();
		String sql="select t.id,t.name,t.status from equipment t where t.inout=1";
		pstmt = conn.prepareStatement(sql);
	   res= pstmt.executeQuery();
		List<Equipment> list = new ArrayList<Equipment>();
		while(res.next()){
			 id=res.getString(1);
			 uname=res.getString(2);
			 Status=res.getString(3);
			 Equipment user= new Equipment();
			 user.setId(id);;
			user.setName(uname);
			user.setStatus(Status);
			list.add(user);
		}
		conclose();
		
		return list;
	}
	//查找已经归还的设备
	public List<Equipment> Selectout() throws Exception {
	confactory();
		String sql="select t.id,t.name,t.status from equipment t where t.inout=0";
		pstmt = conn.prepareStatement(sql);
		res= pstmt.executeQuery();
		List<Equipment> list = new ArrayList<Equipment>();
		while(res.next()){
			 id=res.getString(1);
			 uname=res.getString(2);
			 Status=res.getString(3);
			 Equipment user= new Equipment();
			 user.setId(id);;
			user.setName(uname);
			user.setStatus(Status);
			list.add(user);
		}
		conclose();
		
		return list;
	}
	
	//存储归还的信息
	public void Change_in(Equipment user) throws Exception {
		confactory();
		String sql="update Equipment set Loantime='',Returntime=?,status=?,Loanclass=?,Loanstudentid=?,Loanstudent=?,inout=0 where id =?";
		pstmt = conn.prepareStatement(sql);
		java.util.Date d = null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 d=format.parse(user.getReturntime());
		 java.sql.Timestamp date = new java.sql.Timestamp(d.getTime());
		 pstmt.setTimestamp(1, date);
		 pstmt.setString(2,user.getStatus());
	pstmt.setString(3,user.getLoanclass());
		pstmt.setString(4,user.getLoanstudentid());
		pstmt.setString(5,user.getLoanstudent());
		pstmt.setString(6,user.getId());
		pstmt.executeQuery();
		conclose();
	}
	//存储借出的信息
	public void Change_out(Equipment user) throws Exception {
		confactory();
		String sql="update Equipment set Loantime=?,Returntime='',Loanclass=?,Loanstudentid=?,Loanstudent=?,inout=1 where id =?";
		pstmt = conn.prepareStatement(sql);
		java.util.Date d = null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 d=format.parse(user.getLoantime());
		 java.sql.Timestamp date = new java.sql.Timestamp(d.getTime());
		 pstmt.setTimestamp(1, date);
	
	pstmt.setString(2,user.getLoanclass());
		pstmt.setString(3,user.getLoanstudentid());
		pstmt.setString(4,user.getLoanstudent());
		pstmt.setString(5,user.getId());
		pstmt.executeQuery();
		conclose();
	}
	
	
	//验证学生信息
	
	
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

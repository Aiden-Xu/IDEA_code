package manages.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ManagerDaoImp implements ManagerDao {
	Manager user= new Manager();
	String uname;
	String identity;
	String password;
	String phone;

      
	@Override
	public void SavaManager(Manager user) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
		Connection conn = DriverManager.getConnection(url,"xmh","xmh");
		String sql="insert into manage values(manage_id.nextval,?,?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setString(1,user.getName());
		pst.setString(2,user.getIdentity());
		pst.setString(3,user.getPhone());
		pst.setString(4,user.getPassword());
		pst.executeQuery();
		pst.close();conn.close();
	} 

	@Override
	public Manager find(String name) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	
		Connection conn = DriverManager.getConnection(url,"xmh","xmh");
		
		String sql="select name,identity,phone,password from manage where name = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		ResultSet req= pstmt.executeQuery();
		while(req.next()){
			 uname=req.getString(1);
			 identity=req.getString(2);
			 phone=req.getString(3);
			 password=req.getString(4);
		}
		user.setName(uname);
		user.setIdentity(identity);
		user.setPhone(phone);
		user.setPassword(password);
		return user;
 
	}
	public List<Manager> findAll() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
		Connection conn = DriverManager.getConnection(url,"xmh","xmh");
		Statement stmt = conn.createStatement();
		String sql="select name,identity,phone,password from manage ";
		ResultSet res= stmt.executeQuery(sql);
		
		List<Manager> list = new ArrayList<Manager>();
		while(res.next()){
			 uname=res.getString(1);
			 identity=res.getString(2);
			 phone=res.getString(3);
			 password=res.getString(4);
			Manager user= new Manager();
			user.setName(uname);
			user.setIdentity(identity);
			user.setPhone(phone);
			user.setPassword(password);
			list.add(user);
		}
		
		return list;
		
	}

	@Override
	public void DeleteManager(String name) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
		Connection conn = DriverManager.getConnection(url,"xmh","xmh");
		String sql="delete * from manage where name = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.executeQuery();
		pstmt.close();conn.close();
		
	}
	public void ChangeManager(Manager user) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521";
		Connection conn = DriverManager.getConnection(url,"xmh","xmh");
		String sql="update manage set name=?,identity=?,phone=?,password=? where id =?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getName());
		pstmt.setString(2,user.getIdentity());
		pstmt.setString(3,user.getPhone());
		pstmt.setString(4,user.getPassword());
		pstmt.setString(5,user.getId());
		pstmt.executeQuery();
		pstmt.close();conn.close();
		
	}

}

<%@page import="equipment.jdbc.EquipmentDaoImp"%>
<%@page import="equipment.jdbc.Equipment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="equipment.*,java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="description" content="许孟皓的大学设备管理系统">
		<title>大学设备管理系统</title>
		<LINK href="css/main.css" rel=stylesheet>
		<script language = "JavaScript" src = "js/main.js"></script>
		<script language = "JavaScript" src = "js/dateselect.js"></script>
		<%
if(session.getAttribute("name")==null){
	  out.println("<script>");
	  out.println("alert('你还没有登录!');");
	  out.println("parent.location.href='index.html';");
	  out.println("</script>");
}
%> 
	</head>
<body>
	<!--开头-->
		<table width="100%" border="0" cellspacing="0" cellpadding="0" id="table2">
		  <tr background="images/top_bg.gif" >
		    <td><img src="images/tyut.png"  height="58" width="40%"></td>
		     <td  align="right"  height="58" width="40%">
			<img src="images/top_r.gif" width="352" height="58" border="0"></td>
		  </tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td background="images/dh_bg.gif" align="left" height="12">
		      <table width="100" border="0" cellspacing="0" cellpadding="0" align="center">
		        <tr>
		          <td width="5%">　</td>
		          <td width="10%"><a href="logintyut.html" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image1','','images/index_on.gif',1)">
					<img name="Image1" border="0" src="images/index.gif" width="90" height="36"></a></td>
		        </tr>
		      </table>
		    </td>
		  </tr>
		</table>
		<table cellspacing="1" cellpadding="3" align="center" border="0" width="98%">
		<tr>
		<td width="65%"><BR>
		  欢迎访问 <b>大学设备管理系统</b> </td>
		<td width="35%" align="right">
		</td></tr></table>
		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href=index.html>大学设备管理系统</a> → 物品借出
                </td>
                	<%
				out.print("<td height=25 valign=middle align=right> 管理员:"+session.getAttribute("name")+",您好,<a href=/graduation/Logout>注销</a> </td>");
				%>
                </tr>
		</table>
		
<!--正文-->
			<form method="post" action="/graduation/Loanservlet" name="f1">
			<table cellpadding=3 cellspacing=1 align=center class=tableborder1 width="100%">
		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>设备ID</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>设备名称</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>借出时间</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>状态</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>借出班级</b></font></td>
			<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>学生</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif" width=""><font color="#ffffff"><b>学生ID</b></font></td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle align=center width=""><b>获取时间</b></td>
			<td class=tablebody2 valign=middle align="left" width=""  colspan="6"><input border="10" type="text" name='time'  onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"></input></td>
			</tr>
			<%
				EquipmentDaoImp dao = new EquipmentDaoImp();
						List<Equipment> list = new ArrayList<Equipment>();
						list = dao.Selectout();
						for (Equipment user : list) {
							String i = user.getId();
							String id = user.getId();
							String uname=user.getName();
							String Status=user.getStatus();
						 	out.print("<tr><td class=tablebody2 valign=middle align=center width=''>"+id+"<INPUT type='radio' name='change' value='"+i+"' checked='checked'>修改</td>");
					 	out.print("<td class=tablebody1 valign=middle align=center width=''>" + uname + "</td>");
						out.print("<td class=tablebody1 valign=middle align=center width=''><input type='text'  border='10' class='time' name='Loantime" + i
								+ "' value=''></td>");
									if(Status.equals("1")){
							out.print("<td class=tablebody1 valign=middle align=center width=''>完好</td>");
										
									}if(Status.equals("2")){
							out.print("<td class=tablebody1 valign=middle align=center width=''>良好</td>");
									}
									if(Status.equals("3")){
							out.print("<td class=tablebody1 valign=middle align=center width=''>损坏</td>");
								}  
							out.print("<td class=tablebody1 valign=middle align=center width=''><input type='text'  border='10' name='Loanclass" + i
											+ "' value=''></td>");
							out.print("<td class=tablebody1 valign=middle align=center width=''><input type='text'  border='10' name='Loanstudent" + i
									+ "' value=''></td>");
							out.print("<td class=tablebody1 valign=middle align=center width=''><input type='text'  border='10' name='Loanstudentid" + i
									+ "' value=''></td>");
									
						}
			%>
		
		
				<tr>
			<td class=tablebody2 valign=middle align=center colspan="7">
			<input type="submit" value="提交">
			<input type="button" value="返回" onclick="javascript:window.location='manages.jsp';">
			</td>
		</tr>
                </table><br>
			</form>

<!--尾部-->
<div id="div1" style=" width:100%; position:fixed; bottom:0px;" >
	<br>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
		  <tr>
		    <td height="20" background="images/bot_bg.gif">
		      　</td>
		  </tr>
		  <tr>
		    <td bgcolor="#f1f1f6" height="60" valign="center">
			<p align="center">xmh &copy;2016 - 2017 <a href="logintyut.html"><b><font>太原理工大学</font></b><font color=#CC0000>.com.cn</font></b></a><br>
			</td>
		  </tr>
		</table>
	</div>
	</body>
</html>
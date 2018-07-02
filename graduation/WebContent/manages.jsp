<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="许孟皓的大学设备管理系统">
<title>大学设备管理系统</title>
<LINK href="css/main.css" rel=stylesheet>
<script language="JavaScript" src="js/main.js"></script>



<%
if(session.getAttribute("name")==null){
	  out.println("<script>");
	  out.println("alert('你还没有登录!');");
	  out.println("parent.location.href='index.html';");
	  out.println("</script>");
}
%> 


</head>
<body opmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		id="table2">
		<tr background="images/top_bg.gif">
			<td><img src="images/tyut.png" height="58" width="40%"></td>
			<td align="right" height="58" width="40%"><img
				src="images/top_r.gif" width="352" height="58" border="0"></td>
		</tr>
	</table>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td background="images/dh_bg.gif" align="left" height="12">
				<table width="100" border="0" cellspacing="0" cellpadding="0"
					align="center">
					<tr>
						<td width="5%"></td>
						<td width="10%"><a href="logintyut.html"
							onMouseOut="MM_swapImgRestore()"
							onMouseOver="MM_swapImage('Image1','','images/index_on.gif',1)">
								<img name="Image1" border="0" src="images/index.gif" width="90"
								height="36">
						</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table cellspacing="1" cellpadding="3" align="center" border="0"
		width="98%">
		<tr>
			<td width="65%"><BR> 欢迎访问 <b>大学设备管理系统</b></td>
			<td width="35%" align="right"></td>
		</tr>
	</table>



	<!--文件体开始-->

		<table cellspacing=1 cellpadding=3 align=center class=tableBorder2 >
		<tr>
		<td height=25 valign=middle>
                  <img src="images/Forum_nav.gif" align="absmiddle">
                  <a href=index.html>大学设备管理系统</a> → 管理员操作
                </td>
                	<%
				out.print("<td height=25 valign=middle align=right> 管理员:"+session.getAttribute("name")+",您好,<a href=/graduation/Logout>注销</a> </td>");
				%>
                </tr>
		</table>
	<br>


	<table cellpadding="3" cellspacing="1" align="center" class="tableborder1" id="table1"  >
	<%String name =(String)session.getAttribute("name"); 
	String identdity =(String)session.getAttribute("identdity"); 
	String phone =(String)session.getAttribute("phone"); %>
	
		<tr>
			<td width="40%" class="tablebody2" align="right"><b>姓名</b>：</td>
			<td width="60%" class="tablebody1">
			<% out.print(name);%>
			 </td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>身份证号</b>：</td>
			<td class="tablebody1" valign=middle width=''>
               <% String identity =(String)session.getAttribute("identity");
			 out.print(identity);%>
            </td>
		</tr>
		<tr>
			<td class="tablebody2" align="right"><b>联系方式</b>：</td>
			<td class="tablebody1">	<% out.print(phone);%></td>
		</tr>
		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center>
			<input type=button value="借出" onclick="javascript:window.location='equipment_out.jsp';">
			<input type=button value="归还" onclick="javascript:window.location='equipment_in.jsp';">
			<input type=button value="增加设备" onclick="javascript:window.location='equipment.jsp';">
			<input type=button value="返回登陆" onclick="javascript:window.location='login.html';"></td>
		</tr>
	</table>
	
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
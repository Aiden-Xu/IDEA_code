<%@page import="manages.jdbc.ManagerDaoImp"%>
<%@page import="manages.jdbc.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="manages.*,java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="许孟皓的大学设备管理系统">
<title>大学设备管理系统</title>
<LINK href="css/main.css" rel=stylesheet>
<script src="jquery-3.1.1.min.js"></script>
<script language="JavaScript" src="js/main.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".add").click(function() {
			$(".new").toggle();
		});

	});
</script>

<style type="text/css">
input[name^='new'] {
	width: 160px;
	color: gray;
}

a.navlink:link {
	color: #000000;
	text-decoration: none
}

a.navlink:visited {
	color: #000000;
	text-decoration: none
}

a.navlink:hover {
	color: #003399;
	text-decoration: none
}

.BrightClass {
	background-color: #D7D7D7;
}
</style>

</head>
<%
	String name = (String) session.getAttribute("name");
	String identdity = (String) session.getAttribute("identdity");
	String phone = (String) session.getAttribute("phone");
	String password = (String) session.getAttribute("password");
%>
<body
	topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
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

	<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
			<td height=25 valign=middle><img src="images/Forum_nav.gif"
				align="absmiddle"> <a href=index.html>大学设备管理系统</a> → 权限管理员操作</td>
					<%
				out.print("<td height=25 valign=middle align=right> 管理员:"+session.getAttribute("name")+",您好,<a href=/graduation/Logout>注销</a> </td>");
				%>
		</tr>
	</table>
	<br>

	<form action="/graduation/Saveservlet" name="changer" method="post" >
	<table cellpadding="3" cellspacing="1" align="center"
		class="tableborder1" id="table1">

		<tr>
			<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>修改</b>：</td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>姓名</b>：</td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>身份证号</b>：</td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>联系方式</b>：</td>
			<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>密码</b>：</td>
		</tr>
		<%
			if (session.getAttribute("name").equals("xmh")) {
				ManagerDaoImp dao = new ManagerDaoImp();
				List<Manager> list = new ArrayList<Manager>();
				list = dao.findAll();
				int i = 1;
				for (Manager user : list) {
					String name1 = user.getName();
					String identity1 = user.getIdentity();
					String phone1 = user.getPhone();
					String password1 = user.getPassword();
					out.print("<tr><td class=tablebody1 valign=middle align=center width=''><INPUT type='radio' name='change' value='"+ i + "' checked='checked'>修改</td>");
					out.print("<td class=tablebody2 valign=middle align=center width=''><input type='text' name='name" + i
							+ "' value='" + name1 + "'></td>");
					out.print("<td class=tablebody1 valign=middle align=center width=''><input type='text' name='identity" + i
							+ "' value='" + identity1 + "'></td>");
					out.print("<td class=tablebody2 valign=middle align=center width=''><input type='text' name='phone" + i
							+ "' value='" + phone1 + "'></td>");
					out.print("<td class=tablebody1 valign=middle align=center width=''><input type='text' name='password" + i
							+ "' value='" + password1 + "'></td></tr>");
					i++;
				}
			} else {
				 out.println("<script>");
				  out.println("alert('您的权限不足!');");
				  out.println("parent.location.href='manages.jsp';");
				  out.println("</script>");
			}
		%>
		<!-- <tr>
<td class="tablebody1">例如</td>
			<td class="tablebody1">张三</td>
			<td class="tablebody1">140108199901011923</td>
			<td class="tablebody1">138XXXXXXXX</td>
			<td class="tablebody1">138XXXXXXXX</td>
		</tr> -->

		<tr>
			<td class=tablebody2 valign=middle colspan=2 align=center><input
				type="submit" name="change" value="确认修改""></td>
			<td class=tablebody2 valign=middle colspan=2 align=center><input
				type="button" value="新增用户" class="add" /></td>
				<td class=tablebody2 valign=middle colspan=2 align=center><input
				type="button" value="返回登陆界面"  class="add" onclick="window.location.href='login.html'"/></td>
		</tr>
		<tr>
		</tr>
	</table>
</form>
	<div class="new" visible="false" style="display:none">
		<form action="/graduation/Createservlet" name="add" method="get" id="formadd">
			<table cellpadding="3" cellspacing="1" align="center"
				class="tableborder1" id="table1">

				<tr>

					<td class="tablebody2" align="right"><b>姓名</b>：</td>
					<td class="tablebody2" align="right"><b>身份证号</b>：</td>
					<td class="tablebody2" align="right"><b>联系方式</b>：</td>
					<td class="tablebody2" align="right"><b>密码</b>：</td>
					<td class="tablebody2" align="right"><b>确认密码</b>：</td>
				</tr>
				<tr>

					<td  class=tablebody2 valign=middle align=center><input id="name"
						type="text" name="newname" value="请输入新管理员账号"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='请输入新管理员账号'}" /></input></td>
					<td  class=tablebody2 valign=middle align=center><input id="identity"
						type="text" name="newidentity" value="请输入新管理员身份证号码"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='请输入新管理员身份证号码'}" /></input></td>
					<td class=tablebody2 valign=middle align=center><input id="phone" 
						type="text" name="newphone" value="请输入新管理员联系方式"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='请输入新管理员联系方式'}" /></input></td>
					<td   class=tablebody2 valign=middle align=center><input id="pwd" 
						type="password" name="newpassword" value="请输入新管理员密码"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='请输入新管理员密码'}" /></input></td>
						<td  class=tablebody2 valign=middle align=center><input id="pwd1" 
						type="password" name="newpassword1" value="确认密码"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='确认密码'}" /></input></td>
				</tr>
				<tr>
				
						<td class=tablebody2 valign=middle colspan=5 align=center>	
						<input type="button" value="提交" onclick="checkpwd()"></td>
				</tr>
			</table>


		</form>
	</div>
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
<script type="text/javascript">
		function checkpwd(){ //max.jsp
			    var pwd = document.getElementById('pwd').value;    
			    var pwd1 = document.getElementById('pwd1').value;   
			    if(pwd != pwd1) {
			        alert('两次输入密码不同!');
			        document.getElementById('pwd').focus();
			        return false;
			    }
			 
			if(pwd1 == '') {
			        alert('密码不能为空!');
			        document.getElementById('pwd1').focus();
			        return false;
			    }
			document.add.submit();
	}

		</script>
</html>
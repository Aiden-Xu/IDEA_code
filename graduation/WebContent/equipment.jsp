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
<script src="jquery-3.1.1.min.js"></script>

<script language="JavaScript" src="js/dateselect.js"></script>
<script type="text/javascript">
			$(document).ready(function() {
				$("input[class^='time']").click(
						function() {
					        $(this).attr("onclick","SelectDate(this,'yyyy-MM-dd hh:mm:ss')");
		                  }
						);

			}); 
	/* 		
  	$(document).ready(function() {
		$("input[class^='time']").click(
				function() {
			        $(this).toggle();
                  }
				);

	});   */
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".add").click(function() {
			$(".new").toggle();
		});

	});
</script>
<%
if(session.getAttribute("name")==null){
	  out.println("<script>");
	  out.println("alert('你还没有登录!');");
	  out.println("parent.location.href='index.html';");
	  out.println("</script>");
}
%> 
<script language="JavaScript" src="js/main.js"></script>
</head>
<body>
	<!--开头-->
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
	<table cellspacing=1 cellpadding=3 align=center class=tableBorder2>
		<tr>
			<td height=25 valign=middle><img src="images/Forum_nav.gif"
				align="absmiddle"> <a href=index.html>大学设备管理系统</a> → 物品管理</td>
				
				<%
				out.print("<td height=25 valign=middle align=right> 管理员:"+session.getAttribute("name")+",您好,<a href=/graduation/Logout>注销</a> </td>");
				%>
		</tr>
	</table>

	<!--正文-->
	<form method="post" action="/graduation/ChangeAddservlet" name="f1">
		<table cellpadding=3 cellspacing=1 align=center class=tableborder1>
			<tr>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>设备ID</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>设备名称</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>最后借出时间</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>最后归还时间</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>状态</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>借出班级</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>学生ID</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>学生</b></font></td>
				<td valign=middle align=center height=25 background="images/bg2.gif"
					width=""><font color="#ffffff"><b>是否借出</b></font></td>
			</tr>
			<tr>
			<td class=tablebody2 valign=middle align=center width=""><b>获取时间</b></td>
			<td class=tablebody2 valign=middle align="left" width=""  colspan="8"><input border="10" type="text" name='loantime'  onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"></input></td>

			<br>


			<%
				EquipmentDaoImp dao = new EquipmentDaoImp();
						List<Equipment> list = new ArrayList<Equipment>();
						list = dao.findAll();
						
						for (Equipment user : list) {
							String i = user.getId();
							String id = user.getId();
							String uname=user.getName();
							String Loantime=user.getLoantime();
							String Returntime=user.getReturntime();
							String Status=user.getStatus();
							String Loanclass=user.getLoanclass();
							String Loanstudentid=user.getLoanstudentid();
							String Loanstudent=user.getLoanstudent();
							String inout=user.getInout();
						 	out.print("<tr><td class=tablebody2 valign=middle align=center width=''>"+id+"<input type='hidden' name='mark' value='"+i+"'/><INPUT type='radio' name='change' value='change"+i+"' checked='checked'>修改<INPUT type='radio' name='change' value='delete"+i+"' >删除</td>");
					 	out.print("<td class=tablebody1 valign=middle width=''><input type='text' name='name" + i
									+ "' value='" + uname + "'></td>");
							out.print("<td class=tablebody1 valign=middle width=''><input type='text' class='time"+i+"'  name='Loantime" + i
									+ "' value='" + Loantime + "'  ></td>");
							out.print("<td class=tablebody1 valign=middle width=''><input type='text' class='time"+i+i+"' border='10' name='Returntime" + i
									+ "' value='" + Returntime + "'></td>");
						
									if(Status.equals("1")){
							out.print("<td class=tablebody1 valign=middle align=center width=''><select name='select"+i+"' id='select_k1' class='xla_k><option value='完好'>?</option><option value='完好' selected='selected'>完好</option><option value='良好'>良好</option><option value='损坏'>损坏</option></select></td>");
										
									}if(Status.equals("2")){
							out.print("<td class=tablebody1 valign=middle align=center width=''><select name='select"+i+"' id='select_k1' class='xla_k><option value='完好'>?</option><option value='完好' >完好</option><option value='良好' selected='selected'>良好</option><option value='损坏'>损坏</option></select></td>");
									}
									if(Status.equals("3")){
							out.print("<td class=tablebody1 valign=middle align=center width=''><select name='select"+i+"' id='select_k1' class='xla_k><option value='完好'>?</option><option value='完好' >完好</option><option value='良好'>良好</option><option value='损坏' selected='selected'>损坏</option></select></td>");
								}  
							out.print("<script>function myFunction(){document.getElementById('select_k1').innerHTML=Status;}</script>");
							out.print("<td class=tablebody1 valign=middle width=''><input type='text' name='Loanclass" + i
									+ "' value='" + Loanclass + "'></td>");
							out.print("<td class=tablebody1 valign=middle width=''><input type='text' name='Loanstudentid" + i
									+ "' value='" + Loanstudentid + "'></td>");
							out.print("<td class=tablebody1 valign=middle width=''><input type='text' name='Loanstudent" + i
									+ "' value='" + Loanstudent + "'></td>");
							out.print("<td class=tablebody1 valign=middle width=''><input type='text' name='inout" + i
									+ "' value='" + inout + "'></td></tr>");
						}
			%>

	
			
			<tr>
			<!-- 	<td class=tablebody1 valign=middle width=''><input type='text'class='time5' name='Loantime' ></td>
				<td class=tablebody1 valign=middle width=''>
				<input type='text' class='time' name='Loantime' onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')">
				</td>
				<td class=tablebody2 valign=middle width=""><input type="text" class="akfhn" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" ></td>
				 -->
				<td class=tablebody2 valign=middle align=center colspan="9">
				<input type="submit" value="提交"> 
				<input type="button" value="返回" onclick="javascript:window.location='manages.jsp';">
				<input type="button" value="新增设备" class="add" />
				<input type="submit" value="删除设备"  />
				
				</td>
				
					
			</tr>

		</table>
	</form>
	
	
	<div class="new" visible="false" style="display:none">
		<form action="/graduation/Addservlet" name="add" method="get" id="formadd">
			<table cellpadding="3" cellspacing="1" align="center"
				class="tableborder1" id="table1">

				<tr>

					<td class="tablebody2" align="center"><b>设备名</b>：</td>
					<td class="tablebody2" align="center"><b>设备状态(1为完好；2为良好；3为损坏)</b>：</td>
				</tr>
				<tr>
					<td  class=tablebody2 valign=middle align=center><input id="name"
						type="text" name="newname" value="请输入设备名称"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='请输入设备名称'}" /></input></td>
					<td  class=tablebody2 valign=middle align=center>
					<input id="identity"
						type="text" name="newstatus" value="请输入设备状态(1,2,3)"
						onfocus="this.value=''"
						onblur="if(this.value==''){this.value='请输入设备状态'}" /></input></td>
					
				</tr>
				<tr>
				
						<td class=tablebody2 valign=middle colspan=2 align=center>	
						<input type="button" value="提交" onclick="javascript:document.add.submit()"></td>
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

</html>
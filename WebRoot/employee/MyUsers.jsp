<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>管理</title>
<link rel="stylesheet" type="text/css" href="css/base.css">

</head>
<body leftmargin="8" topmargin="8" background='<%=path%>/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="<%=path%>/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
 <td align="center"> <font color="bulue" size="5">部门员工列表  </font></td>
 </tr>
</table>
</td>
</tr>
</table>
 
 
<!--  内容列表   -->
<form name="form2">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="images/tbg.gif">&nbsp;&nbsp;</td>
</tr>

<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="10%">真实姓名</td>
	<td width="10%">性别</td>
	<td width="10%">邮箱</td>
	<td width="8%">电话号码</td>
	<td width="10%">地址</td>
	<td width="6%">所属部门</td>
	<td width="8%">职位</td>
	<td width="8%">薪资</td>
	<td width="15%">操作</td>
</tr>
    <c:forEach var="user" items="${requestScope.list}">  
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>
	 <input name="id" type="checkbox" id="id" value="101" class="np">
	</td>
	<td>${user.realname}</td>
	<td>${user.sex}</td>
	<td>${user.email}</td>
	<td>${user.telphone} </td>
	<td>${user.address}</td>
	<td>${user.departname} </td>
	<td>${user.role}</td>
	<td>${user.salary}</td>
	<td>
	 <a href="<%=path%>/user/AltUser?toid=${user.toid}">编辑</a> 
	 
	 <a href="<%=path%>/user/DelUser?toid=${user.toid}">删除</a>
	 </td>
</tr>
</c:forEach>
 
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center">
	<!--翻页代码 --></td>
</tr>
</table>

</form>


</body>
</html>
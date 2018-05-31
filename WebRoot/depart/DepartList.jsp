<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>部门管理</title>
<link rel="stylesheet" type="text/css" href="css/base.css">

</head>
<body leftmargin="8" topmargin="8" background='<%=path%>/images/allbg.gif' style="background-color:D1DDAA">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="<%=path%>/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="right">
    <input type='button' class="coolbg np" onClick="location='<%=path%>/depart/AddDepart';" value='添加部门' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>
 
  
<!--  内容列表   -->
<form name="form2">

<table width="60%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td align="center" height="26" colspan="10" background="<%=path%>/images/tbg.gif">&nbsp;部门管理&nbsp;</td>
</tr>
 
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="4%">选择</td>
	<td width="10%">部门ID</td>
	<td width="10%">部门名称</td>
	<td width="10%">部门经理</td>
	<td width="10%">操作</td>	 
</tr>
    <c:forEach var="depart" items="${requestScope.list}">  
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>
	 <input name="id" type="checkbox" id="id" value="101" class="np">
	</td>
	<td>${depart.toid}</td>
	<td>${depart.departmentname}</td>
	<td>${depart.manager}</td>	 
	<td>
	 <a href="<%=path%>/depart/AltDepart?toid=${depart.toid}">编辑</a> 
	 
	 <a href="<%=path%>/depart/DelDepart?toid=${depart.toid}">删除</a>
	 </td>
</tr>
</c:forEach>
 
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="10" align="center"> <!--翻页代码 --></td>
</tr>
</table>

</form>


</body>
</html>
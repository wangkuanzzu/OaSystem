<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>邮箱</title>
  </head> 
 <body leftmargin="8" topmargin="8" background='<%=path%>/images/allbg.gif'style="background-color:D1DDAA">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="<%=path%>/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td align="right">
    <input type='button' class="coolbg np" onClick="location='<%=path%>/message/SendMessege';" value='发送邮件' />
 </td>
 </tr>
</table>
</td>
</tr>
</table>
 
 <!--  内容列表   -->
<form name="form2">

<table width="80%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td align="center" height="26" colspan="15" background="<%=path%>/images/tbg.gif">我的邮箱<br></td>
</tr>
 
<tr align="center" bgcolor="#FAFAF1" height="22">
	<td width="2%">选择</td>
	 
	<td width="8%">发件人</td>
	 
	<td width="8%">是否已读</td>
	<td width="8%">操作</td>
</tr>
    <c:forEach var="message" items="${requestScope.list}">  
<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
	<td>
	 <input name="id" type="checkbox" id="id" value="101" class="np">
	</td>
 
	<td>${message.sendname}</td>
	 <c:if test="${message.isread=='0'}">
	<td><font color="red">未读</font></td>
	 </c:if>
	 <c:if test="${message.isread=='1'}">   
	<td><font color="gray">已读</font></td>
	 </c:if>
	 
	
	<td>
      <a href="<%=path%>/message/LookMessage?toid=${message.toid}">查看</a> 
	  <a href="<%=path%>/message/DelMessage?toid=${message.toid}">删除</a>
	 </td>
</tr>
</c:forEach>
 
<tr align="right" bgcolor="#EEF4EA">
	<td height="36" colspan="15" align="center"> <!--翻页代码 --></td>
</tr>
</table>

</form>


</body>
</html>
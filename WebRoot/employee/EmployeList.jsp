<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Object user=session.getAttribute("user");
 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>管理</title>
<link rel="stylesheet" type="text/css" href="css/base.css">

<script type="text/javascript">
function page(s){
  var myform = document.getElementById("myform");
  var pageNo = document.getElementById("pageNo");
  pageNo.value = s;
  myform.submit();
}
</script>
</head>
<body leftmargin="8" topmargin="8" background='<%=path%>/images/allbg.gif' style="background-color:D1DDAA">

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="<%=path%>/images/newlinebg3.gif">
  <table width="98%" border="0" cellspacing="0" cellpadding="0">
  <c:if test="${user.role=='admin'}">
  <tr>
  <td align="right">
    <input type='button' class="coolbg np" onClick="location='<%=path%>/user/AddUser';" value='添加员工' />
 </td>
 </tr>
 </c:if>
</table>
</td>
</tr>
</table>
 
 <!--  搜索表单  -->
<form name='form3' action='<%=path%>/user/SearchUser' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='<%=path%>/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>                      
           <select name="departid">
           <option value='0'>选择部门...</option>
           <c:forEach var="depart" items="${requestScope.list2}">
           <option value="${depart.toid}">${depart.departmentname }</option>
         </c:forEach>
        </select>
        </td>
        <td width='70'>  &nbsp;
           姓名：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:150px'/>
        </td>
        
        <td>&nbsp;
          <input name="imageField" type="image" src="<%=path%>/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
  
<!--  内容列表   -->
<form action="<%=path%>/user/UserPageList" method="POST" id="myform">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="10" background="<%=path%>/images/tbg.gif">&nbsp;员工列表&nbsp;</td>
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
    <c:forEach var="user" items="${requestScope.pageBean.objs}">  
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
	 <a href="<%=path%>/message/EveryMessage?toid=${user.toid}">发信息</a>
	 
	
	 </td>
</tr>
</c:forEach>
 <tr> </tr>
<tr align="center">
  <td colspan="8">
  当前页：<input   type="text" value="${pageBean.pageNo}" />
      跳转到：<input id="pageNo" type="text" name="pageNo" value="${pageBean.pageNo}" />
    每页记录数：<input type="text" name="pageCount" value="${pageBean.pageCount}" />
    <input type="submit"  value="跳转"/>
    共有 ${pageBean.totalPage}页
     <a onclick="page(1);">首页</a>
     <c:if test="${requestScope.pageBean.previous}">
        <a onclick="page(${requestScope.pageBean.pageNo-1});">上一页</a>
    </c:if>
    <c:if test="${requestScope.pageBean.next}">
        <a onclick="page(${pageBean.pageNo+1});">下一页</a>
    </c:if>
    <a onclick="page(${requestScope.pageBean.totalPage});">最后一页</a>
  </td>
</tr>
</table>

</form>

</body>
</html>
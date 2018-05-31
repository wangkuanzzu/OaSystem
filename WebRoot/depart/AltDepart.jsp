<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <base href="<%=basePath%>">  
    <title>修改员工</title>
  </head>
  
  <body style="background-color:D1DDAA">
    <center>
   <h3>修改部门</h3>
  <form  action="<%=path%>/depart/AltDepart" method="post">
   <table>
   <tr>
   <td>部门ID:</td>
   <td><input type="text" name="toid" value= "${depart.toid}" readonly/></td> 
   </tr>
    <tr>
   <td>部门名称:</td>
   <td><input type="text" name="departmentname" value= "${depart.departmentname}"/></td> 
   </tr>
    <tr>
   <td>部门经理:</td>
   <td>
   <select name="managerid">
   <c:forEach var="user" items="${requestScope.list}">
   <option value="${user.toid}">${user.realname}</option>
    </c:forEach>
    </select>
    </td> 
   </tr>
</table>
 <input type="submit" name="确认修改"> 
  </form> 
  </center>
  </body>
</html>

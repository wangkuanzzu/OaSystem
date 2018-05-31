<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <base href="<%=basePath%>">  
    <title>修改员工</title>
  </head>
  
  <body style="background-color:D1DDAA">
    <center>
   <h3>修改员工</h3>
  <form  action="<%=path%>/user/AltUser?toid=${user.toid}" method="post">
   <table>
   <tr>
   <td>员工姓名:</td>
   <td><input type="text" name="realname" value= "${user.realname}" readonly/></td> 
   </tr>
   <tr>
  <td>邮箱：</td>
  <td><input type="text" name="email" value="${user.email}" /></td>
   </tr>
   <tr>
  <td>电话：</td>
  <td><input type="text" name="telphone" value="${user.telphone}"/></td>
   </tr>
   <tr>
   <td>地址:</td>
   <td><input type="text" name="address" value= "${user.address}"/></td> 
   </tr> 
   <tr>
   <td>薪资:</td>
   <td><input type="text" name="salary" value= "${user.salary}"/></td> 
   </tr>
   <tr>
   <td>部门:</td>
    <td>
   <select name="departid">
    <c:forEach var="depart" items="${requestScope.list}">
   <option value="${depart.toid}">${depart.departmentname }</option>
    </c:forEach>
    </select>
    </td>
   </tr>
    <tr>
   <td>员工职位:</td>  
    <td>
    <select name="role" >
   <option value="admin">管理员</option>
   <option value="manager">部门经理</option>
   <option value="saler">销售员</option>
   </select>
    </td>
   </tr>
</table>
 <input type="submit" name="确认修改"> 
  </form> 
  </center>
  </body>
</html>

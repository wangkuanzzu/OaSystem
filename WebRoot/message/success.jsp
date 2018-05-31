<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  <base target="_self">
<link rel="stylesheet" type="text/css" href="<%=path%>css/base.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
</head>
<body leftmargin="20" topmargin='80'>
 
  <center>
  <table>
  <tr bgcolor="#FFFFFF">
    <td><a href="<%=path%>/user/UserPageList"><font color="blue" size="6">发送成功，点击返回上层页面！</font></a> </td>
  </tr>
 </table>
 </center>
  </body>
</html>

  
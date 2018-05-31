<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>欢迎来到OA管理系统</title>
<base target="_self">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/main.css" />
</head>
 <script>
          if (top.location != self.location) {
              window.top.location = self.location;
           }
    
        function checkcode(){
        
           var imgid=document.getElementById("imgid");
           imgid.src="<%=path%>/user/CheckCodeServlet?ud="+Math.random();     
           }
    </script>
<body leftmargin="8" topmargin='50'>
 <center>
  <h1>欢迎来到OA管理系统</h1> 
  <form action="<%=path%>/user/UserLogin"  method="post"> 
  <c:if test="${param.msg=='1' }">
  <p style="color:red" >用户名或密码错误</p>
   </c:if>
  <c:if test="${param.msg=='2' }">
  <p style="color:red" >验证码错误</p>
   </c:if>
<table width="40%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr>
    <td colspan="2" background="<%=path%>/images/frame/wbg.gif" bgcolor="#EEF4EA" class='title'>
    	<div style='float:left'>
		<span>OA系统登陆</span></div>
    	<div style='float:right;padding-right:10px;'></div>
   </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td height="30" colspan="3" align="center" valign="bottom"><table  border="0" cellspacing="1" cellpadding="1">
        <tr>
          <td width="15%" height="31" align="center">
		    账号
		  </td>
		  <td  height="31" align="center">
		  <input type="text" name="username" />
		  </td>
        </tr>
		<tr>
          <td width="15%" height="31" align="center">
		    密码
		  </td>
		  <td  height="31" align="center">
		  <input type="password" name="password" />
		  </td>
        </tr>
        <tr>
          <td width="30%" height="31" align="center">
		  验证码
		  </td>
		  <td><img  src="<%=path%>/user/CheckCodeServlet" onclick="checkcode()" id="imgid">
		  </td>
        </tr>
        <tr>
        <td>&nbsp;</td>
        <td> <input type="text" name="checkcode" /></td></tr>
		<tr>
          <td width="15%" height="31" align="center">
		    <input type="submit" value="登录" />
		  </td>
		  <td  height="31" align="center">
		  <input type="reset" value="取消" />
		  </td>
        </tr>
      </table></td>
  </tr>
</table>
 </form>
  </center>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
Object user=session.getAttribute("user");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="../error/error.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" " http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发送电子邮件</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="../image/com.css"/></head>
<body> 
<form method="post" name="form1" action="<%=path%>/message/SendMessege">
  <table width="480" height="300" border="1" align="center" cellpadding="0" cellspacing="0">
    <tr bordercolor="#D4D0C8" bgcolor="#FEFFC9"> 
      <td height="27" colspan="2" align="left"><div align="center"><strong>发送电子邮件</strong></div></td>
    </tr>
    <tr bgcolor="#FEFFC9"> 
      <td width="100" height="27" align="left"><div align="right">收件人：</div></td>
     
      <td width="406" height="27"><div align="center"> 
         <select name="sendid"  >
           <option value='0'>选择收件人...</option>
           <c:forEach var="emp" items="${requestScope.list}">
           <option value="${emp.toid}">${emp.realname}</option>
         </c:forEach>
        </select>
        </div></td>
    </tr>
    
   
    <tr bgcolor="#FEFFC9"> 
      <td height="27" align="left"><div align="right">发件人：</div></td>
      <td height="27"> <div align="center"> 
          <input type="text" name="username" size="51" value="${user.realname}" readonly>
        </div></td>
    </tr>
     
    <tr align="left" bgcolor="#FEFFC9"> 
      <td height="227" valign="top"><div align="right">内 &nbsp;容：</div></td>
      <td height="227"><div align="center"> 
          <textarea name="message" cols="50" rows="12"></textarea>
        </div></td>
    </tr>
    <tr align="center" valign="middle" bordercolor="#D4D0C8" bgcolor="#FEFFC9"> 
      <td height="29" colspan="2"><input type="submit" name="Submit" value="发送"> 
        &nbsp;&nbsp; <input type="reset" name="Submit2" value="清除"></td>
    </tr>
  </table>
</form>
</body>
</html>

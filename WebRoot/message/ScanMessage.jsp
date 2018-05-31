<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
Object user=session.getAttribute("user");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=gb2312" language="java" errorPage="../error/error.jsp" %>
 
<html>
<head>
<title>电子邮件</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="../image/com.css"/>
<!--  
　<script language="javascript">

　　window.location.reload(true);

　　</script>
-->
</head>
<body style="background-color:D1DDAA"> 
<form method="post" name="form1" action="<%=path%>/message/MessageList"  >
  <table style="background-color:D1DDAA" width="50%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
    <tr bordercolor="#D1DDAA" bgcolor="#D1DDAA"> 
      <td height="27" colspan="2" align="left"><div align="center"><strong>查收邮件</strong></div></td>
    </tr>
      <tr bgcolor="#FEFFC9"> 
      <td height="27" align="left"><div align="right">发件人：</div></td>
      <td height="27"> <div align="center"> 
          <input type="text" name="username" size="51" value="${message.sendname}" readonly>
        </div></td>
    </tr> 
    <tr align="left" bgcolor="#FEFFC9"> 
      <td height="227" valign="top"><div align="right">内 &nbsp;容：</div></td>
      <td height="227"><div align="center"> 
          <textarea name="message" cols="50" rows="12" readonly>${message.content}</textarea>
        </div></td>
    </tr>
    <tr align="center" valign="middle" bordercolor="#D4D0C8" bgcolor="#FEFFC9"> 
      <td height="29" colspan="2"><input type="submit" name="Submit" value="返回"> 
    </td>
    </tr>
  </table>
</form>
</body>
</html>

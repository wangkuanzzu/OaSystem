<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<script>
  
function modifySubmit() {
	if ("" == document.getElementById("username").value) {
		document.getElementById("usernameMsg").innerHTML="<font color='red'>用户名不能空</font>";
		document.getElementById("username").focus();
		return  ;
	}
	
	
	if ("" == document.getElementById("password1").value) {
	 
		document.getElementById("password1Msg").innerHTML="<font color='red'>密码不能空</font>"
		 
		document.getElementById("password1").focus();
		return  ;
	}
	
	if ("" == document.getElementById("password2").value) {
	 
		document.getElementById("password2Msg").innerHTML="<font color='red'>请验证密码</font>";
		 
		document.getElementById("password2").focus();
		return  ;
	}
	 
 
	if (""!= document.getElementById("password1").value 
			&& document.getElementById("password2").value!=document.getElementById("password1").value) {
		 
		document.getElementById("password2Msg").innerHTML="<font color='red'>两次密码不匹配</font>";
		 
		document.getElementById("password2").focus();
		return  ;
	}
	 var myform=document.getElementById("myform");
	 myform.submit();
}

</script>

<body style="background-color:D1DDAA">
<center>
<h3><font color="bulue">修改账号密码</font></h3>
<form action="<%=path%>/user/AltAccount"  method="post"  id="myform" >

	<table >
		<tr>
			<td>登陆名</td>
			<td><input type="text" name="username" value="${user.username}" id="username" 
			  /></td>
			<td>
				<span id="usernameMsg"><font color="red"></font>
				</span>
			</td>
		</tr>
		 
		<tr>
			<td>新密码</td>
			<td><input type="password" name="password" id="password1"/></td>
			<td>
				<span id="password1Msg"><font color="grey"></font>
				</span>
			</td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type="password" name="password" 
			id="password2"  /></td>
			<td>
				<span id="password2Msg"><font color="red"></font>
				</span>
			</td>
		</tr>
		 
		<tr>
			<td></td>
			<td><input type="button" value="确认修改" onclick="modifySubmit()"/></td>
			<td></td>
		</tr>
	</table>
</form>
</center>
</body>
</html>
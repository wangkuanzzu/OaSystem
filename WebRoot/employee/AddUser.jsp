<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script>
 

 
 function checkUser(){
         var username=document.getElementById("username");
         var salary=document.getElementById("salary");
         var password=document.getElementById("password");
         var realname=document.getElementById("realname");
         var email=document.getElementById("email");
         var address=document.getElementById("address");
         var telphone=document.getElementById("telphone");
        
         if(username.value==''){
           var userMsg=document.getElementById("userMsg");
           userMsg.innerHTML="<font color='red'>账号不能为空</font>"
            return ;
         }
        if(username.value.length>20){
           var userMsg=document.getElementById("userMsg");
           userMsg.innerHTML="<font color='red'>账号太长，账号最大长度为20</font>"
            return ;
         }
         if(password.value==''){
            var PwdMsg=document.getElementById("PwdMsg");
            PwdMsg.innerHTML="<font color='red'>密码不能为空</font>"
            return ;
         }
         if(password.value.length>20){
            var PwdMsg=document.getElementById("PwdMsg");
            PwdMsg.innerHTML="<font color='red'>密码太长</font>"
            return ;
         }
         if(realname.value==''){
            var nameMsg=document.getElementById("nameMsg");
            nameMsg.innerHTML="<font color='red'>名字不能为空</font>"
            return ;
         }
         
         if(email.value==''){
            var emailmsg=document.getElementById("emailmsg");
            emailmsg.innerHTML="<font color='red'>邮箱不能为空</font>"
            return ;
         }
         
          var sReg=/[_a-zA-Z\d\-\.]+@[_a-zA-Z\d\-]+(\.[_a-zA-Z\d\-]+)+$/;   
         if   (!sReg.test(email.value))   
           {   
            var emailmsg=document.getElementById("emailmsg");
            emailmsg.innerHTML="<font color='red'>Email地址错误！请重新输入。</font>"
            return ;   
            } 
        
            
         if(email.value.length>20){
            var emailmsg=document.getElementById("emailmsg");
            emailmsg.innerHTML="<font color='red'>邮箱太长</font>"
            return ;
         }
           if(telphone.value==''){
           var telphonemsg=document.getElementById("telphonemsg");
           telphonemsg.innerHTML="<font color='red'>电话号码不能为空</font>"
            return ;
         }
          function checkmobile(value){          
          var myreg =  /^-?\d+$/;         
          if(!myreg.test(value)){             
            var telphonemsg=document.getElementById("telphonemsg");
           telphonemsg.innerHTML="<font color='red'>电话号码格式不对,只能为数字</font>"  
           return ;  
            }     
          }
          checkmobile(telphone.value);
         if(telphone.value.length>20){
           var telphonemsg=document.getElementById("telphonemsg");
           telphonemsg.innerHTML="<font color='red'>电话号码太长，电话号码最大长度为20</font>"
            return ;
         }
      
         if(address.value==''){
           var addressmsg=document.getElementById("addressmsg");
           addressmsg.innerHTML="<font color='red'>地址不能为空</font>"
            return ;
         }
         if(address.value.length>50){
           var addressmsg=document.getElementById("addressmsg");
           addressmsg.innerHTML="<font color='red'>地址太长，地址最大长度为50</font>"
            return ;
         }
       
         if(salary.value==''){
            var salarymsg=document.getElementById("salarymsg");
            salarymsg.innerHTML="<font color='red'>薪水不能为空</font>"
            return;
         }
          if(isNaN(salary.value)){
             var salarymsg=document.getElementById("salarymsg");
            salarymsg.innerHTML="<font color='red'>薪水格式不对</font>"
            return;
           }    
         var myform=document.getElementById("myform");
         myform.submit();
}
</script>

  <head>   
    <title>添加员工</title>
  </head>

  <body style="background-color:D1DDAA">
   <center>
   <h3>添加员工</h3>
  <form  action="<%=path%>/user/AddUser" method="post"   id="myform">
   <table >
   <tr>
   <td>用户名:</td>
   <td>
   <input type="text" name="username" id="username" onfocus="document.getElementById('userMsg').innerHTML=''" /></td> 
      
   <td><span id="userMsg"><font color="red"></font></span></td>	
   </tr>
  
   <tr>
   <td>初始密码:</td>
   <td>
   <input type="text" name="password" id="password" onfocus="document.getElementById('PwdMsg').innerHTML=''" /></td> 
      
   <td><span id="PwdMsg"><font color="red"></font></span></td>	
   </tr>
    <tr>
   <td>真实姓名:</td>
   <td>
   <input type="text" name="realname" id="realname"  onfocus="document.getElementById('nameMsg').innerHTML=''" /></td>      
   <td><span id="nameMsg"><font color="red"></font></span></td>	
   </tr>
   <tr>
   <td>性别:</td>
   <td> 
   <input type="radio" name="sex" value="male" /> 男
   <input type="radio" name="sex" value="female" />女
    </td>
   </tr>
   <tr>
  <td>邮箱：</td>
  <td><input type="text" name="email" id="email" onfocus="document.getElementById('emailmsg').innerHTML=''"  /></td>
  <td><span id="emailmsg"></span></td>
   </tr>
   <tr>
  <td>电话：</td>
  <td><input type="text" name="telphone" id="telphone" onfocus="document.getElementById('telphonemsg').innerHTML=''" /></td>
  <td><span id="telphonemsg"></span></td>
   </tr>
   <tr>
   <td>地址:</td>
   <td><input type="text" name="address" id="address" onfocus="document.getElementById('addressmsg').innerHTML=''"/></td> 
    <td><span id="addressmsg"></span></td>
   </tr>
    <tr>
   <td>薪资:</td>
   <td><input type="text" name="salary"  id="salary" onfocus="document.getElementById('salarymsg').innerHTML=''"/></td> 
   <td><span id="salarymsg"></span></td>
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
    <select name="role">
   <option value="admin">管理员</option>
   <option value="manager">部门经理</option>
   <option value="saler">销售员</option>
   </select>
    </td>
   </tr>
 </table>
 <input type="button"  value="确认添加" onclick="checkUser()"> 
  </form> 
  </center>
  </body>
</html>

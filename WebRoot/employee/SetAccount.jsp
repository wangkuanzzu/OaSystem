<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Object user=request.getAttribute("user");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <html>
  <head>   
    <title>我的资料</title>
     <script type="text/javascript" defer="defer" src="<%=path%>/My97DatePicker/WdatePicker.js"></script>
   
     <script>
      function checkUser(){
         var username=document.getElementById("username");
         var email=document.getElementById("email");
         var address=document.getElementById("address");
         var telphone=document.getElementById("telphone");
         var qq=document.getElementById("qq");
        
         if(username.value==''){
           var namemsg=document.getElementById("namemsg");
           namemsg.innerHTML="<font color='red'>账号不能为空</font>"
            return ;
         }
         if(username.value.length>20){
           var namemsg=document.getElementById("namemsg");
           namemsg.innerHTML="<font color='red'>账号太长，账号最大长度为20</font>"
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
            
          if(qq.value==''){
           var qqmsg=document.getElementById("qqmsg");
           qqmsg.innerHTML="<font color='red'>qq号码不能为空</font>"
            return ;
         }
           
          var myreg = /^-?\d+$/;         
          if(!myreg.test(qq.value)){             
            var qqmsg=document.getElementById("qqmsg");
           qqmsg.innerHTML="<font color='red'>qq号码格式不对,只能为数字</font>"  
           return ;  
            }     
       
         if(qq.value.length>20){
           var qqmsg=document.getElementById("qqmsg");
           qqmsg.innerHTML="<font color='red'>qq号码太长，电话号码最大长度为20</font>"
            return ;
         }
         
         if(telphone.value==''){
           var telphonemsg=document.getElementById("telphonemsg");
           telphonemsg.innerHTML="<font color='red'>电话号码不能为空</font>"
            return ;
         }
               
          var myreg =  /^-?\d+$/;         
          if(!myreg.test(telphone.value)){             
            var telphonemsg=document.getElementById("telphonemsg");
           telphonemsg.innerHTML="<font color='red'>电话号码格式不对,只能为数字</font>"  
           return ;  
            }   
          
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
        
         var myform=document.getElementById("myform");
            myform.submit();
       }
       
     </script>
  </head>
  <body style="background-color:D1DDAA">
   <center>
   <h3>我的资料</h3>
  <form  action="<%=path%>/user/SetMyAcount" method="post" id="myform">
   <table>
   <tr>
   <td>用户名:</td>
   <td>
   <input type="text" name="username" id="username" value=${user.username} onfocus="document.getElementById('namemsg').innerHTML=''"/></td> 
      
   <td><span id="namemsg"><font color="red"></font></span></td>	
   </tr>
   <tr>
   <td>性别:</td>
   <td > 
   <input type="radio" name="sex" value="male" checked /> 男
   <input type="radio" name="sex" value="female" />女
    </td>
   </tr>
    <tr>
  <td>生日：</td>
   <td>
  <input id="d12" type="text" name="birthday" value=${user.birthday}/>
 <img onclick="WdatePicker({el:'d12'})" src="<%=path%>/My97DatePicker/skin/datePicker.gif" width="16" height="22" >
  </td>
   </tr>
   <tr>
   <td>邮箱：</td>
   <td><input type="text" name="email" id="email" value=${user.email} onfocus="document.getElementById('emailmsg').innerHTML=''"/></td>
   <td><span id="emailmsg"></span></td>
   </tr>
    <tr>
   <td>QQ：</td>
   <td><input type="text" name="qq" id="qq" value=${user.qq} onfocus="document.getElementById('qqmsg').innerHTML=''"/></td>
   <td><span id="qqmsg"></span></td>
   </tr>
   <tr>
  <td>电话：</td>
  <td><input type="text" name="telphone" id="telphone" value=${user.telphone} onfocus="document.getElementById('telphonemsg').innerHTML=''"/></td>
  <td><span id="telphonemsg"></span></td>
   </tr>
   <tr>
   <td>地址:</td>
   <td><input type="text" name="address" id="address" value=${user.address}  onfocus="document.getElementById('addressmsg').innerHTML=''"/></td> 
    <td><span id="addressmsg"></span></td>
   </tr>
 </table>
 <input type="button"  value="确认更改"  onclick="checkUser()"> 
  </form> 
  </center>
  </body>
</html>


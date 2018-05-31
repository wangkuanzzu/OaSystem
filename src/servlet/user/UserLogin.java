package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

import service.MessageService;
import utils.LoginTest;

public class UserLogin extends HttpServlet {

	 
	public UserLogin() {
		super();
	}
 
	public void destroy() {
		super.destroy(); //  
		 
	}

 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession  session=request.getSession();
		response.setContentType("text/html");
		 String username=request.getParameter("username");
	     String password=request.getParameter("password");
	     String checkcode=request.getParameter("checkcode");
		  String rand=(String) session.getAttribute("rand");
		 
		  if (checkcode.equals(rand)){
	     LoginTest  login=new LoginTest();
	     boolean flag=login.hasuser(username, password);
	      User emp=login.getUser(username, password);        
  //	   System.out.println(checkcode);
   //	   System.out.println(rand);
	      if(flag){
	    	  MessageService service=new MessageService();
	    	 int count=service.unReadCount(emp.getToid()); 
	    	
	    		 session.setAttribute("user", emp);
	    		 session.setAttribute("count", count);
 
	    		 request.getRequestDispatcher("/style/index2.jsp").forward(request,response);        
	      }else{
	    	   
	    	  request.getRequestDispatcher("/index.jsp?msg=1").forward(request,response );
	      }
		  }else{
			  request.getRequestDispatcher("/index.jsp?msg=2").forward(request,response );		  
		  }
	      
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		 doPost(request, response);
	}
	 
	public void init() throws ServletException {
	 
	}

}

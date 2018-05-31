package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import service.UserServices;
import utils.LoginTest;

public class AltAccount extends HttpServlet {
 
	public AltAccount() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          request.getRequestDispatcher("/employee/AltAccount.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      	HttpSession  session=request.getSession();
	 User user = (User) session.getAttribute("user");
	   int toid=user.getToid();
       String username=request.getParameter("username");
         // System.out.println(user.getToid());
       String password=request.getParameter("password");
//       System.out.println(username);
//       System.out.println(password);
        UserServices service=new UserServices();
        service.AltAccount(username, password, toid);
         LoginTest  login=new LoginTest();
	     boolean flag=login.hasuser(username, password);
	     if(flag){
		 request.getRequestDispatcher("/style/Jump.jsp").forward(request,response);  
	   }
	}
	public void init() throws ServletException {
		// Put your code here
	}

}

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

public class SetMyAcount extends HttpServlet {
 
	public SetMyAcount() {
		super();
	}
	public void destroy() {
		super.destroy();  
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    HttpSession session=request.getSession();
     User user=(User)session.getAttribute("user");
     request.setAttribute("user", user);
	 request.getRequestDispatcher("/employee/SetAccount.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 HttpSession session=request.getSession();
	      User user1=(User)session.getAttribute("user");
	      int toid=user1.getToid();
		  String username=request.getParameter("username");
		   String birthday=request.getParameter("birthday");
		   String email=request.getParameter("email");
		   String telphone=request.getParameter("telphone");
		   String address=request.getParameter("address");
		   String qq=request.getParameter("qq");
		   String sex=request.getParameter("sex");	 
		   User user=new User(); 
		   user.setToid(toid);
		    user.setUsername(username);
		    user.setBirthday(birthday);
		    user.setQq(qq);
			user.setSex(sex);
			user.setEmail(email);
			user.setAddress(address);
			user.setTelphone(telphone);
			UserServices service=new UserServices();
			service.AltMySelf(user);
			 
			UserServices service2=new UserServices();
			User user2=service2.getUserbyID(toid);
			session.setAttribute("user",user2 );
		 request.getRequestDispatcher("/style/Jump2.jsp").forward(request,response);  
		 
	}
 
	public void init() throws ServletException {
		 
	}

}

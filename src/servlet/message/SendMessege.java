package servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

import service.MessageService;
import service.UserServices;

public class SendMessege extends HttpServlet {
 
	public SendMessege() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      UserServices service=new UserServices();
       List<User>  list= service.findAllUsers();
		request.setAttribute("list", list);	
		request.getRequestDispatcher("/message/SendMessage.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		int userid=user.getToid();
		int Sendto=Integer.parseInt(request.getParameter("sendid"));
		String message=request.getParameter("message");
		MessageService service=new MessageService();
		service.SendMsg(userid, Sendto, message);
	
		request.getRequestDispatcher("/message/successs.jsp").forward(request,response);
		
 
	}
 
	public void init() throws ServletException {
		 
	}

}

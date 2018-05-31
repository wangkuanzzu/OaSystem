package servlet.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

import service.MessageService;
import service.UserServices;

public class EveryMessage extends HttpServlet {
 
	public EveryMessage() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         int toid=Integer.parseInt(request.getParameter("toid"));
          UserServices service=new UserServices();
          User touser= service.getUserbyID(toid);
          request.setAttribute("touser", touser);
         request.getRequestDispatcher("/message/EveryMessage.jsp").forward(request, response);
		 
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		int userid=user.getToid();
		int Sendto=Integer.parseInt(request.getParameter("toname"));
     	//	System.out.println(Sendto);
		String message=request.getParameter("message");
		MessageService service=new MessageService();
		service.SendMsg(userid, Sendto, message);
		request.getRequestDispatcher("/message/success.jsp").forward(request,response);
		 
	}
 
	public void init() throws ServletException {
		 
	}

}

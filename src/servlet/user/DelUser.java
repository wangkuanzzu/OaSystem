package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.UserServices;

public class DelUser extends HttpServlet {
 
	public DelUser() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		int toid=Integer.parseInt(request.getParameter("toid"));
		UserServices service=new UserServices();
	       service.DelUserbyId(toid); 
		request.getRequestDispatcher("/user/UserPageList").forward(request,response);
	}
 
	public void init() throws ServletException {
 
	}

}

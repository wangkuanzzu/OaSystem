package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QuitLogin extends HttpServlet {
 
	public QuitLogin() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		
	}

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession  session=request.getSession();
	    session.invalidate();
      	request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
  	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 
	}

 
	public void init() throws ServletException {
		// Put your code here
	}

}

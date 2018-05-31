package servlet.dept;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DepartService;

public class DelDepart extends HttpServlet {
 
	public DelDepart() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    
		int toid=Integer.parseInt(request.getParameter("toid"));
		DepartService service=new DepartService();
		service.DelDepart(toid);
		request.getRequestDispatcher("/depart/DepartList").forward(request, response);
		
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	}
 
	public void init() throws ServletException {
	 
	}

}

package servlet.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Department;
import pojo.User;
import service.DepartService;
import service.ProductServices;
import service.UserServices;

public class DepartList extends HttpServlet {
 
	public DepartList() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DepartService service=new DepartService();
	     List<Department> list=new ArrayList<Department>();
	     list=service.findAllDepart();
	     request.setAttribute("list", list);	  
	    request.getRequestDispatcher("/depart/DepartList.jsp").forward(request, response); 
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             doGet(request, response);
	}
 
	public void init() throws ServletException {
		// Put your code here
	}

}

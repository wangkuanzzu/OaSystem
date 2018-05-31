package servlet.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Department;
import pojo.Product;
import pojo.User;
import service.DepartService;
import service.ProductServices;
import service.UserServices;

public class AltDepart extends HttpServlet {
 
	public AltDepart() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
		 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         UserServices service2=new UserServices();
         List<User> list=service2.findAllUsers();
        request.setAttribute("list", list);
		int toid=Integer.parseInt(request.getParameter("toid"));
	    DepartService service=new DepartService();
	     Department depart= service.getDepartbyId(toid);
		request.setAttribute("depart", depart);
		request.getRequestDispatcher("/depart/AltDepart.jsp").forward(request,response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int toid=Integer.parseInt(request.getParameter("toid"));
		  String departmentname=request.getParameter("departmentname");
			int managerid=Integer.parseInt(request.getParameter("managerid"));
			Department depart=new Department();
			depart.setToid(toid);
			depart.setManagerid(managerid);
			depart.setDepartmentname(departmentname);
			DepartService service=new DepartService();
			 service.AltDepart(depart);
		request.getRequestDispatcher("/depart/DepartList").forward(request,response);
	}
 
	public void init() throws ServletException {
		 
	}

}

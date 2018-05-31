package servlet.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Department;
import pojo.User;
import service.DepartService;
import service.UserServices;

public class AddDepart extends HttpServlet {
 
	public AddDepart() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        UserServices service=new UserServices();
        List<User> list= service.findAllUsers();
        request.setAttribute("list", list);
		request.getRequestDispatcher("/depart/AddDepart.jsp").forward(request,response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
   String departmentname=request.getParameter("departmentname");
	int managerid=Integer.parseInt(request.getParameter("managerid"));
	Department depart=new Department();
	depart.setDepartmentname(departmentname);
	depart.setManagerid(managerid);
	DepartService service=new DepartService();
	service.AddDepart(depart);
	request.getRequestDispatcher("/depart/DepartList").forward(request, response);
		
	}
 
	public void init() throws ServletException {
		 
	}

}

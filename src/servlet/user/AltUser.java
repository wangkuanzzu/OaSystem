package servlet.user;

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

public class AltUser extends HttpServlet {
 
	public AltUser() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DepartService service2=new DepartService();
	     List<Department> list= service2.findAllDepart();
	    request.setAttribute("list", list);
		int toid=Integer.parseInt(request.getParameter("toid"));
		UserServices service=new UserServices();
	    User  user=service.getUserbyID(toid);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/employee/AltEmploye.jsp").forward(request,response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 int toid=Integer.parseInt(request.getParameter("toid"));
		   String realname=request.getParameter("realname");
		   String email=request.getParameter("email");
		   String telphone=request.getParameter("telphone");
		   String address=request.getParameter("address");
		   float salary=Float.parseFloat((request.getParameter("salary")));
		   String role=request.getParameter("role");
		   int departid=Integer.parseInt(request.getParameter("departid"));
		    User user=new User();
		      user.setToid(toid);
		      user.setRealname(realname);
		      user.setEmail(email);
		      user.setTelphone(telphone);
		      user.setAddress(address);
		      user.setSalary(salary);
		      user.setDepartid(departid);
		      user.setRole(role);
		    UserServices service=new UserServices();
		    service.AltUser(user);
			 
		 request.getRequestDispatcher("/user/UserPageList").forward(request,response);
	}
 
	public void init() throws ServletException {
		// Put your code here
	}

}

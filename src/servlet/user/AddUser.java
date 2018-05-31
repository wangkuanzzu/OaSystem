package servlet.user;

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

public class AddUser extends HttpServlet {
 
	public AddUser() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	DepartService service=new DepartService();
     List<Department> list= service.findAllDepart();
    request.setAttribute("list", list);
	 request.getRequestDispatcher("/employee/AddUser.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   String username=request.getParameter("username");
		   String realname=request.getParameter("realname");
		   String password=request.getParameter("password");
		   String email=request.getParameter("email");
		   String telphone=request.getParameter("telphone");
		   String address=request.getParameter("address");
		   float salary=Float.parseFloat((request.getParameter("salary")));
		   String role=request.getParameter("role");
		   String sex=request.getParameter("sex");
		   int departid=Integer.parseInt(request.getParameter("departid"));
		   User user=new User(); 
		    user.setUsername(username);
			user.setRealname(realname);
			user.setPassword(password);
			user.setSex(sex);
			user.setEmail(email);
			user.setAddress(address);
			user.setTelphone(telphone);
			user.setSalary(salary);
			user.setDepartid(departid);
			user.setRole(role);
		   UserServices service=new UserServices();
		   service.AddUser(user);
		  request.getRequestDispatcher("/user/UserPageList").forward(request, response);
	}
 
	public void init() throws ServletException {
		// Put your code here
	}

}

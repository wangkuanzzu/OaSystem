package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pageBean.EmpBiz;
import pageBean.PageBean;
import pojo.Department;
import pojo.User;

import service.DepartService;
import service.UserServices;

public class SearchUser extends HttpServlet {
 
	public SearchUser() {
		super();
	}
 
	public void destroy() {
	super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 int toid=Integer.parseInt(request.getParameter("departid"));
		 String key=request.getParameter("keyword");
		 DepartService service2=new DepartService();
		    List<Department> list2= service2.findAllDepart();
		    request.setAttribute("list2", list2);	  	    
		    int pageNo = 1;
		    int pageCount = 3;
		    String pageNoStr = request.getParameter("pageNo");
		    String pageCountStr = request.getParameter("pageCount");
		    if(pageNoStr != null){
		      pageNo = Integer.parseInt(pageNoStr);
		    }
	        if(pageCountStr != null){
		      pageCount = Integer.parseInt(pageCountStr);
	        }
		    if ((key!="")&&(toid!=0)){
			    UserServices service=new UserServices();
		    	List<User> list=service.SearchUser(toid, key);	
		    	 PageBean pageBean =new PageBean(list, list.size(), pageNo, pageCount) ;
		    	 request.setAttribute("pageBean",pageBean);
			    request.getRequestDispatcher("/employee/EmployeList.jsp").forward(request, response); 
			  }
		   else if ((toid==0)&&(key!="")){
			 UserServices service=new UserServices();
		     List <User> list=  service.searchUser(key);
		     PageBean pageBean =new PageBean(list, list.size(), pageNo, pageCount) ;
	    	 request.setAttribute("pageBean",pageBean);
		     request.getRequestDispatcher("/employee/EmployeList.jsp").forward(request, response); 
		     }  
		     else   {
		    	UserServices service=new UserServices();
		    	List <User> list=service.findUserByDepat(toid);
		    	 PageBean pageBean =new PageBean(list, list.size(), pageNo, pageCount) ;
		    	 request.setAttribute("pageBean",pageBean);
			    request.getRequestDispatcher("/employee/EmployeList.jsp").forward(request, response); 	    	
		    }
		  
	}
 
	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	}
 
	public void init() throws ServletException {
		// Put your code here
	}

}

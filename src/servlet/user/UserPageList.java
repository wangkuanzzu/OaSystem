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
import service.DepartService;

public class UserPageList extends HttpServlet {
 
	public UserPageList() {
		super();
	}

	 
	public void destroy() {
		super.destroy();  
	}

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		 DepartService service2=new DepartService();
		    List<Department> list2= service2.findAllDepart();
		    request.setAttribute("list2", list2);	    
		 
		    EmpBiz biz = new EmpBiz();
		    //给页数和每页数量一个初始值
		    int pageNo = 1;
		    int pageCount = 5;
		    String pageNoStr = request.getParameter("pageNo");
 		    String pageCountStr = request.getParameter("pageCount");
		    if(pageNoStr != null){
		      pageNo = Integer.parseInt(pageNoStr);
		    }
 	       if(pageCountStr != null){
 		      pageCount = Integer.parseInt(pageCountStr);
 	    }
		    PageBean pageBean = biz.listEmps(pageNo,pageCount);
		   // System.out.println(pageBean.getObjs().size());
		    request.setAttribute("pageBean",pageBean);
		    request.getRequestDispatcher("/employee/EmployeList.jsp").forward(request,response);
		  }
		  //Process the HTTP Post request
		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
		      ServletException, IOException {
		    doGet(request, response);
		  }
	 
	 
	public void init() throws ServletException {
		// Put your code here
	}

}

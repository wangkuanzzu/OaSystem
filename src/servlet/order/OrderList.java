package servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Orders;
import pojo.User;

import service.OrderService;

public class OrderList extends HttpServlet {
 
	public OrderList() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
	   	User user=(User)session.getAttribute("user");
	  	List<Orders> list=new  ArrayList<Orders>();
	    OrderService service=new OrderService();
	   	if(user.getRole().equals("manager")){ 
		    list=service.findOrderbyDepart(user.getDepartid());	   
	   	}else{
	   		 list=service.findMyOrder(user.getToid());  		
	   	}
	   request.setAttribute("list", list);
       request.getRequestDispatcher("/order/OrderList.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
 
	public void init() throws ServletException {
		 
	}

}

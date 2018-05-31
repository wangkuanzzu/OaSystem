package servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Orders;
import pojo.Product;
import pojo.User;
import service.OrderService;
import service.ProductServices;
import service.UserServices;

public class AddOrder extends HttpServlet {
 
	public AddOrder() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		    
		HttpSession session=request.getSession();
		 User user=(User)session.getAttribute("user");
//         UserServices service1=new UserServices();
//          List<User> list1=service1.findAllUsers();
          ProductServices service2=new ProductServices();
             List<Product> list2=service2.getProductList();
             request.setAttribute("saler", user );
             request.setAttribute("list2", list2);
		request.getRequestDispatcher("/order/AddOrder.jsp").forward(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String custname=request.getParameter("custname");
		String custaddress=request.getParameter("custaddress");
		String custphone=request.getParameter("custphone");
		String custemail=request.getParameter("custemail");
		String ordertime=request.getParameter("ordertime");
		int productid=Integer.parseInt(request.getParameter("productid"));
		ProductServices proservice=new ProductServices();
	     Product pro=	proservice.getprobyID(productid);
		 float price=pro.getPrice();
		int productcount=Integer.parseInt(request.getParameter("productcount"));
		float money= price*productcount;
	     int userid=Integer.parseInt(request.getParameter("userid"));
	     SimpleDateFormat sdf=new SimpleDateFormat();
			String createtime = sdf.format(new Date());
	     Orders order=new Orders();
	     order.setCustname(custname);
	     order.setCustaddress(custaddress);
	     order.setCustphone(custphone);
	     order.setCustemail(custemail);
	     order.setOrdertime(ordertime);
	     order.setProductid(productid);
	     order.setProductcount(productcount);
	     order.setMoney(money);
	     order.setCreatetime(createtime);
	     order.setUserid(userid);
		OrderService service=new OrderService();
		service.AddOrders(order);
		request.getRequestDispatcher("/order/OrderList").forward(request, response);
	 }
 
	public void init() throws ServletException {
	}

}

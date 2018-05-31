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

import pojo.Orders;
import pojo.Product;
import pojo.User;

import service.OrderService;
import service.ProductServices;
import service.UserServices;

public class AltOrder extends HttpServlet {
 
	public AltOrder() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserServices service1=new UserServices();
        List<User> list1=service1.findAllUsers();
        ProductServices service2=new ProductServices();
           List<Product> list2=service2.getProductList();
           request.setAttribute("list1", list1);
           request.setAttribute("list2", list2);
       int toid=Integer.parseInt(request.getParameter("toid"));
       OrderService service=new OrderService();
       Orders order=service.getOrdersbyId(toid);
       request.setAttribute("order", order);
       request.getRequestDispatcher("/order/AltOrder.jsp").forward(request, response);
    
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int toid=Integer.parseInt(request.getParameter("toid"));
  	//	System.out.println(toid);
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
	     order.setToid(toid);
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
	     service.AltOrder(order);
	     request.getRequestDispatcher("/order/OrderList").forward(request, response);
	     
		
	}
 
	public void init() throws ServletException {
	 
	}

}

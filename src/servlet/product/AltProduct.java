package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Product;

import service.ProductServices;

public class AltProduct extends HttpServlet {

	 
	public AltProduct() {
		super();
	}
 
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	 
	} 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int toid=Integer.parseInt(request.getParameter("toid"));
		ProductServices service=new ProductServices();
		Product pro=service.getprobyID(toid);
		request.setAttribute("pro", pro);
		request.getRequestDispatcher("/product/AltProduct.jsp").forward(request,response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		   int toid=Integer.parseInt(request.getParameter("toid"));
		   String productname=request.getParameter("productname");
			float price=Float.parseFloat((request.getParameter("price")));
			Product pro=new Product();
			pro.setToid(toid);
			pro.setProductname(productname);
			pro.setPrice(price);
			ProductServices service =new ProductServices();
			service.AltProduct(pro);
			request.getRequestDispatcher("/pro/ProductList").forward(request,response);
	}

	 
	public void init() throws ServletException {
		// Put your code here
	}

}

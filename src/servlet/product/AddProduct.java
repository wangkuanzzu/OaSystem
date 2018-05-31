package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Product;
import service.ProductServices;

public class AddProduct extends HttpServlet {
 
	public AddProduct() {
		super();
	}
	public void destroy() {
		super.destroy();  
		 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.getRequestDispatcher("/product/AddProduct.jsp").forward(request,response);  
		 
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		   String productname=request.getParameter("productname");
			float price=Float.parseFloat((request.getParameter("price")));
			Product pro=new Product();
			pro.setProductname(productname);
			pro.setPrice(price);
			ProductServices service =new ProductServices();
			service.AddProduct(pro);
			request.getRequestDispatcher("/pro/ProductList").forward(request,response);
	 
	}
 
	public void init() throws ServletException {
	 
	}

}

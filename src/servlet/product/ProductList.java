package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Product;

import service.ProductServices;

public class ProductList extends HttpServlet {
 
	public ProductList() {
		super();
	}

	 
	public void destroy() {
		super.destroy();  
	 
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductServices service=new ProductServices();
	    List<Product> list=service.getProductList();
	   
		  request.setAttribute("list", list);
		  
 request.getRequestDispatcher("/product/productList.jsp").forward(request, response); 
	}
	
	
public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	doGet(request, response);
	
}
	public void init() throws ServletException {
		// Put your code here
	}

}

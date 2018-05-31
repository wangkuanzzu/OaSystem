package servlet.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductServices;

public class DelProduct extends HttpServlet {

 public DelProduct() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	}

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int toid=Integer.parseInt(request.getParameter("toid"));
		ProductServices service =new ProductServices();
		service.delProductbyId(toid);
		request.getRequestDispatcher("/pro/ProductList").forward(request,response);
	 
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	}
 
	public void init() throws ServletException {
		// Put your code here
	}

}

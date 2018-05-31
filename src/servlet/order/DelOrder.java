package servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.OrderService;

public class DelOrder extends HttpServlet {
	public DelOrder() {
		super();
	}

	public void destroy() {
		super.destroy();  
	 
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       int toid=Integer.parseInt(request.getParameter("toid"));
       OrderService service=new OrderService();
       service.delOrder(toid);
       request.getRequestDispatcher("/order/OrderList").forward(request, response);
    
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init() throws ServletException {
		
	}

}

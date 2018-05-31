package servlet.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MessageService;

public class DelMessage extends HttpServlet {
 
	public DelMessage() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
		 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        int toid=Integer.parseInt(request.getParameter("toid"));
        MessageService  service=new MessageService();
        service.DelMessage(toid);
        request.getRequestDispatcher("/message/MessageList").forward(request, response);
 
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	}

 
	public void init() throws ServletException {
		 

   }
}
package servlet.message;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Message;

import service.MessageService;

public class LookMessage extends HttpServlet {
 
	public LookMessage() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
           int toid=Integer.parseInt(request.getParameter("toid"));
           MessageService service=new MessageService();
           service.Read(toid);
            Message message=service.findMsgbyId(toid);
            request.setAttribute("message", message); 
           // System.out.println(toid);
		     request.getRequestDispatcher("/message/ScanMessage.jsp").forward(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	}
 
	public void init() throws ServletException {
	 
	}

}

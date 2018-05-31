package servlet.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Message;
import pojo.User;

import service.MessageService;

public class MessageList extends HttpServlet {
 
	public MessageList() {
		super();
	}
 
	public void destroy() {
		super.destroy();  
	 
	}
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		MessageService service=new MessageService();
		List<Message> list= service.findMyMsg(user.getToid());
		request.setAttribute("list", list);	
		request.getRequestDispatcher("/message/msgList.jsp").forward(request, response);
	 }
 
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
	       doGet(request, response); 
	
	}
 
	public void init() throws ServletException {
	 
	}

}

package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

public class FilterOsLogin  implements Filter{
private 	List<String>  list = new ArrayList<String>();
	 
	
	public void destroy() {
		 
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
	  
		  HttpServletRequest request=(HttpServletRequest)arg0;
	      HttpServletResponse response=(HttpServletResponse)arg1;  
	      String urls = request.getServletPath();	 
	//	  System.out.println(urls);
  if(list.contains(urls)){		
	      // System.out.println("·¢Æð");
	    	arg2.doFilter(request, response); 
	    }
    else {
    //	System.out.println("fewfw");
	    	HttpSession session=request.getSession( );	
	    	User str=(User)session.getAttribute("user");	    	
	    	if(str==null){
	        	 
	    	    request.getRequestDispatcher("/index.jsp").forward(arg0, arg1);
	    	 } else{
	     	     arg2.doFilter(request, response);    	      
           }
      }
}
	public void init(FilterConfig arg0) throws ServletException {
	
		list.add("/index.jsp");
		list.add("/user/UserLogin");
		list.add("/user/CheckCodeServlet");
	}
}



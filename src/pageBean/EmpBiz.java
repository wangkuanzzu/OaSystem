package pageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.User;
import utils.DBOperator;

public class EmpBiz {

	
	  public EmpBiz() {
	  }
	//具体实现分页的方法，传递两个参数，一个第几页，一个每页的数量
	  public PageBean listEmps(int pageNo, int pageCount){
	    Connection conn=DBOperator.getConnection();
	    
	      ResultSet rs = null;
	      PreparedStatement  ps=null;
	      ArrayList<User> emps = new ArrayList<User>();
	     //  计算前后两个范围，用a，b表示
     	//      int a = pageNo* pageCount;
	      int b = (pageNo-1)* pageCount;
	      try {      
	 ps=conn.prepareStatement("SELECT * from user as u left join department as d on  u.departid=d.toid  limit ?,?");
	 ps.setInt(1,b);
	 ps.setInt(2,pageCount);
	rs=ps.executeQuery();
    while(rs.next()){
	User user=new User();
	user.setToid(rs.getInt(1));
	user.setUsername(rs.getString(2));
	user.setPassword(rs.getString(3));
	user.setRealname(rs.getString(4));
	user.setSex((rs.getString(5)));
	user.setBirthday(rs.getString(6));
	user.setEmail(rs.getString(7));
	user.setAddress(rs.getString(8));
	user.setTelphone(rs.getString(9));
	user.setQq(rs.getString(10));
	user.setSalary(rs.getFloat(11));
	user.setDepartid(rs.getInt(12));
	user.setRole(rs.getString(13));
	user.setDepartname(rs.getString(15));
	 emps.add(user);  //获得当前页数据
	}
	
    rs = ps.executeQuery("select count(*) from user");
	        int totalCount=0;
	        if(rs.next()){
	         totalCount = rs.getInt(1);
	        }
	        
	   //     System.out.println(emps.size());
	 PageBean pageBean = new PageBean(emps,totalCount,pageNo,pageCount);
	       return pageBean;
	      }
	      catch (Exception ex) {
	        System.out.println("发生错误，错误是:" + ex.getMessage());
	        return null;
	      } finally {
	      DBOperator.close(rs, ps, conn);
	       }
	   }
} 
 

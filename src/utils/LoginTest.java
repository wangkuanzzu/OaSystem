package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;


public class LoginTest {
	 public boolean hasuser(String username,String password){
    	 Connection conn = DBOperator.getConnection();
			PreparedStatement ps = null;
			ResultSet rs=null;  
			boolean flag=false;
			try {
				ps = conn.prepareStatement("select * from user where  username= ? and password=? ");
				ps.setString(1, username);
				ps.setString(2, password);
		      	rs=ps.executeQuery();
		      	flag=rs.next();      
      }catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBOperator.close(rs, ps, conn);
		 
	}
	 return flag;
    }
	
	 public User getUser(String username,String password){
		 User emp=new User();
		 Connection conn = DBOperator.getConnection();
			PreparedStatement ps = null;
			ResultSet rs=null;	
			try {
				ps = conn.prepareStatement("select * from user where username= ? and password=? ");
				ps.setString(1,username);
				ps.setString(2, password);
			   rs=ps.executeQuery();
			 while (rs.next()){	  
				 emp.setToid(rs.getInt(1));
				 emp.setUsername(rs.getString(2));
				 emp.setPassword(rs.getString(3));
				 emp.setRealname(rs.getString(4));
				 emp.setSex(rs.getString(5));
				 emp.setBirthday(rs.getString(6));
				 emp.setEmail(rs.getString(7));
				 emp.setAddress(rs.getString(8));
				 emp.setTelphone(rs.getString(9));
				 emp.setQq(rs.getString(10));
				 emp.setSalary(rs.getFloat(11));
				 emp.setDepartid(rs.getInt(12));
				  emp.setRole(rs.getString(13));
			}
			 } catch (SQLException e) {
	 
				e.printStackTrace();
			}finally{
				DBOperator.close(rs, ps, conn);
			}
		 return  emp;
	 }
	
	 
}

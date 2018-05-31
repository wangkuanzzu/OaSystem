package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
import pojo.User;
import utils.DBOperator;

public class UserServices {
	public List<User> findAllUsers(){
		List<User> list=new ArrayList<User>();
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
		    ps=conn.prepareStatement("SELECT * from user as u left join department as d on  u.departid=d.toid");
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
	      	list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBOperator.close(rs, ps, conn);
		}
		return list;
	}
	
	 public User getUserbyID(int toid){
		   
		    Connection conn=DBOperator.getConnection();
			User user=new User();
		    PreparedStatement ps=null;
		    ResultSet rs=null;
		   try {
			ps=conn.prepareStatement("select * from user  where  toid=?");//as u inner join department as d
			ps.setInt(1, toid);
			 rs=ps.executeQuery();
			while(rs.next()){		
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
		//		user.setDepartname(rs.getString(15));
			}
		} catch (SQLException e) {
		 
			e.printStackTrace();
		  }finally{
			DBOperator.close(rs, ps, conn);
			 
			}
			return user;
     }
	 
	 public void AltUser(User user){
		 
		 Connection conn=DBOperator.getConnection();
			PreparedStatement ps=null;
		     ResultSet rs=null;
			try {
				ps=conn.prepareStatement("update user set  realname= ?,  email=?, address=?,telphone=?, salary=?,role=? where  toid=?");	
				ps.setString(1, user.getRealname() );
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getAddress() );
				ps.setString(4, user.getTelphone());
				ps.setFloat(5, user.getSalary());
				ps.setString(6, user.getRole() );
			 	ps.setInt(7, user.getToid());
				ps.executeUpdate();
			} catch (SQLException e) {				 
				e.printStackTrace();
			} DBOperator.close(rs, ps, conn);
	 }
	 
	 public void DelUserbyId(int toid){
			Connection conn=DBOperator.getConnection();
	    	PreparedStatement ps=null;
	    	ResultSet rs=null;
	    	try {
				ps=conn.prepareStatement("delete  from user where toid=? ");
				ps.setInt(1, toid);
				ps.executeUpdate();
			} catch (SQLException e) {	 
				e.printStackTrace();
			} finally {
				DBOperator.close(rs, ps, conn);
			}		 
	 }
	 public void AddUser(User user){
		  Connection conn=DBOperator.getConnection();
		  PreparedStatement ps=null;
		  ResultSet rs=null;
		  try {	
			  ps=conn.prepareStatement("insert into user (username,realname,password,sex,email,address,telphone,salary,departid,role) values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, user.getUsername());
			   ps.setString(2,user.getRealname());			
				ps.setString(3, user.getPassword());
				ps.setString(4,user.getSex());
				ps.setString(5,user.getEmail());
				ps.setString(6,user.getAddress());			
				ps.setString(7,user.getTelphone());
				ps.setFloat(8, user.getSalary());
				ps.setInt(9,user.getDepartid());
				ps.setString(10,user.getRole());
				ps.executeUpdate();
		} catch (SQLException e) {		 
			e.printStackTrace();
		}DBOperator.close(rs, ps, conn);
	 }
	 
	 
		public List<User> findUserByDepat(int toid){
			List<User> list=new ArrayList<User>();
			Connection conn=DBOperator.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
			    ps=conn.prepareStatement("SELECT * from user as u   inner join department as d on u.departid=d.toid  and   u.departid=?");
			    ps.setInt(1, toid);
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
		      	list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBOperator.close(rs, ps, conn);
			}
			return list;
		}
		
		
		public List<User> SearchUser(int toid,String key){
			List<User> list=new ArrayList<User>();
			Connection conn=DBOperator.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
			    ps=conn.prepareStatement("SELECT * from user as u   inner join department as d on u.departid=d.toid  and   u.departid=?  and  u.realname=?");
			    ps.setInt(1, toid);
			    ps.setString(2, key);
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
		      	list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBOperator.close(rs, ps, conn);
			}
			return list;
		}
		
		public List<User> searchUser(String name){
			List<User> list=new ArrayList<User>();
			Connection conn=DBOperator.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
			    ps=conn.prepareStatement("SELECT * from user as u inner join department as d on  u.departid=d.toid and u.realname=?");
			    ps.setString(1, name);
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
		      	list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBOperator.close(rs, ps, conn);
			}
			return list;
}
      public void AltAccount(String username,String password,int toid){
    	  
    	  Connection conn=DBOperator.getConnection();
			PreparedStatement ps=null;
		     ResultSet rs=null;
			try {
				ps=conn.prepareStatement("update user set  username= ?,  password=? where  toid=?");	
				ps.setString(1,username  );
				ps.setString(2, password );
				ps.setInt(3,toid);		 
				ps.executeUpdate();
			} catch (SQLException e) {				 
				e.printStackTrace();
			} DBOperator.close(rs, ps, conn);
    	  
      }
      
      public void AltMySelf(User user){
 		 
 		 Connection conn=DBOperator.getConnection();
 			PreparedStatement ps=null;
 		     ResultSet rs=null;
 			try {
 				ps=conn.prepareStatement("update user set  username= ?, birthday=? ,email=?, address=?,telphone=?, qq=?,sex=?  where  toid=?");	
 				ps.setString(1,user.getUsername() );
 				ps.setString(2,user.getBirthday()  );
 				ps.setString(3,user.getEmail()  );
 				ps.setString(4,user.getAddress()  );
 				ps.setString(5, user.getTelphone() );
 				ps.setString(6, user.getQq());
 			 	ps.setString(7, user.getSex());
 			 	ps.setInt(8, user.getToid());
 				ps.executeUpdate();
 			} catch (SQLException e) {				 
 				e.printStackTrace();
 			} DBOperator.close(rs, ps, conn);
		
    }
}    
      
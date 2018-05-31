package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pojo.Orders;
import utils.DBOperator;

public class OrderService {

	public List<Orders>  findAllOrder(){
		List<Orders> list=new ArrayList<Orders>();
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
		    ps=conn.prepareStatement("SELECT * from (orders  as o left join product as p on o.productid=p.toid) LEFT JOIN  user as u  on o.userid=u.toid ");
			rs=ps.executeQuery();
		 while(rs.next()){
			 Orders order=new Orders();
			 order.setToid(rs.getInt(1));
			 order.setCustname(rs.getString(2));
			 order.setCustaddress(rs.getString(3));
			 order.setCustphone(rs.getString(4));
			 order.setCustemail(rs.getString(5));
			 order.setOrdertime(rs.getString(6));
			 order.setProductid(rs.getInt(7));
			 order.setProductcount(rs.getInt(8));
			 order.setMoney(rs.getFloat(9));
			 order.setCreatetime(rs.getString(10));
			 order.setUserid(rs.getInt(11));
			 order.setProducname(rs.getString(13));
			 order.setSaleman(rs.getString(16));
			 list.add(order);
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBOperator.close(rs, ps, conn);
		}	
		 return list;
	}
	
	public void AddOrders(Orders order){
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("insert into orders (custname,custaddress ,custphone ,custemail ,ordertime , productid, productcount, money,createtime ,userid)values(?,?,?,?,?,?,?,?,?,?)");
		    ps.setString(1, order.getCustname());
		    ps.setString(2, order.getCustaddress());
		    ps.setString(3, order.getCustphone());
		    ps.setString(4, order.getCustemail());
		    ps.setString(5, order.getOrdertime());
		    ps.setInt(6, order.getProductid());
		    ps.setInt(7, order.getProductcount());
		    ps.setFloat(8, order.getMoney());
		    ps.setString(9, order.getCreatetime());
		    ps.setInt(10, order.getUserid());
		    ps.executeUpdate();
		
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}finally{
			DBOperator.close(rs, ps, conn);
		}
	}
	
		public  Orders  getOrdersbyId(int toid){
			Connection conn=DBOperator.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			Orders order=new Orders();
			try {
				ps=conn.prepareStatement("select * from orders where toid=?");
				ps.setInt(1, toid);
			    rs=ps.executeQuery();
				while(rs.next()){
				order.setToid(rs.getInt(1));
				order.setCustname(rs.getString(2));	
				order.setCustaddress(rs.getString(3));
				order.setCustphone(rs.getString(4));
				order.setCustemail(rs.getString(5));
				order.setOrdertime(rs.getString(6));
				order.setProductid(rs.getInt(7));
				order.setProductcount(rs.getInt(8));
				order.setCreatetime(rs.getString(10));
				order.setUserid(rs.getInt(11));
				
				}
			} catch (SQLException e) {
			 
				e.printStackTrace();
			}	
			return order;
		}	
  public void AltOrder(Orders order){

	  Connection conn=DBOperator.getConnection();
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  try {
		ps=conn.prepareStatement
		  ("update orders set custname=? ,custaddress =?,custphone=?,  custemail =?,ordertime =?,productid =?,productcount =?,money=?, createtime=?, userid=? where toid=?");
         ps.setString(1, order.getCustname());
         ps.setString(2, order.getCustaddress());
         ps.setString(3, order.getCustphone());
         ps.setString(4, order.getCustemail());
         ps.setString(5, order.getOrdertime());
         ps.setInt(6, order.getProductid());
         ps.setInt(7, order.getProductcount());
         ps.setFloat(8, order.getMoney());
         ps.setString(9, order.getCreatetime());
         ps.setInt(10, order.getUserid());
         ps.setInt(11, order.getToid());
         ps.executeUpdate();
      
	  } catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBOperator.close(rs, ps, conn);
	  }  
   }	
  
  public  void delOrder(int toid){
	  Connection conn=DBOperator.getConnection();
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  try {
		ps=conn.prepareStatement("delete from orders where toid=?");
		ps.setInt(1, toid);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBOperator.close(rs, ps, conn);
	}
  } 
  public List<Orders> findOrderbyDepart(int departid){
	  List<Orders> list=new ArrayList<Orders>();
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
		    ps=conn.prepareStatement("SELECT * from (  orders  as o   left join product as p on o.productid=p.toid) LEFT JOIN  user as u  on o.userid=u.toid WHERE u.departid=? ");
		     ps.setInt(1, departid);
		    rs=ps.executeQuery();
		 while(rs.next()){
			 Orders order=new Orders();
			 order.setToid(rs.getInt(1));
			 order.setCustname(rs.getString(2));
			 order.setCustaddress(rs.getString(3));
			 order.setCustphone(rs.getString(4));
			 order.setCustemail(rs.getString(5));
			 order.setOrdertime(rs.getString(6));
			 order.setProductid(rs.getInt(7));
			 order.setProductcount(rs.getInt(8));
			 order.setMoney(rs.getFloat(9));
			 order.setCreatetime(rs.getString(10));
			 order.setUserid(rs.getInt(11));
			 order.setProducname(rs.getString(13));
			 order.setSaleman(rs.getString(18));
			 list.add(order);
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBOperator.close(rs, ps, conn);
		}	
		 return list;  
  }
  
  
  public List<Orders> findMyOrder(int userid){
	  List<Orders> list=new ArrayList<Orders>();
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
		    ps=conn.prepareStatement("SELECT * from (  orders  as o   left join product as p on o.productid=p.toid) LEFT JOIN  user as u  on o.userid=u.toid WHERE o.userid=? ");
		     ps.setInt(1, userid);
		    rs=ps.executeQuery();
		 while(rs.next()){
			 Orders order=new Orders();
			 order.setToid(rs.getInt(1));
			 order.setCustname(rs.getString(2));
			 order.setCustaddress(rs.getString(3));
			 order.setCustphone(rs.getString(4));
			 order.setCustemail(rs.getString(5));
			 order.setOrdertime(rs.getString(6));
			 order.setProductid(rs.getInt(7));
			 order.setProductcount(rs.getInt(8));
			 order.setMoney(rs.getFloat(9));
			 order.setCreatetime(rs.getString(10));
			 order.setUserid(rs.getInt(11));
			 order.setProducname(rs.getString(13));
			 order.setSaleman(rs.getString(18));
			 list.add(order);
		 }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBOperator.close(rs, ps, conn);
		}	
		 return list;  
   }
}

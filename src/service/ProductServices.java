package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Product;
import utils.DBOperator;

public class ProductServices {

	public List<Product> getProductList(){
	
		 List<Product>  list=new ArrayList<Product>();
		   Connection conn = DBOperator.getConnection();
			PreparedStatement ps = null;
			ResultSet rs=null;	
			try {
				ps = conn.prepareStatement("select * from product ");
			    rs=ps.executeQuery();
			 while (rs.next()){	     
				 Product pro=new Product();
				 pro.setToid(rs.getInt(1));
		    	 pro.setProductname(rs.getString(2));
		    	 pro.setPrice(rs.getFloat(3));
		    	 list.add(pro);
			}
			 } catch (SQLException e) {
	 
				e.printStackTrace();
			}finally{
				DBOperator.close(rs, ps, conn);
			 
			}
         return  list;
	}	
	
       public Product getprobyID(int toid){
			    Product pro=new Product();
			    Connection conn=DBOperator.getConnection();
			    PreparedStatement ps=null;
			    ResultSet rs=null;
			   try {
				ps=conn.prepareStatement("select * from product where toid=?");
				ps.setInt(1, toid);
				 rs=ps.executeQuery();
				while(rs.next()){
					pro.setToid(rs.getInt(1));
					pro.setProductname(rs.getString(2));
					pro.setPrice(rs.getFloat(3));
				}
			} catch (SQLException e) {
			 
				e.printStackTrace();
			  }finally{
				DBOperator.close(rs, ps, conn);
				 
				}
				return pro;
    }

    public void AltProduct(Product pro){
			Connection conn=DBOperator.getConnection();
			PreparedStatement ps=null;
		     ResultSet rs=null;
			try {
				ps=conn.prepareStatement("update product  set productname=?, price=? where toid= ?");	
				ps.setString(1, pro.getProductname());
				ps.setFloat(2, pro.getPrice());
				ps.setInt(3, pro.getToid());
				ps.executeUpdate();
			} catch (SQLException e) {				 
				e.printStackTrace();
			} DBOperator.close(rs, ps, conn);
      }
    
	  public void delProductbyId(int toid){
			    	Connection conn=DBOperator.getConnection();
			    	PreparedStatement ps=null;
			    	try {
						ps=conn.prepareStatement("delete  from product where toid=? ");
						ps.setInt(1, toid);
						ps.executeUpdate();
					} catch (SQLException e) {	 
						e.printStackTrace();
					} 
			  }
	  
	  public void AddProduct(Product pro){
		  Connection conn=DBOperator.getConnection();
		  PreparedStatement ps=null;
		  try {
				ps=conn.prepareStatement("insert into product (productname,price) values(?,?)");
				ps.setString(1,pro.getProductname());
				ps.setFloat(2, pro.getPrice());
				ps.executeUpdate();
		} catch (SQLException e) {		 
			e.printStackTrace();
		}
	  }
 }

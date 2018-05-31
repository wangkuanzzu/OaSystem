package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Department;
import pojo.Product;
import utils.DBOperator;

public class DepartService {

	public List<Department> findAllDepart(){
		

		 List<Department>  list=new ArrayList<Department>();
		   Connection conn = DBOperator.getConnection();
			PreparedStatement ps = null;
			ResultSet rs=null;	
			try {
				ps = conn.prepareStatement("select * from department as d left join user as u on d.managerid=u.toid");
			    rs=ps.executeQuery();
			 while (rs.next()){	     
				 Department depart=new Department();
				 depart.setToid(rs.getInt(1));
				 depart.setDepartmentname(rs.getString(2));
				 depart.setManagerid(rs.getInt(3));
			 	 depart.setManager(rs.getString(7)); 
		    	 list.add(depart);
			}
			 } catch (SQLException e) {
	 
				e.printStackTrace();
			}finally{
				DBOperator.close(rs, ps, conn);	 
			}
        return  list;
	}	
	
	public Department getDepartbyId(int toid){
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Department  depart=new Department();
		try {
			ps=conn.prepareStatement("select * from department   where  toid=?");
			ps.setInt(1, toid);
			rs=ps.executeQuery();
			while(rs.next()){
				
				depart.setToid(rs.getInt(1));
				depart.setDepartmentname(rs.getString(2));
			    depart.setManagerid(rs.getInt(3));
				
			}
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}	
		return depart;
	}
	public void AltDepart(Department depart){
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("update department set departmentname=?,managerid=? where toid=?");
			ps.setString(1, depart.getDepartmentname());
			ps.setInt(2, depart.getManagerid());
			ps.setInt(3, depart.getToid());
			ps.executeUpdate();
		} catch (SQLException e) { 	 
			e.printStackTrace();
		}finally {
			DBOperator.close(rs, ps, conn);
		}
	}
	
	public void DelDepart(int toid){
		
		Connection conn=DBOperator.getConnection();
    	PreparedStatement ps=null;
    	try {
			ps=conn.prepareStatement("delete  from department where toid=? ");
			ps.setInt(1, toid);
			ps.executeUpdate();
		} catch (SQLException e) {	 
			e.printStackTrace();
		} 
	}
	
	public void AddDepart(Department depart){
		Connection conn=DBOperator.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("insert into department (departmentname,managerid) values(?,?)");
			ps.setString(1, depart.getDepartmentname());
			ps.setInt(2, depart.getManagerid());
			ps.executeUpdate();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}finally{
			DBOperator.close(rs, ps, conn);
		}	
	}
}


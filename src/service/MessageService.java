package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;

 
import pojo.Message;
import utils.DBOperator;

public class MessageService {

public List<Message> findMyMsg(int toid){
	 List<Message>  list=new ArrayList<Message>();
	   Connection conn = DBOperator.getConnection();
		PreparedStatement ps = null;
		 ResultSet rs=null;
		try {
			ps = conn.prepareStatement("select * from message as m inner join user as u on m.from_id=u.toid where m.to_id=? ");
		     ps.setInt(1, toid);
			rs=ps.executeQuery();
		 while (rs.next()){	     
			 Message msg=new Message();
			 msg.setToid(rs.getInt(1));
			 msg.setFrom_id((rs.getInt(2)));
			 msg.setTo_id(rs.getInt(3));
		     msg.setContent(rs.getString(4));
		     msg.setIsread(rs.getString(5));
		     msg.setSendname(rs.getString(9));
		     list.add(msg);
		}
		 } catch (SQLException e) {

			e.printStackTrace();
		}finally{
			DBOperator.close(rs, ps, conn);	 
		}
   return  list;
     }

   public void DelMessage(int toid){
	   Connection conn=DBOperator.getConnection();
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   try {
		ps=conn.prepareStatement("delete from message where toid=?");
		ps.setInt(1, toid);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBOperator.close(rs, ps, conn);
	} 
  }
   public void SendMsg(int userid,int Sendto,String msg){
	   Connection conn=DBOperator.getConnection();
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   try {
		ps=conn.prepareStatement("insert into message (from_id,to_id,content,isread) values(?,?,?,?)");
		ps.setInt(1,userid );
		ps.setInt(2, Sendto);
		ps.setString(3,msg );
	    ps.setString(4, "0");
	    ps.executeUpdate();
	} catch (SQLException e) {
 
		e.printStackTrace();
	}DBOperator.close(rs, ps, conn);
	   
   }
     public void Read( int toid){
	   Connection conn=DBOperator.getConnection();
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   try {
		ps=conn.prepareStatement("update  message as m set m.isread='1'  where toid=?");
		ps.setInt(1, toid);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBOperator.close(rs, ps, conn);
	} 
	   
	   
   }
   public Message findMsgbyId(int toid){
	   Connection conn=DBOperator.getConnection();
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   Message message=new Message();
	   try {
		ps=conn.prepareStatement("select * from message as m inner join user as u on m.from_id=u.toid where m.toid=? ");
	     ps.setInt(1, toid);
	     rs=ps.executeQuery();
	     if (rs.next()){
	    	 message.setToid(rs.getInt(1));
	    	 message.setFrom_id(rs.getInt(2));
	    	 message.setTo_id(rs.getInt(3));
	    	 message.setContent(rs.getString(4));
	    	 message.setIsread(rs.getString(5));
	    	 message.setSendname(rs.getString(9));    	 
	     }
	   } catch (SQLException e) {
	 
		e.printStackTrace();
	}
	   
	   return message;
   }
   
   public int unReadCount(int toid){
	   Connection conn=DBOperator.getConnection();
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   int count=0;
	   try {
		ps=conn.prepareStatement("select COUNT(m.isread='0') from message as m WHERE m.isread='0' and m.to_id=?");
		ps.setInt(1, toid);
		rs=ps.executeQuery();
		if(rs.next()){
			count=rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		DBOperator.close(rs, ps, conn);
	}    
	   return count;
   }
   
}
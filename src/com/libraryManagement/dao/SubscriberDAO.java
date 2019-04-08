package com.libraryManagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.Books;
import com.libraryManagement.model.Login;
import com.libraryManagement.model.Subscriber;
import com.libraryManagement.model.SubscriberInfo;
import com.libraryManagement.util.ConnectionUtil;

public class SubscriberDAO {

	public int registerSubscriber(Subscriber subscriber) throws libraryManagementException
	{
		String query= "insert into subscriber(name,phonenumber,email_id) values(?,?,?)";
		Connection connObj=null;
		PreparedStatement stmt =null;
		int generatedId=0;
		ResultSet rs=null;
		try {
			connObj=ConnectionUtil.getConnection();
			stmt=connObj.prepareStatement(query);
			
			stmt.setString(1, subscriber.getSubscriberName());
			stmt.setLong(2, subscriber.getPhoneNumber());
			stmt.setString(3, subscriber.getEmailId());
			
			stmt.executeUpdate();
			rs=stmt.getGeneratedKeys();
			if(rs.next())
			{ generatedId = rs.getInt(1);}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("error in updating subscriber details");
		}
		finally{
			if(stmt!=null)
			{try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating subscriber details");
			}}
			if(connObj!=null)
			{try {
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating subscriber details");
			}}
		}
		
		return generatedId;
	}
	
	
	 public ResultSet fetchSubscribers(String sName) throws libraryManagementException
	 {
		 String query = "select * from subscriber s where s.name like ?";
		 ResultSet rs=null;
		 Connection conn= null;
		 PreparedStatement stmt = null;
		 List<Subscriber> list= new ArrayList<>();
		 try {
			conn=ConnectionUtil.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, "%"+sName+"%");
			rs=stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new libraryManagementException("error in fetching books list");
		}
		 
		 return rs;
		 
	 }
	 
	 
	 public List<Subscriber> fetchAllSubscribers() throws libraryManagementException
	 {
		 String query = "select * from subscriber s";
		 ResultSet rs=null;
		 Connection conn= null;
		 PreparedStatement stmt = null;
		List<Subscriber> list = new ArrayList<>();
		 try {
			conn=ConnectionUtil.getConnection();
			stmt=conn.prepareStatement(query);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				int sId= rs.getInt(1);
				String sName= rs.getString(2);
				long sPhone= rs.getLong(3);
				String sEmail= rs.getString(4);
				
				Subscriber subscriber = new Subscriber(sId, sName, sPhone, sEmail);
				list.add(subscriber);
			
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new libraryManagementException("error in fetching Subscribers list");
		}
		 
		 return list;
		 
	 }
	 
	 public boolean checkSubscriber(String  sName,String phoneNumber) throws libraryManagementException 
		{
			Connection connObj=null;
			PreparedStatement stmt=null;
			ResultSet rs= null;
			boolean flag=false;
			
			String query ="select * from subscriber where name=? and phonenumber=?";
			try {
				connObj=ConnectionUtil.getConnection();
				stmt=connObj.prepareStatement(query);
				
				stmt.setString(1, sName);
				stmt.setString(2, phoneNumber);
				rs=stmt.executeQuery();
				if(rs.next())
				{
					
				  flag=true;
				  
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("Error in SQL query"+e.getMessage());
			}
			finally{
				if(rs!=null)
				{try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new libraryManagementException("Error in Subscriber"+e.getMessage());
				}}
				if(stmt!=null)
				{try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new libraryManagementException("Error in Subscriber"+e.getMessage());
				}
				}
				
				if(connObj!=null)
				{try {
					connObj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new libraryManagementException("Error in LOGIN"+e.getMessage());
				}		
				
			}
			
		}
			
			return flag;

	}
	 
	 public List<Subscriber> fetchAllPendingSubscribers(int bookISBN) throws libraryManagementException
	 {
		 String query = "select s.* from subscriber s inner join book_issued bi on s.s_id=bi.subscriber_s_id where bi.return_date is null and bi.Books_ISBN=?";
		 ResultSet rs=null;
		 Connection conn= null;
		 PreparedStatement stmt = null;
		List<Subscriber> list = new ArrayList<>();
		 try {
			conn=ConnectionUtil.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setInt(1, bookISBN);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				int sId= rs.getInt(1);
				String sName= rs.getString(2);
				long sPhone= rs.getLong(3);
				String sEmail= rs.getString(4);
				
				Subscriber subscriber = new Subscriber(sId, sName, sPhone, sEmail);
				list.add(subscriber);
			
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new libraryManagementException("error in fetching Subscribers list");
		}
		 
		 return list;
		 
	 }
	 
	
	 public List<SubscriberInfo> fetchSubscribersInfo(String subName) throws libraryManagementException
	 {
		 String query = "select s.*,group_concat(b.name) as books from book_issued bi inner join Books b on bi.Books_ISBN=b.ISBN right join subscriber s on s.s_id=bi.subscriber_s_id where s.name like ? or s.s_id like ? group by s.s_id";
		 ResultSet rs=null;
		 Connection conn= null;
		 PreparedStatement stmt = null;
		List<SubscriberInfo> list = new ArrayList<>();
		 try {
			conn=ConnectionUtil.getConnection();
			stmt=conn.prepareStatement(query);
		
	
			stmt.setString(1, "%"+subName+"%");
			stmt.setString(2, "%"+subName+"%");
			
			rs=stmt.executeQuery();
			while(rs.next())
			{
				int sId= rs.getInt(1);
				String sName= rs.getString(2);
				long sPhone= rs.getLong(3);
				String sEmail= rs.getString(4);
				String booksIssued=rs.getString(5);
				Subscriber subscriber = new Subscriber(sId, sName, sPhone, sEmail);
				
				SubscriberInfo sInfo = new SubscriberInfo(subscriber, booksIssued);
				list.add(sInfo);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new libraryManagementException("error in fetching Subscribers list");
		}
		 
		 return list;
		 
	 }
	 
	 
	 public boolean updateSubscriberDetails(int sID,String sName,long phone,String sMail) throws libraryManagementException
		{
		 
		 boolean flag=false;
			String query= "update subscriber set name=? ,phonenumber=?,email_id=? where s_id=?;";
			
			Connection connObj=null;
			PreparedStatement stmt =null;
			PreparedStatement stmt1 =null;
			try {
				connObj=ConnectionUtil.getConnection();
				stmt=connObj.prepareStatement(query);
				
				stmt.setString(1,sName);
				stmt.setLong(2,phone );
				stmt.setString(3,sMail);
				stmt.setInt(4,sID);
				stmt.executeUpdate();
				
			
				flag=true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating book details"+e);
			}
			finally{
				if(stmt!=null)
				{try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new libraryManagementException("error in updating book details");
				}}
				if(connObj!=null)
				{try {
					connObj.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new libraryManagementException("error in updating book details");
				}}
			}
			
			return flag;
		}
	 
	
}

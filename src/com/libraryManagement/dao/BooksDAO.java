package com.libraryManagement.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.Books;
import com.libraryManagement.util.ConnectionUtil;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class BooksDAO {
	
	
	public void registerBooks(Books books) throws libraryManagementException
	{
		String query= "insert into books values(?,?,?,?)";
		Connection connObj=null;
		PreparedStatement stmt =null;
		try {
			connObj=ConnectionUtil.getConnection();
			stmt=connObj.prepareStatement(query);
			stmt.setInt(1,books.getBooksIsbn());
			stmt.setString(2,books.getName());
			Date date = java.sql.Date.valueOf(books.getPubDate());
			stmt.setDate(3,date);
			stmt.setInt(4,books.getQuantity() );
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("error in updating book details");
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
		
		
	}

	 public ResultSet fetchBooksByname(String bName) throws libraryManagementException
	 {
		 String query = "select * from books b inner join book_author ba inner join author a on b.ISBN=ba.Books_ISBN and ba.author_id=a.id where b.name like ?";
		 
		 ResultSet rs=null;
		 Connection conn= null;
		 PreparedStatement stmt = null;
		
		 try {
			conn=ConnectionUtil.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, "%"+bName+"%");
			rs=stmt.executeQuery();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new libraryManagementException("error in fetching books list");
		}
		 
		 return rs;
		 
	 }
	 
	 public List<Books> fetchAllbooks() throws libraryManagementException
	 {
		 String query = "select * from books ";
		 ResultSet rs=null;
		 Connection conn= null;
		 PreparedStatement stmt = null;
		 List<Books> list= new ArrayList<Books>();
		 try {
				conn=ConnectionUtil.getConnection();
				stmt=conn.prepareStatement(query);
			
				rs=stmt.executeQuery();
				while(rs.next())
				{
					int bookIsbn=rs.getInt("ISBN");
					String bookName = rs.getString("name");
					
					Date bDate=rs.getDate("pub_date");
					LocalDate bookDate=LocalDate.parse(bDate.toString()) ;
					
					int bookQuantity=rs.getInt("quantity");
					
					Books book = new Books(bookIsbn, bookName, bookDate, bookQuantity);
					
					list.add(book);
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			throw new libraryManagementException("error in fetching books list");
			}
			 return list;
	 }
	 
	
	 public boolean updateBooksDetails(int bISBN,String bName,LocalDate pDate,int quantity,String aName,String authorName) throws libraryManagementException
		{
		 
		 boolean flag=false;
			String query= "update books set name=?,pub_date=?,quantity=? where ISBN=?";
			String query1="update author set name=? where name like ?";
			Connection connObj=null;
			PreparedStatement stmt =null;
			PreparedStatement stmt1 =null;
			try {
				connObj=ConnectionUtil.getConnection();
				stmt=connObj.prepareStatement(query);
				
				stmt.setString(1,bName);
				Date date = java.sql.Date.valueOf(pDate);
				stmt.setDate(2,date);
				stmt.setInt(3,quantity );
				stmt.setInt(4,bISBN);
				
				stmt.executeUpdate();
				
				stmt1=connObj.prepareStatement(query1);
				stmt1.setString(1,aName);
				stmt1.setString(2, "%"+authorName+"%");
				stmt1.executeUpdate();
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

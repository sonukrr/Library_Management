package com.libraryManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.BookIssued;
import com.libraryManagement.util.ConnectionUtil;

public class BooksIssuedDAO {

	public void registerBooksIssued(BookIssued bookIssued) throws libraryManagementException
	{
		String query= "insert into BookIssued values(?,?)";
		Connection connObj=null;
		PreparedStatement stmt =null;
		try {
			connObj=ConnectionUtil.getConnection();
			stmt=connObj.prepareStatement(query);
			stmt.setInt(1, bookIssued.getIssueId());
			stmt.setDate(2, bookIssued.getIssueDate());
			stmt.setDate(3, bookIssued.getDueDate());
			stmt.setDate(4, bookIssued.getReturnDate());
			stmt.setLong(5, bookIssued.getSubscribersId());
			stmt.setLong(6, bookIssued.getBooksIsbn());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("error in updating booksIssued details");
		}
		finally{
			if(stmt!=null)
			{try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating booksIssued details");
			}}
			if(connObj!=null)
			{try {
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating booksIssued details");
			}}
		}
		
		
	}
	
	
	public boolean issueBook(int sID,int bIsbn,int Quantity) throws libraryManagementException
	{
		String query= "insert into book_issued(issue_date,due_date,subscriber_s_id,Books_ISBN) values (curdate(),adddate(curdate(),interval 10 day),?,?)";
		String pQuery="update Books set quantity=quantity-1 where ISBN=?";
		Connection connObj=null;
		PreparedStatement stmt =null;
		PreparedStatement pstmt =null;
		boolean flag=false;
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			stmt=connObj.prepareStatement(query);
			stmt.setInt(1,sID);
			stmt.setInt(2,bIsbn);
			
			stmt.executeUpdate();
			
			pstmt=connObj.prepareStatement(pQuery);
			pstmt.setInt(1,bIsbn);
			
			pstmt.executeUpdate();
			connObj.commit();
			flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("error in updating booksIssued details");
		}
		finally{
			if(stmt!=null)
			{try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating booksIssued details");
			}}
			if(connObj!=null)
			{try {
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating booksIssued details");
			}}
			
		}
		
		return flag;
	}
	
	
	public boolean returnBook(int sID,int bIsbn,int Quantity) throws libraryManagementException
	{
		String query= "update book_issued set return_date=curdate() where subscriber_s_id=? and Books_ISBN=?";
		String pQuery="update Books set quantity=quantity+1 where ISBN=?";
		Connection connObj=null;
		PreparedStatement stmt =null;
		PreparedStatement pstmt =null;
		boolean flag=false;
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			stmt=connObj.prepareStatement(query);
			stmt.setInt(1,sID);
			stmt.setInt(2,bIsbn);
			
			stmt.executeUpdate();
			
			pstmt=connObj.prepareStatement(pQuery);
			pstmt.setInt(1,bIsbn);
			
			pstmt.executeUpdate();
			connObj.commit();
			flag=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("error in updating booksIssued details");
		}
		finally{
			if(stmt!=null)
			{try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating booksIssued details");
			}}
			if(connObj!=null)
			{try {
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating booksIssued details");
			}}
			
		}
		
		return flag;
	}
	
	

}

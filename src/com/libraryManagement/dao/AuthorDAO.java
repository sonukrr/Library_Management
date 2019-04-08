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
import com.libraryManagement.model.Author;
import com.libraryManagement.model.Books;
import com.libraryManagement.util.ConnectionUtil;

public class AuthorDAO {

	public int registerAuthor(String authorName) throws libraryManagementException
	{
		String query= "insert into author(name) values(?)";
		Connection connObj=null;
		PreparedStatement stmt =null;
		int generatedId=0;
		ResultSet rs = null;
		try {
			connObj=ConnectionUtil.getConnection();
			stmt=connObj.prepareStatement(query);
		
			stmt.setString(1, authorName);
			stmt.executeUpdate();
			
			rs = stmt.getGeneratedKeys();
			if(rs.next())
			{
				generatedId = rs.getInt(1);
			}
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("error in updating author details");
		}
		
		return generatedId;
		
	}
	
	
	 public ResultSet fetchBooksByAuthor(String aName) throws libraryManagementException
	 {
		 String query = "select * from books b inner join book_author ba inner join author a on b.ISBN=ba.Books_ISBN and ba.author_id=a.id where a.name like ?";
		 ResultSet rs=null;
		 Connection conn= null;
		 PreparedStatement stmt = null;
		 List<Books> list= new ArrayList<Books>();
		 try {
			conn=ConnectionUtil.getConnection();
			stmt=conn.prepareStatement(query);
			stmt.setString(1, "%"+aName+"%");
			rs=stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		throw new libraryManagementException("error in fetching books list");
		}
		 
		 return rs;
		 
	 }
	
}

package com.libraryManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.BooksAuthor;
import com.libraryManagement.util.ConnectionUtil;

public class BooksAuthorDAO {

	public void registerBooksAuthor(BooksAuthor booksAuthor) throws libraryManagementException
	{
		String query= "insert into book_author values(?,?)";
		Connection connObj=null;
		PreparedStatement stmt =null;
		try {
			connObj=ConnectionUtil.getConnection();
			stmt=connObj.prepareStatement(query);
			stmt.setInt(1,booksAuthor.getAuthorId());
			stmt.setInt(2, booksAuthor.getBooksIsbn());
			
		
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("error in updating books_author details"+e);
		}
		finally{
			if(stmt!=null)
			{try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating books_author details");
			}}
			if(connObj!=null)
			{try {
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("error in updating books_author details");
			}}
		}
		
		
	}

}

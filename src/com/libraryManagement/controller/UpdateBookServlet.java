package com.libraryManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryManagement.dao.AuthorDAO;
import com.libraryManagement.dao.BooksAuthorDAO;
import com.libraryManagement.dao.BooksDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.Books;
import com.libraryManagement.model.BooksAuthor;
import com.libraryManagement.util.ConnectionUtil;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connObj=null;
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			String authorName = request.getParameter("bookAuthorName");
			
			AuthorDAO authorDAO=new AuthorDAO();
			int authorId=authorDAO.registerAuthor(authorName);
			
			int bookISBN=Integer.parseInt(request.getParameter("bookISBN"));
			
			String bookName=request.getParameter("bookName");
			LocalDate bookPublicationDate=LocalDate.parse(request.getParameter("bookPublicationDate")) ;
			int bookQuantity=Integer.parseInt(request.getParameter("bookQuantity")) ;
		
			Books books = new Books(bookISBN, bookName, bookPublicationDate, bookQuantity);
		    BooksDAO bookDAO = new BooksDAO();
		    bookDAO.registerBooks(books);
		    
		    BooksAuthor booksAuthor =new BooksAuthor(bookISBN, authorId);
		    BooksAuthorDAO bookAuthorDAO = new BooksAuthorDAO();
		    bookAuthorDAO.registerBooksAuthor(booksAuthor);
		    
		    connObj.commit();
		   PrintWriter out = response.getWriter();
		   out.println("Successfully updated book details");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (libraryManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			if(connObj!=null)
			{try {
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
			
		}
		
		
		
	}

}

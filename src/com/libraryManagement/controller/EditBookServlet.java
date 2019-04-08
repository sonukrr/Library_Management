package com.libraryManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryManagement.dao.BooksDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.util.ConnectionUtil;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connObj=null;
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
		
			String bISBN = request.getParameter("bookISBN");
			int bookISBN = Integer.parseInt(bISBN);
			
			String bname = request.getParameter("bookName");
			
			String pDate = request.getParameter("bookPubDate");
			LocalDate pubDate = LocalDate.parse(pDate);
			
			int bQuantity = Integer.parseInt(request.getParameter("bookQuantity"));
			String aName = request.getParameter("authorName");
				
			request.setAttribute("bookISBN", bISBN);
			request.setAttribute("bookName", bname);
			request.setAttribute("bookPubDate", pubDate);
			request.setAttribute("bookQuantity", bQuantity);
			request.setAttribute("authorName",aName);
	
				RequestDispatcher rd=request.getRequestDispatcher("editBookPage.jsp");
				rd.forward(request, response);
			
			
			
		} catch (SQLException e) {
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
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connObj=null;
		PrintWriter out = response.getWriter();
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
	
			int bookISBN=Integer.parseInt(request.getParameter("bookISBN"));
			String bookName=request.getParameter("bookName");
			
			String date=request.getParameter("bookPublicationDate");
			LocalDate pDate=LocalDate.parse(date);
			
			int bookQuantity=Integer.parseInt(request.getParameter("bookQuantity"));
			String authorName=request.getParameter("bookAuthorName");
			String origAuthorName=request.getParameter("origAuthorName");
			BooksDAO bookDao = new BooksDAO();
System.out.println(bookDao.updateBooksDetails(bookISBN, bookName, pDate, bookQuantity, authorName,origAuthorName));
			if(bookDao.updateBooksDetails(bookISBN, bookName, pDate, bookQuantity, authorName,origAuthorName))
					{
			PrintWriter outt=response.getWriter();
				outt.println("successfully updated book details");
					}
			
	
			
		    connObj.commit();
		   
	
			
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

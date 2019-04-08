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

import com.libraryManagement.dao.AuthorDAO;
import com.libraryManagement.dao.BooksAuthorDAO;
import com.libraryManagement.dao.BooksDAO;
import com.libraryManagement.dao.SubscriberDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.Books;
import com.libraryManagement.model.BooksAuthor;
import com.libraryManagement.model.Subscriber;
import com.libraryManagement.util.ConnectionUtil;

/**
 * Servlet implementation class UpdateSubscriberServlet
 */
@WebServlet("/UpdateSubscriberServlet")
public class UpdateSubscriberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSubscriberServlet() {
        super();
        // TODO Auto-generated constructor stub
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
			
			String subscriberName = request.getParameter("sName");
			Long subscriberPhoneNumber=Long.parseLong(request.getParameter("sPhoneNumber"));
			String subsciberEmailId = request.getParameter("sEmailId");
			
			Subscriber subscriber =new Subscriber(0, subscriberName, subscriberPhoneNumber, subsciberEmailId);
			SubscriberDAO subscriberDAO= new SubscriberDAO();
			int subscriberId=subscriberDAO.registerSubscriber(subscriber);
			
		    connObj.commit();
		   PrintWriter out = response.getWriter();
		   out.println("Successfully updated subscriber details");
		   out.println();
		   out.println("Please note your subscriber ID for future references------->  "+subscriberId);
			
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
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connObj=null;
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
		
			String subID = request.getParameter("sID");
			int sID = Integer.parseInt(subID);
			
			String sName = request.getParameter("sName");
			
			String subPhone = request.getParameter("sPhone");
			long sPhone=Long.parseLong(subPhone);
			
			String sMail=request.getParameter("sMail");
				
			request.setAttribute("sID", sID);
			request.setAttribute("sName", sName);
			request.setAttribute("sPhone", sPhone);
			request.setAttribute("sMail", sMail);
		
	
				RequestDispatcher rd=request.getRequestDispatcher("editSubscriberPage.jsp");
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

}

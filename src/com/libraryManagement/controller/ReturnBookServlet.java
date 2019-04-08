package com.libraryManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryManagement.dao.BooksIssuedDAO;
import com.libraryManagement.dao.SubscriberDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.Subscriber;
import com.libraryManagement.util.ConnectionUtil;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Connection connObj=null;
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			String action = request.getParameter("action");
			String bISBN = request.getParameter("bookISBN");
			int bookISBN = Integer.parseInt(bISBN);
			String bName = request.getParameter("bookName");
			String bQuantity = request.getParameter("bookQuantity");
			int bookQuantity=Integer.parseInt(bQuantity);
			
			
			if(action!=null && action.equals("return"))
			{
				List<Subscriber> list = new ArrayList<Subscriber>();
				SubscriberDAO subscriber = new SubscriberDAO();
				list=subscriber.fetchAllPendingSubscribers(bookISBN);
				
				request.setAttribute("bookISBN", bookISBN);
				request.setAttribute("bookQuantity", bookQuantity);
				request.setAttribute("subscriberList", list);
				request.setAttribute("bookName", bName);
				RequestDispatcher rd=request.getRequestDispatcher("returnBookPage.jsp");
				rd.forward(request, response);
			}
			
			
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection connObj=null;
		PrintWriter out = response.getWriter();
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
			String sID = request.getParameter("subscriberId");
			int subscriberId=Integer.parseInt(sID);
	
			int bookISBN=Integer.parseInt(request.getParameter("bookISBNNumber"));
			System.out.println(subscriberId);
			System.out.println(bookISBN);
			int bookQuantity=Integer.parseInt(request.getParameter("bookQuantity"));
		/*	String bookName=request.getParameter("bookName");*/
		
			System.out.println(subscriberId);
			System.out.println(bookISBN);
			System.out.println(bookQuantity);
			
				BooksIssuedDAO bIssuedDAO= new BooksIssuedDAO();
				if(bIssuedDAO.returnBook(subscriberId, bookISBN, bookQuantity))
				{
					out.println("returned book successfully");
				}else
					out.println("unsuccessfull attempt");
		    
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

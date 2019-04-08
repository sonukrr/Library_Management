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

import com.libraryManagement.dao.BooksDAO;
import com.libraryManagement.dao.SubscriberDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.util.ConnectionUtil;

/**
 * Servlet implementation class editSubscriberServlet
 */
@WebServlet("/editSubscriberServlet")
public class editSubscriberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSubscriberServlet() {
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
		
		Connection connObj=null;
		PrintWriter out = response.getWriter();
		try {
			connObj=ConnectionUtil.getConnection();
			connObj.setAutoCommit(false);
	
			int sID=Integer.parseInt(request.getParameter("sID"));
			String sName=request.getParameter("sName");
			String subPhone=request.getParameter("sPhone");
			System.out.println(subPhone);
			long sPhone=Long.parseLong(subPhone);
			String sMail=request.getParameter("sMail");
			
			SubscriberDAO sDAO = new SubscriberDAO();
			if(sDAO.updateSubscriberDetails(sID, sName, sPhone, sMail))
			{
				out.println("successfully updated subscriber details ");
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


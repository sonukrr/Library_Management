package com.libraryManagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.LibraryNotFoundError;

import com.libraryManagement.dao.LoginDetailsDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.Login;
import com.libraryManagement.util.ConnectionUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
	   
		Login login = new Login(userName, password);
		LoginDetailsDAO loginDao=new LoginDetailsDAO();
		
		PrintWriter out = response.getWriter();
		boolean check;
		String page ="loginPage.jsp";
		
		try {
			check = loginDao.loginCheck(login);
			
			if(check)
			{
			
				System.out.println("Successfully logged in");
				page="success.jsp";
			}
			else
			{
				System.out.println("Invalid username or password");
				request.setAttribute("error", "!!Invalid username or password!!");
				
			}
			
			RequestDispatcher rd =request.getRequestDispatcher(page);
			rd.forward(request, response);
			
			
			
		} catch (libraryManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	
	
	
	}

}

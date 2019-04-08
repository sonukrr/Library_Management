package com.libraryManagement.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryManagement.dao.AuthorDAO;
import com.libraryManagement.dao.BooksDAO;
import com.libraryManagement.dao.SubscriberDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.AllBookDetails;
import com.libraryManagement.model.Books;
import com.libraryManagement.model.Subscriber;
import com.libraryManagement.model.SubscriberInfo;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("searchParameter");
		String bookOption = request.getParameter("bookOpt");
		String authorOption = request.getParameter("authorOpt");
		String subscriberOption = request.getParameter("subscriberOpt");

		List<AllBookDetails> list = new ArrayList<>();
		
		if (bookOption != null && bookOption.equals("on")) {
			BooksDAO bookDAO = new BooksDAO();
			try {
				ResultSet rs = null;
			
				rs= bookDAO.fetchBooksByname(name);
			
				try {
					while(rs.next())
					{
					
						
						int bookIsbn=rs.getInt("ISBN");
						String bookName = rs.getString(2);
						
						Date bDate=rs.getDate("pub_date");
						LocalDate bookDate=LocalDate.parse(bDate.toString()) ;
						
						int bookQuantity=rs.getInt("quantity");
						String authorName = rs.getString(8);
					
						
						Books book = new Books(bookIsbn, bookName, bookDate, bookQuantity);
						AllBookDetails allBookDetails = new AllBookDetails(book, authorName);
						list.add(allBookDetails);
						
						
						
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("tableData",list );
				System.out.println(list);
				RequestDispatcher rd = request.getRequestDispatcher("displayBooks.jsp");
				rd.forward(request, response);
				
				
				
			} catch (libraryManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else

		if ( authorOption != null && authorOption.equals("on")) {
			AuthorDAO authorDAO = new AuthorDAO();
			try {

				ResultSet rs = authorDAO.fetchBooksByAuthor(name);
				try {
					while (rs.next()) {
						int bookIsbn = rs.getInt("ISBN");
						String bookName = rs.getString(2);

						Date bDate = rs.getDate("pub_date");
						LocalDate bookDate = LocalDate.parse(bDate.toString());

						int bookQuantity = rs.getInt("quantity");
						String authorName = rs.getString(8);

						Books book = new Books(bookIsbn, bookName, bookDate, bookQuantity);
						AllBookDetails allBookDetails = new AllBookDetails(book, authorName);
						list.add(allBookDetails);

					}
					
					request.setAttribute("tableData",list );
					/*System.out.println(list);*/
					RequestDispatcher rd = request.getRequestDispatcher("displayBooks.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (libraryManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (subscriberOption != null && subscriberOption.equals("on")) {
			SubscriberDAO subscriberDAO = new SubscriberDAO();
			
				List<SubscriberInfo> sList = new ArrayList<>();

				try {               
					sList = subscriberDAO.fetchSubscribersInfo(name);
				} catch (libraryManagementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
					System.out.println(sList);
					request.setAttribute("subList",sList );
					
					RequestDispatcher rd = request.getRequestDispatcher("subscriberDisplayPage.jsp");
					rd.forward(request, response);
			


	
		}}}

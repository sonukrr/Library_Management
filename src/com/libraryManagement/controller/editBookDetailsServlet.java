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

import com.libraryManagement.dao.BooksDAO;
import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.AllBookDetails;
import com.libraryManagement.model.Books;

/**
 * Servlet implementation class editBookDetailsServlet
 */
@WebServlet("/editBookDetailsServlet")
public class editBookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBookDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<AllBookDetails> list= new ArrayList<>();
		BooksDAO book = new BooksDAO();
		ResultSet rs = null;
		try {
			try {
				rs=book.fetchBooksByname("");
			} catch (libraryManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				while(rs.next())
				{
					int booksIsbn=rs.getInt("ISBN");
					String bookName = rs.getString(2);
					
					Date bDate=rs.getDate("pub_date");
					LocalDate bookDate=LocalDate.parse(bDate.toString()) ;
					
					int bookQuantity=rs.getInt("quantity");
					String authorName = rs.getString(8);
					Books b = new Books(booksIsbn, bookName, bookDate, bookQuantity);
					AllBookDetails allBook = new AllBookDetails(b, authorName);
					list.add(allBook);
				}
				
				request.setAttribute("allBookList", list);
				System.out.println(list);
				RequestDispatcher rd = request.getRequestDispatcher("AllBooksPage.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

}
}

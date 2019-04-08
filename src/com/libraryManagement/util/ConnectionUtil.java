package com.libraryManagement.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
	public static Connection getConnection() throws SQLException
	{
		Connection obj = null;
		
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			obj=DriverManager.getConnection("jdbc:mysql://localhost/library_management","root","root");
			if(obj==null)
			{
				System.out.println("no connection ");
			}else
			{
				System.out.println("successfully got connection"+obj);
			}
			
			return obj;
	}
}
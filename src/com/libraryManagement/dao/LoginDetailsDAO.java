package com.libraryManagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.libraryManagement.exception.libraryManagementException;
import com.libraryManagement.model.Login;
import com.libraryManagement.util.ConnectionUtil;

public class LoginDetailsDAO {

	public boolean loginCheck(Login login) throws libraryManagementException 
	{
		Connection connObj=null;
		PreparedStatement stmt=null;
		ResultSet rs= null;
		boolean flag=false;
		
		String query ="select * from login where user_name=? and password=?";
		try {
			connObj=ConnectionUtil.getConnection();
			stmt=connObj.prepareStatement(query);
			
			stmt.setString(1, login.getUserName());
			stmt.setString(2, login.getPassword());
			rs=stmt.executeQuery();
			if(rs.next())
			{
				
			  flag=true;
			  
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new libraryManagementException("Error in LOGIN"+e.getMessage());
		}
		finally{
			if(rs!=null)
			{try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("Error in LOGIN"+e.getMessage());
			}}
			if(stmt!=null)
			{try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("Error in LOGIN"+e.getMessage());
			}
			}
			
			if(connObj!=null)
			{try {
				connObj.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new libraryManagementException("Error in LOGIN"+e.getMessage());
			}		
			
		}
		
	}
		
		return flag;

}}

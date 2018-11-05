package com.capg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.capg.exception.HotelException;
import com.capg.util.DBUtils;
import com.capg.util.Log4jHTMLLayout;

public class UserDAOImpl implements UserDAO {
	
private static Logger log = Logger.getLogger(Log4jHTMLLayout.class);
	
	
	private Connection dbConnection; 

	{
		try {
			dbConnection = DBUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String userVerification(String user_id, String password) throws HotelException {
		
		String loginQuery = "select * from Users where user_id=?";
		String role= "";
		
		try {
			PreparedStatement insertStatement = dbConnection.prepareStatement(loginQuery);
			
			
			insertStatement.setString(1, user_id);
			ResultSet result = insertStatement.executeQuery();
			while(result.next())
			{
			String pswd=result.getString(2);
			
			if(pswd.equals(pswd))
			{
				System.out.println("Valid user..");
				log.info("Valid user..");
				 role= result.getString(3);
				 System.out.println(role);
				return role;
			}
			else{
				System.out.println("\n user id or password is incorrect");
			    return null;
			}  
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
	     	throw new HotelException("Login failed...");
			return null;
		}
		return role;
		
	
	}

	@Override
	public String bookRooms(String hotel_id) throws HotelException {
        
		 
		
		
		return null;
	}

}

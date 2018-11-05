package com.capg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Logger;

import com.capg.beans.BookingDetails;
import com.capg.beans.Hotel;
import com.capg.beans.RoomDetails;
import com.capg.exception.HotelException;
import com.capg.util.DBUtils;
import com.capg.util.Log4jHTMLLayout;

public class AdminDAOImpl implements AdminDAO{
	
	
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
	public String userVerification(String user_id, String password)throws HotelException {
		
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
	public boolean addDetails(Hotel hotel, RoomDetails roomdetails) throws HotelException {
	
        String insertquery1= " insert into Hotel values(?,?,?,?,?) ";
		
		String insertquery2= " insert into RoomDetails values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement insertStatement1 = dbConnection.prepareStatement(insertquery1);
			
			PreparedStatement insertStatement2 = dbConnection.prepareStatement(insertquery2);
			
			
			insertStatement1.setString(1, hotel.getHotel_id());
			insertStatement1.setString(2, hotel.getCity());
			insertStatement1.setString(3, hotel.getHotel_name());
			insertStatement1.setString(4, hotel.getAddress());
			insertStatement1.setString(5, hotel.getDescription());
			insertStatement1.setDouble(6, hotel.getAvg_rate_per_night());
			insertStatement1.setString(7, hotel.getPhone_no1());
			insertStatement1.setString(8, hotel.getPhone_no2());
			insertStatement1.setString(9, hotel.getRating());
			insertStatement1.setString(10,hotel.getEmail());
			insertStatement1.setString(11,hotel.getFax());
			
			
			insertStatement2.setString(1, roomdetails.getHotel_id());
			insertStatement2.setString(2, roomdetails.getRoom_id());
			insertStatement2.setString(3, roomdetails.getRoom_no());
			insertStatement2.setString(4, roomdetails.getRoom_type());
			insertStatement2.setDouble(5, roomdetails.getPer_night_rate());
		    insertStatement2.setString(6, roomdetails.getAvailability());
			
						
			
			
			int rows1 = insertStatement1.executeUpdate();
			int rows2=  insertStatement2.executeUpdate();
			
			if((rows1 > 0) && (rows2>0))
			{
				System.out.println("Details Added succesfully...");
				log.info("Added a row in db now...");
				
				return true;
			}
				
				
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw new HotelException("Failed to add details");
			
		}
	
		
	}



    @Override
	public boolean updateDetails(RoomDetails roomdetails) throws HotelException {
       
		 String updatequery= "update RoomDetails Set  room_no=?, room_type=?, per_night_rate=?, availability=? where hotel_id=? and room_id=?";
			try{
				PreparedStatement updatestatement= dbConnection.prepareStatement(updatequery);
				updatestatement.setString(1,roomdetails.getRoom_no() );
				updatestatement.setString(2,roomdetails.getRoom_type());
				updatestatement.setDouble(3,roomdetails.getPer_night_rate());
				updatestatement.setString(2,roomdetails.getAvailability());
                updatestatement.setString(4,roomdetails.getHotel_id());
				updatestatement.setString(5,roomdetails.getRoom_id());
				int rows = updatestatement.executeUpdate();
				if(rows > 0)
				{
					System.out.println("Details updated succesfully...");
					log.info("program updated in db now...");
					return true;
				}
					
					
				else 
					return false;
				
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e.getMessage());
				throw new HotelException("Failed to update details");
				
			}

	}




	@Override
	public boolean deleteDetails(String room_id) throws HotelException {
	
		//String deletequery1= " delete from Hotel where hotel_id=?  ";
		String deletequery2= " delete from RoomDetails where room_id=?  ";
        try{
         // PreparedStatement deletestatement1=dbConnection.prepareStatement(deletequery1);
          PreparedStatement deletestatement2=dbConnection.prepareStatement(deletequery2);
          //deletestatement1.setString(1,hotel);
          deletestatement2.setString(1,room_id);

         // deletestatement1.executeQuery();
          deletestatement2.executeQuery();
          System.out.println("\n Room "+room_id+" deleted");
          return true;

        } catch (SQLException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return false;
        	
        }
	
	}




	@Override
	public void bookingDetailsInfo(BookingDetails bookingdetails) throws HotelException {
		
		 String selectquery=" select * from BookingDetails where booking_id=?";
	        try{
	        	PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
	        	//selectstatement.setDate(1,(java.sql.Date)booked_from);
	        	//selectstatement.setDate(2,(java.sql.Date)booked_to);
	        	ResultSet result= selectstatement.executeQuery();
	        	
	        	while(result.next()){
	            String bid= result.getString(1);
	            String rid= result.getString(2);
	            String uid= result.getString(3);
	            Date booked_from= result.getDate(4);
	            Date booked_to= result.getDate(5);
	            int no_of_adults= result.getInt(6);
	            int no_of_children= result.getInt(7);
	            double amount= result.getDouble(8);
	            System.out.println("\n Booking Id: "+ bid);
	            System.out.println("\n Room Id: "+ rid);
	            System.out.println("\n User Id: "+ uid);
	            System.out.println("\n From: "+ booked_from);
	            System.out.println("\n To: "+ booked_to);
	            System.out.println("\n Count of Adults: "+ no_of_adults);
	            System.out.println("\n Count of Children: "+ no_of_children);
	            System.out.println("\n Amount: "+ amount);

	            
	        	}
	        	

	        }catch (SQLException e) {
				e.printStackTrace();
				log.error(e.getMessage());
				throw new HotelException("Unable to fetch Booking Details Information... ");
				
			
	        	
	        }
			
		
	}




	@Override
	public void viewReports(String booking_id, String user_id, Double amount) throws HotelException {

		 String selectquery= "select * from BookingDetails where booking_id=? and user_id=? and amount=?";
	        try{
	        	PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
	        	selectstatement.setString(1, booking_id);
	        	selectstatement.setString(2, user_id);
	        	selectstatement.setDouble(3, amount);
	        	ResultSet result= selectstatement.executeQuery();
	        	while(result.next()){
	        		String book_id= result.getString(1);
	        		String room_id= result.getString(2);
	        		String usr_id= result.getString(3);
	        		Date booked_from= result.getDate(4);
	        		Date booked_to= result.getDate(4);
	        		int no_of_adults= result.getInt(5);
	        		int no_of_children= result.getInt(6);
	        		double amnt=result.getDouble(7);
	        		System.out.println("\n Booking Id: "+ book_id);
	        		System.out.println("\n Room Id: "+ room_id);
	        		System.out.println("\n User Id: "+ usr_id);
	        		System.out.println("\n Booking From: "+ booked_from);
	        		System.out.println("\n Booked To: "+ booked_to);
	        		System.out.println("\n No of Adults: "+ no_of_adults);
	        		System.out.println("\n No of Children : "+ no_of_children);
	        		System.out.println("\n Amount: "+ amnt);
	        		
	        	}
	        	
	        	}catch (SQLException e) {
	    			e.printStackTrace();
	    			log.error(e.getMessage());
	    			throw new HotelException("Unable to retieve status...");
	    			
	    		
	            	
	            }
		
	}
	
	
	@Override
	public int countUsers(String user_id) throws HotelException {
	
		String selectquery= "select * from BookingDetails where user_id=?";
        try{
        	PreparedStatement selectstatement= dbConnection.prepareStatement(selectquery);
        	selectstatement.setString(1, user_id);
        	ResultSet rows= selectstatement.executeQuery();
        	int count=0;
        	while(rows.next()){
        		count++;


        	}
        	return count;
        	
        	}catch (SQLException e) {
    			e.printStackTrace();
    			log.error(e.getMessage());
    			throw new HotelException("Failed to count the number of users...");
    			
    		   
            	
            }

	}
}

	
	
	
	



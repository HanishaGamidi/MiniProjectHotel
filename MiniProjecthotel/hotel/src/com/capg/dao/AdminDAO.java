package com.capg.dao;

import com.capg.beans.BookingDetails;
import com.capg.beans.Hotel;
import com.capg.beans.RoomDetails;
import com.capg.exception.HotelException;

public interface AdminDAO {
	
	public String userVerification(String user_id,String password)throws HotelException;
//	public void retrieveDetails() throws HotelException;
    public boolean addDetails(Hotel hotel,RoomDetails roomdetails)throws HotelException;
	public boolean updateDetails(RoomDetails roomdetails) throws HotelException;
	public boolean deleteDetails(String room_id) throws HotelException;
	public void bookingDetailsInfo(BookingDetails bookingdetails) throws HotelException; 
	public void viewReports(String booking_id,String user_id,Double amount) throws HotelException;
	public int countUsers(String user_id) throws HotelException;
	
	
	
	

}

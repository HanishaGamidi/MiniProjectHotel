package com.capg.dao;

import com.capg.exception.HotelException;

public interface UserDAO {
	
	public String userVerification (String user_id,String password) throws HotelException;
	public String bookRooms(String user_id) throws HotelException;
	
	

}

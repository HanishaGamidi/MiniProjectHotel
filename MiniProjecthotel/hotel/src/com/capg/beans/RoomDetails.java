package com.capg.beans;
public class RoomDetails {

	
  private String hotel_id;
  private String room_id;
  private String room_no;
  private String room_type;
  private Double per_night_rate;
  private String availability;



	public RoomDetails(RoomDetails roomdetails) {
		super();
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.room_no = room_no;
		this.room_type = room_type;
		this.per_night_rate = per_night_rate;
		this.availability = availability;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public Double getPer_night_rate() {
		return per_night_rate;
	}
	public void setPer_night_rate(Double per_night_rate) {
		this.per_night_rate = per_night_rate;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	
	
	
}

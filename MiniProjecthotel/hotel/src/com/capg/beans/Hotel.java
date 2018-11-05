package com.capg.beans;

public class Hotel {
	
	String hotel_id;
	String city;
	String hotel_name;
	String address;
	String description;
	Double avg_rate_per_night;
	String phone_no1;
	String phone_no2;
	String rating;
	String email;
	String fax;


	public Hotel(Hotel hotel) {
		super();
		this.hotel_id = hotel_id;
		this.city = city;
		this.hotel_name = hotel_name;
		this.address = address;
		this.description = description;
		this.avg_rate_per_night = avg_rate_per_night;
		this.phone_no1 = phone_no1;
		this.phone_no2 = phone_no2;
		this.rating = rating;
		this.email = email;
		this.fax = fax;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAvg_rate_per_night() {
		return avg_rate_per_night;
	}
	public void setAvg_rate_per_night(Double avg_rate_per_night) {
		this.avg_rate_per_night = avg_rate_per_night;
	}
	public String getPhone_no1() {
		return phone_no1;
	}
	public void setPhone_no1(String phone_no1) {
		this.phone_no1 = phone_no1;
	}
	public String getPhone_no2() {
		return phone_no2;
	}
	public void setPhone_no2(String phone_no2) {
		this.phone_no2 = phone_no2;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	
	

}

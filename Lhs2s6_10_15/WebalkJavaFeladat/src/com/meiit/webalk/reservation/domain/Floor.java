package com.meiit.webalk.reservation.domain;

import java.util.List;

public class Floor {

	private int floorNumber;
	private Hotel hotel;
	private List<Wing> wings;

	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Wing> getWings() {
		return wings;
	}

	public void setWings(List<Wing> wings) {
		this.wings = wings;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	
}

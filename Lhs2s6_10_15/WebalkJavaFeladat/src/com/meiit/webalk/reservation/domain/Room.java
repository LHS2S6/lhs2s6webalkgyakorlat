package com.meiit.webalk.reservation.domain;

public class Room {

	private int number;
	private int beds;
	private boolean balcon;
	private int price;
	private Wing wing;
	
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Wing getWing() {
		return wing;
	}
	public void setWing(Wing wing) {
		this.wing = wing;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
	public boolean isBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}
	
	
}

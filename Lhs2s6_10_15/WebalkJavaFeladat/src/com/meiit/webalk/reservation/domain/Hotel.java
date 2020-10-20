package com.meiit.webalk.reservation.domain;

import java.util.List;

public class Hotel {
	private String name;
	private String adress;
	private int stars;
	private List<Floor> floors;

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", adress=" + adress + ", stars=" + stars + "]";
	}

}

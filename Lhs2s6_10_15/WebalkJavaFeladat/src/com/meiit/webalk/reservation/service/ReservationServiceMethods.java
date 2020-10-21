package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Floor;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.domain.Wing;
import com.meiit.webalk.reservation.domain.WingType;

public class ReservationServiceMethods implements ReservationService {

	BookingPerson bp;
	List<Reservation> reservations = new ArrayList<Reservation>();

	@Override
	public void saveBookingPerson(BookingPerson a) {
		bp = a;

	}

	@Override
	public BookingPerson findBookingPerson() {
		return bp;
	}

	@Override
	public List<Hotel> findAllHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(MakeData());
		return hotels;
	}

	@Override
	public void saveReservation(Reservation r) {
		//Processed represent the reservation status it should be set true during the check out
		r.setProcessed(true);
		reservations.add(r);

	}

	@Override
	public List<Reservation> findAllReservations() {
		return reservations;
	}

	@Override
	public void checkIn() {
		//One person how able to enjoy more than 1 reservation in the same time?
		//we need onli the first element set to true
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setActive(true);
			reservations.get(i).setFrom(LocalDateTime.now());
		}

	}

	@Override
	public void checkOut() {
		//Same as before 
		for (int i = 0; i < reservations.size(); i++) {
			reservations.get(i).setActive(false);
			reservations.get(i).setTo(LocalDateTime.now());
		}

	}

	//Self improvement: This should be in other class calld TestDataFactory or TestDataGenerator etc
	static Hotel MakeData() {
		Hotel hotel = new Hotel();
		hotel.setAdress("Hotelcím");
		hotel.setName("Hilton");
		hotel.setStars(4);

		List<Floor> floors = new ArrayList<Floor>();
		Floor fl1 = new Floor();
		fl1.setFloorNumber(1);
		fl1.setHotel(hotel);

		List<Wing> wings = new ArrayList<Wing>();
		Wing w1 = new Wing();
		w1.setDescription("North");
		w1.setFloor(fl1);

		List<Room> rooms = new ArrayList<Room>();
		Room r1 = new Room();
		r1.setBalcon(true);
		r1.setBeds(2);
		r1.setNumber(1);
		r1.setPrice(BigDecimal.valueOf(500));
		r1.setWing(WingType.NORTH);
		rooms.add(r1);

		Room r2 = new Room();
		r2.setBalcon(true);
		r2.setBeds(4);
		r2.setNumber(2);
		r2.setPrice(BigDecimal.valueOf(1500));
		r2.setWing(WingType.NORTH);
		rooms.add(r2);

		Room r3 = new Room();
		r3.setBalcon(true);
		r3.setBeds(1);
		r3.setNumber(3);
		r3.setPrice(BigDecimal.valueOf(200));
		r3.setWing(WingType.NORTH);
		rooms.add(r3);

		Room r4 = new Room();
		r4.setBalcon(true);
		r4.setBeds(2);
		r4.setNumber(4);
		r4.setPrice(BigDecimal.valueOf(500));
		r4.setWing(WingType.NORTH);
		rooms.add(r4);

		w1.setRooms(rooms);
		wings.add(w1);

		fl1.setWings(wings);
		floors.add(fl1);

		hotel.setFloors(floors);
		return hotel;
	}

}

package com.meiit.webalk.reservation.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.meiit.webalk.reservation.CreateHotelData;
import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;

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
		hotels.add(CreateHotelData.MakeData());
		return hotels;
	}

	@Override
	public void saveReservation(Reservation r) {

		reservations.add(r);

	}

	@Override
	public List<Reservation> findAllReservations() {
		return reservations;
	}

	@Override
	public void checkIn() {
		reservations.get(0).setActive(true);
		reservations.get(0).setFrom(LocalDateTime.now());

	}

	@Override
	public void checkOut() {

		reservations.get(0).setActive(false);
		reservations.get(0).setProcessed(true);
		reservations.get(0).setTo(LocalDateTime.now());
		BigDecimal refund = new BigDecimal("0");
		BigDecimal percent = new BigDecimal("0.1");

		refund = refund.add(reservations.get(0).getAmmount().multiply(percent));
		bp.setBalance(bp.getBalance().add(refund));

	}

}

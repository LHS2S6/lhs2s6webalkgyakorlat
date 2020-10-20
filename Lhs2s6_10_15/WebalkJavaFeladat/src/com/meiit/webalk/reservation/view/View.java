package com.meiit.webalk.reservation.view;

import java.util.List;

import com.meiit.webalk.reservation.domain.*;

public interface View {
	
	BookingPerson readBookingPerson();
	void printWelcomeMessage(BookingPerson a);
	void printBalance(BookingPerson a);
	void printRooms(List<Hotel> a);
	Room selectRoom(List<Hotel> a);
	void printReservationSaved(Reservation a);
	void printNotEnoughBalance(BookingPerson a);
	void printCheckIn(List<Reservation> a);
	void printCheckOut(BookingPerson a, List<Reservation> b);
}

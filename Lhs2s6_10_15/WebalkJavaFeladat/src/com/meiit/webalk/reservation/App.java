package com.meiit.webalk.reservation;

import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.service.ReservationService;
import com.meiit.webalk.reservation.service.ReservationServiceMethods;
import com.meiit.webalk.reservation.view.Checker;
import com.meiit.webalk.reservation.view.View;
import com.meiit.webalk.reservation.view.ViewMethods;

public class App {

	private static ReservationServiceMethods rsm = new ReservationServiceMethods();
	private static ViewMethods vm = new ViewMethods();

	public static void main(String[] args) {

		createBookingPerson();
		book();
		checkIn();
		checkOut();

	}

	private App(ReservationService rs, View v) {

	}

	private static void createBookingPerson() {
		rsm.saveBookingPerson(vm.readBookingPerson());
		vm.printWelcomeMessage(rsm.findBookingPerson());
		vm.printBalance(rsm.findBookingPerson());
	}

	private static void book() {
		do {
			vm.printRooms(rsm.findAllHotels());
			Room r = vm.selectRoom(rsm.findAllHotels());
			if (Checker.inputcheck()) {
				if (rsm.findBookingPerson().getBalance().intValue() >= r.getPrice().intValue()) {
					Reservation re = new Reservation();
					re.setId(Integer.valueOf(ViewMethods.menu));
					re.setActive(false);
					re.setAmmount(r.getPrice());
					re.setBookingperson(rsm.findBookingPerson());
					re.setCurrency(rsm.findBookingPerson().getCurrency());
					re.setFrom(null);
					re.setTo(null);
					re.setProcessed(false);
					rsm.findBookingPerson().setBalance(rsm.findBookingPerson().getBalance().subtract(re.getAmmount()));
					rsm.saveReservation(re);
					vm.printReservationSaved(re);
					vm.printDetails(rsm.findAllHotels(), Integer.parseInt(ViewMethods.menu) - 1);
				} else {
					vm.printNotEnoughBalance(rsm.findBookingPerson());
				}

				vm.printBalance(rsm.findBookingPerson());
			}
		} while (Checker.inputcheck());

		vm.printReservedRooms(rsm.findAllHotels(), rsm.findAllReservations());
	}

	private static void checkIn() {
		vm.printCheckIn(rsm.findAllReservations());
		rsm.checkIn();
	}

	private static void checkOut() {
		vm.printCheckOut(rsm.findBookingPerson(), rsm.findAllReservations());
		rsm.checkOut();
		vm.printBalance(rsm.findBookingPerson());
	}

}

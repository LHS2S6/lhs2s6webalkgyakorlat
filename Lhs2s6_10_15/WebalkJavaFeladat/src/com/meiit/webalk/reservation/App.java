package com.meiit.webalk.reservation;

import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;
import com.meiit.webalk.reservation.service.ReservationServiceMethods;
import com.meiit.webalk.reservation.view.Checker;
import com.meiit.webalk.reservation.view.ViewMethods;

public class App {

	public static void main(String[] args) {

		ReservationServiceMethods rsm = new ReservationServiceMethods();
		ViewMethods vm = new ViewMethods();

		rsm.saveBookingPerson(vm.readBookingPerson());
		vm.printWelcomeMessage(rsm.findBookingPerson());
		vm.printBalance(rsm.findBookingPerson());

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
		vm.printCheckIn(rsm.findAllReservations());
		rsm.checkIn();
		vm.printCheckOut(rsm.findBookingPerson(), rsm.findAllReservations());
		rsm.checkOut();
		vm.printBalance(rsm.findBookingPerson());

	}

}

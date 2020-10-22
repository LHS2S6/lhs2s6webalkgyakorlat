package com.meiit.webalk.reservation.view;

import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;

public class ViewMethods implements View {

	BookingPerson bp = new BookingPerson();
	Scanner sc = new Scanner(System.in);
	public static String menu = "";

	@Override
	public BookingPerson readBookingPerson() {
		System.out.println("What's your name?");
		bp.setName(sc.nextLine());
		System.out.println("How much money do you have?");
		String balance = sc.nextLine();
		bp.setBalance(Checker.inputMoney(balance));

		System.out.println("What is your currency? (HUF, EUR or USD)");
		String cur = sc.nextLine();

		bp.setCurrency(Checker.inputCurrency(cur));
		return bp;
	}

	@Override
	public void printWelcomeMessage(BookingPerson a) {
		System.out.println("Welcome " + a.getName());

	}

	@Override
	public void printBalance(BookingPerson a) {
		System.out.println("Your balance is " + a.getBalance().toString() + " " + a.getCurrency().name());

	}

	@Override
	public void printRooms(List<Hotel> a) {
		System.out.println("Where do you want to book? (Choose a number or press q for quit)");
		for (int i = 0; i < a.size(); i++) {

			for (int j = 0; j < a.get(i).getFloors().size(); j++) {

				for (int k = 0; k < a.get(i).getFloors().get(j).getWings().size(); k++) {

					for (int l = 0; l < a.get(i).getFloors().get(j).getWings().get(k).getRooms().size(); l++) {
						System.out.println(l + 1 + ": Hotel name: " + a.get(i).getName() + ", Floor: "
								+ a.get(i).getFloors().get(j).getFloorNumber() + ", Wing: "
								+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getWing()
								+ ", Room Number: "
								+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getNumber()
								+ ", Beds: " + a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getBeds()
								+ ", Room Price: "
								+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l).getPrice());
					}
				}
			}
		}

	}

	@Override
	public Room selectRoom(List<Hotel> a) {
		Room room = null;
		menu = sc.nextLine();
		if (Checker.inputcheck()) {
			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < a.get(i).getFloors().size(); j++) {
					for (int k = 0; k < a.get(i).getFloors().get(j).getWings().size(); k++) {
						for (int l = 0; l < a.get(i).getFloors().get(j).getWings().get(k).getRooms().size(); l++) {
							if (l == Integer.parseInt(menu) - 1) {
								room = a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(l);
							}
						}
					}
				}
			}

		}
		return room;

	}

	@Override
	public void printReservationSaved(Reservation a) {
		System.out.println("The reservation successfully saved!");

	}

	@Override
	public void printNotEnoughBalance(BookingPerson a) {
		System.out.println("Sorry you dont have enough balance! Please choose anoter room!");
	}

	@Override
	public void printCheckIn(List<Reservation> a) {
		System.out.println("Check in");

	}

	@Override
	public void printCheckOut(BookingPerson a, List<Reservation> b) {
		System.out.println("Few days later");
		System.out.println("Check out, Suprise! You are the 100th guest you get a 10% refund");

	}

	public void printReservedRooms(List<Hotel> a, List<Reservation> r) {
		System.out.println("Your reservations:");
		for (int l = 0; l < r.size(); l++) {
			for (int i = 0; i < a.size(); i++) {

				for (int j = 0; j < a.get(i).getFloors().size(); j++) {

					for (int k = 0; k < a.get(i).getFloors().get(j).getWings().size(); k++) {

						System.out.println(a.get(i).getName() + ", Floor: "
								+ a.get(i).getFloors().get(j).getFloorNumber() + ", Wing: " + a.get(i).getFloors()
										.get(j).getWings().get(k).getRooms().get(r.get(l).getId() - 1).getWing()
								+ ", Room Number: "
								+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(r.get(l).getId() - 1)
										.getNumber()
								+ ", Beds: " + a.get(i).getFloors().get(j).getWings().get(k).getRooms()
										.get(r.get(l).getId() - 1).getBeds());

					}
				}
			}

		}
	}

	public void printDetails(List<Hotel> a, int index) {
		System.out.print("Reservation details: ");
		for (int i = 0; i < a.size(); i++) {

			for (int j = 0; j < a.get(i).getFloors().size(); j++) {

				for (int k = 0; k < a.get(i).getFloors().get(j).getWings().size(); k++) {

					System.out.println(a.get(i).getName() + ", Floor: " + a.get(i).getFloors().get(j).getFloorNumber()
							+ ", Wing: " + a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(index).getWing()
							+ ", Room Number: "
							+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(index).getNumber()
							+ ", Beds: "
							+ a.get(i).getFloors().get(j).getWings().get(k).getRooms().get(index).getBeds());

				}
			}
		}
	}

}

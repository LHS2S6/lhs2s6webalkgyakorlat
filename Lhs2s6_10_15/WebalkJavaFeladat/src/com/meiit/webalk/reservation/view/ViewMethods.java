package com.meiit.webalk.reservation.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.BookingPerson;
import com.meiit.webalk.reservation.domain.Currency;
import com.meiit.webalk.reservation.domain.Hotel;
import com.meiit.webalk.reservation.domain.Reservation;
import com.meiit.webalk.reservation.domain.Room;

public class ViewMethods implements View {

	BookingPerson bp = new BookingPerson();
	Scanner sc = new Scanner(System.in);
	public String menu = "";

	@Override
	public BookingPerson readBookingPerson() {
		System.out.println("What's your name?");
		bp.setName(sc.nextLine());
		System.out.println("How much money do you have?");
		String balance = sc.nextLine();
		while (!inputCheckBalance(balance)) {
			System.out.println("How much money do you have?");
			balance = sc.nextLine();
		}
		long lg = Long.parseLong(balance);
		bp.setBalance(BigDecimal.valueOf(lg));

		System.out.println("What is your currency? (HUF, EUR or USD)");
		String cur = sc.nextLine();
		while (!inputCheckCurrency(cur)) {
			System.out.println("Wrong input! Try Again!");
			System.out.println("What is your currency? (HUF, EUR or USD)");
			cur = sc.nextLine();
		}
		bp.setCurrency(Currency.valueOf(cur));
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
		if (inputcheck()) {
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
		Double refund = 0.0;
		for (int i = 0; i < b.size(); i++) {
			refund = refund + (b.get(i).getAmmount().doubleValue() * 0.1);
		}
		a.setBalance(a.getBalance().add(BigDecimal.valueOf(refund)));

	}

	public boolean inputcheck() {
		try {
			Integer.parseInt(menu);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
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

	boolean inputCheckBalance(String input) {
		try {
			Integer.parseInt(input);
			return true;

		} catch (NumberFormatException e) {
			System.out.println("Wrong input! Try Again!");
			return false;
		}
	}

	boolean inputCheckCurrency(String input) {
		boolean b = false;
		switch (input) {
		case "HUF":
			b = true;
			break;
		case "EUR":
			b = true;
			break;
		case "USD":
			b = true;
			;
			break;
		default:
			b = false;
		}
		return b;
	}

}

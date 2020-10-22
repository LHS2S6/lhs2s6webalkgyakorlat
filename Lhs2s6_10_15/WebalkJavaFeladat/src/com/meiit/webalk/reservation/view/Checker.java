package com.meiit.webalk.reservation.view;

import java.math.BigDecimal;
import java.util.Scanner;

import com.meiit.webalk.reservation.domain.Currency;

public class Checker {

	static Scanner sc = new Scanner(System.in);

	public static boolean inputcheck() {
		try {
			Integer.parseInt(ViewMethods.menu);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	static boolean inputCheckBalance(String input) {
		try {
			Integer.parseInt(input);
			return true;

		} catch (NumberFormatException e) {
			System.out.println("Wrong input! Try Again!");
			return false;
		}
	}

	static boolean inputCheckCurrency(String input) {
		boolean b = false;
		if (input.equals("HUF")) {
			b = true;
		} else if (input.equals("EUR")) {
			b = true;
		} else if (input.equals("USD")) {
			b = true;
		} else {
			b = false;
		}

		return b;
	}

	public static BigDecimal inputMoney(String balance) {
		while (!inputCheckBalance(balance)) {
			System.out.println("How much money do you have?");
			balance = sc.nextLine();
		}
		BigDecimal bd = new BigDecimal(balance);
		return bd;

	}

	public static Currency inputCurrency(String cur) {
		while (!inputCheckCurrency(cur)) {
			System.out.println("Wrong input! Try Again!");
			System.out.println("What is your currency? (HUF, EUR or USD)");
			cur = sc.nextLine();
		}
		Currency currency = Currency.valueOf(cur);
		return currency;
	}

}

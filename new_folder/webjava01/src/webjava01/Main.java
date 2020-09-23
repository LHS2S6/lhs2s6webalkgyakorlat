package webjava01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=0;
		int b=0;
		String m;
		System.out.println("Adj meg egy szamot!: ");
		a=beolvas();
		System.out.println("Adj meg egy masikat!: ");
		b=beolvas();
		System.out.println("Add meg a muveleti jelet: ");
		m=beolvasc();
		System.out.println("Az eredmeny:");
		switch (m) {
		case "+" : System.out.println(a+b);
		break;
		case "-" : System.out.println(a-b);
		break;
		case "*" : System.out.println(a*b);
		break;
		case "/" : System.out.println(a/b);
		break;
		}
		
		
	}
	
	public static int beolvas() {
		String x;
		int i=0;
		Scanner sc = new Scanner(System.in);
		x=sc.nextLine();
		Integer.parseInt(x);
		sc.close();
		return i;
	}
	
	public static String beolvasc() {
		String x;
		Scanner sc = new Scanner(System.in);
		x=sc.next();
		sc.close();
		return x;
	}
	
	
	
}

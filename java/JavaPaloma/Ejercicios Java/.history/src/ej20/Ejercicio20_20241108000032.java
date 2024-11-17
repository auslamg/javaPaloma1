package ej20;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		int hours;
		int minutes;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give hours:");
			hours = textScanner.nextInt();     
			
			System.out.println("Give minutes:");
			minutes = textScanner.nextInt();  

			textScanner.close();
		}

		int result = hours * 3600 + minutes * 60;
		System.out.println(result + " seconds");
	}

}

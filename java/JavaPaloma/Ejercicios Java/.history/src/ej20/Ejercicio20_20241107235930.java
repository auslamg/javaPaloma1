package ej20;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		int hours;
		int minutes;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			hours = textScanner.nextInt();     
			
			textScanner.close();
		}

		System.out.println((hours % 2 == 1)? "Es impar" : "No es impar" );
	}

}

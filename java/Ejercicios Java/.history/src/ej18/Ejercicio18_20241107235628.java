package ej18;

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		int n;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();            
		}

		System.out.println((n % 2 == 0)? "Es par" : "No es par" );
	}

}

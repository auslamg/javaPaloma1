package ej19;

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		int n;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();            
		}

		System.out.println((n % 2 == 1)? "Es impar" : "No es impar" );
	}

}

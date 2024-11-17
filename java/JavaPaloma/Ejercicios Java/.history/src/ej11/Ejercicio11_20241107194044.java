package ej11;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		int n;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.err.println("");
		}
		
	}

}

package ej14;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
        int n;
        boolean isPrime = true;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

        for (int i = 1; i <= 10; i++) {
			System.out.println(i + " x " + n + " = " + (i * n));
		}
    }
}

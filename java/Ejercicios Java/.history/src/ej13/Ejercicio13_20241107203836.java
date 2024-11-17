package ej13;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        int n;
        boolean isPrime = false;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

        for (int i = i; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
    }
}

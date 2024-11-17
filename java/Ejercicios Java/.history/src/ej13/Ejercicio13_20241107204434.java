package ej13;

import java.util.Scanner;

public class Ejercicio13 {
    public static void main(String[] args) {
        int n;
        boolean isPrime = true;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

        int i = 2;
        while (i < n) {
            if (n % i == 0) {
                isPrime = false;
            }
            i++;
        }

        System.out.println(isPrime? n + " is prime" : n + " is not prime");
    }
}

package ej15;

import java.util.Scanner;

public class Ejercicio15 {

    public static void main(String[] args) {
        int n;
        boolean isPrime = true;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

        System.out.println(n);
    }

}

package ej25;

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
        int[] vector = {0,0,0,0,0};
		int n;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();     

			textScanner.close();
		}
        int reps = 0;
        for (int i = 0; i < vector.length; i++) {

			if (vector[i] == n) {
				reps++;				
			}
		}
		System.out.println(reps);

	}

}

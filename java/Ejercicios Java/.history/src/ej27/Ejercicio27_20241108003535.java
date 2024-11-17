package ej27;

import java.util.Scanner;

public class Ejercicio27 {

	public static void main(String[] args) {
		int n;
        int[][] matrix = {
			{0,0,0},
			{0,0,0},
			{0,0,0}
			};

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();     

			textScanner.close();
		}
		int totalSum = 0;

        for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				totalSum += matrix[row][col];
			}
		}

		System.out.println(totalSum);
	}

}

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

        boolean lastNumExists = false;
        int lastNum = 0;
        for (int i = 0; i < matrix.length; i++) {

			if (i != 0 && matrix[i] == n) {
                System.out.println(lastNum);
                lastNumExists = true;
			}
            lastNum = i;				
		}

        if (!lastNumExists) {
            System.out.println("Couldn't find elements to the left");
        }
	}

}

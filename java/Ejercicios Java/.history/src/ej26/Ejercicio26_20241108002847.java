package ej26;

import java.util.Scanner;

public class Ejercicio26 {

	public static void main(String[] args) {
		int n;
        int[] vector = {0,1,0,3,0,3};

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();     

			textScanner.close();
		}

        boolean lastNumExists = false;
        int lastNum = 0;
        for (int i = 0; i < vector.length; i++) {

			if (i != 0 && vector[i] == n) {
                System.out.println(lastNum);
			}
            lastNum = i;				
		}
	}

}

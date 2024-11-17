package ej10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		float evenNumSum = 0;
		float evenNumCount = 0;

		try (Scanner textScanner = new Scanner(System.in)) {

			for (int i = 0; i < 5; i++) {
				System.out.println("Give me a new even number");
				float input = textScanner.nextFloat();
				if (input % 2 == 0) {
					evenNumSum += input;
					evenNumCount++;
				}
			}
			textScanner.close();
		}
		if (evenNumCount > 0) {
			System.out.println("The average is " + evenNumSum/evenNumCount);
		}
		else {
			System.out.println("No even numbers given");
		}
		
	}

}

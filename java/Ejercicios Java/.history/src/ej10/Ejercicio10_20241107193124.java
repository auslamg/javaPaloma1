package ej10;

import java.util.Scanner;

public class Ejercicio10 {
	
	int lNums = 0;
	public static void main(String[] args) {
		float allNums = 0;

		try (Scanner textScanner = new Scanner(System.in)) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Give me a new number");
				allNums += textScanner.nextFloat();
			}
			textScanner.close();
		}

		System.out.println("The average is " + allNums/5);
		
	}

}

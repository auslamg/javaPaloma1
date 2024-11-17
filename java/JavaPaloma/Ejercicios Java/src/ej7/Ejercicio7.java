package ej7;
import java.util.Scanner;


public class Ejercicio7 {
	public static  void main(String[] args) {
		int savedValue;
		int newValue = 0;

		try (Scanner textScanner = new Scanner(System.in)) {
			do { 
				savedValue = newValue;
				System.out.println("Give me a new number");
				newValue = textScanner.nextInt();
			} while (newValue > savedValue);
			textScanner.close();
		}
	}

}

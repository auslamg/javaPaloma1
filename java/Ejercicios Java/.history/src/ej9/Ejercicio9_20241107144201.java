package ej9;
import java.util.Scanner;

public class Ejercicio9 {

	int lNums = 0;
	public static void main(String[] args) {
		float allNums = 0;

		Scanner textScanner = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Give me a new number");
			allNums += textScanner.nextFloat();
		}
		System.out.println("The average is " + allNums/5);
	}
}

package ej8;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		int highestNum = 0;
		int thisNum = 0;

		Scanner textScanner = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Give me a new number");
			thisNum = textScanner.nextInt();
			if (thisNum > highestNum) {
				highestNum = thisNum;
			}
		}
		System.out.println("The highest number is " + highestNum);
	}
	
}

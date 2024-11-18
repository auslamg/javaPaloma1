package ej12;
import java.util.Scanner;

public class Ejercicio12a {

	public static void main(String[] args) {
		int n;
        int spaceCount;
        int starCount;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

		for (int i = 1; i <= n; i++) {
            spaceCount = n - i;
            starCount = i;

			System.out.print(" ".repeat(spaceCount));
			System.out.print("*".repeat(starCount));
			System.out.println("");
		}
	}

}

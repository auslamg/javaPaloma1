package ej12;
import java.util.Scanner;

public class Ejercicio12a {

	public static void main(String[] args) {
		int n;
        int total = 0;
        int spaceCount;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

        total = 2 * n - 1;

		for (int i = 1; i <= n; i++) {
            spaceCount = total / 2 - i;

			System.out.print(" ".repeat(spaceCount));
			System.out.print("*".repeat(n - (total - i) ));
			System.out.println("");
		}
	}

}

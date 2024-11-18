package ej12;
import java.util.Scanner;

public class Ejercicio12c {

	public static void main(String[] args) {
		int n;
        int spaceCount;
        int starCount;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

		for (int i = 0; i < n; i++) {

            spaceCount = (i <= n )? (n - i) : (i - n);
            starCount = (i <= n )? (2*i + 1) : (2*i + 1) - 2*(i - n);

			System.out.print(" ".repeat(spaceCount));
			System.out.print("*".repeat(starCount));
			System.out.println("");
		}
	}

}

*****
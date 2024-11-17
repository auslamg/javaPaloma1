package ej12;
import java.util.Scanner;

public class Ejercicio12d {

	public static void main(String[] args) {
		int n;
        int spaceCount = 0;
        int starCount = 0;
        int lineCount;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

        lineCount = 2*n -1;

		for (int i = 0; i < lineCount; i++) {
            if (i < n) {
                spaceCount = n - i;
                starCount = 2*i + 1;
            }
            else {
                spaceCount++;
                starCount -= 2;
            }

			System.out.print(" ".repeat(spaceCount));
			System.out.print("*".repeat(starCount));
			System.out.println("");
		}
	}

}
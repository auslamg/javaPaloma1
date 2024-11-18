package ej12;
import java.util.Scanner;

public class Ejercicio12e {

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
			for (int j = 1; j <= starCount; j++) {
				if (j == 1 || j == starCount) {
					if (i % 2 == 0) {
						System.out.print("*");
					}
					else {
						System.out.print("º");
					}
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}

}
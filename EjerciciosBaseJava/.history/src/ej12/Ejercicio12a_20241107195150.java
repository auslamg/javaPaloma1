package ej12;
import java.util.Scanner;

public class Ejercicio12a {
    int n = 0;

	public void main(String[] args) {

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();
			
			textScanner.close();
		}

		for (int i = 1; i <= n; i++) {
			System.out.print(" ".repeat(n-i));
			System.out.print("*".repeat(i));
			System.out.println("");
		}
	}

    int total() {
        return (2 * n - 1);
    }

}

package ej15;

import java.util.Scanner;

public class Ejercicio15 {

    public static void main(String[] args) {
        int n = 0;
        int m = 0;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();

            while (n > m || m == 0) {
                System.out.println("Give m (m>n):");
                int input = textScanner.nextInt();
                if (input >= n) {
                    m = input;                    
                }
                
                textScanner.close();
            }
            
		}

        for (int i = n; i <= m; i++) {
            System.out.println(i + " times table");
            for (int j = 1; j <= 10; j++) {
                System.out.println(j + " x " + i + " = " + (j * i));
            }
            System.out.println("");
        }

        
    }

}

package ej16;

import java.util.Scanner;

public class Ejercicio16 {
    
    public static void main(String[] args) {
        int n;

		try (Scanner textScanner = new Scanner(System.in)) {
			System.out.println("Give n:");
			n = textScanner.nextInt();            
		}

        switch (n) {
            case 1,3,5,7,8,10,12 -> System.out.println(31);
            case 2 -> System.out.println(28);
            case 4,6,9,11 -> System.out.println(30);
            default -> System.out.println("Non valid number");                             

        }
        
    }

}

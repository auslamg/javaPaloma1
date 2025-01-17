package errores;

import java.util.Scanner;

public class NumeroPrimo {
	public static void main(String[] args) {
		System.out.println("Gabriel Ausejo Lamadrid");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un número: ");
		int numero = scanner.nextInt();
		scanner.close();
		if (esPrimo(numero)) {
			System.out.println(numero + " sí es un número primo.");
		} else {
			System.out.println(numero + " no es un número primo.");
		}
	}

	public static boolean esPrimo(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean esPar(int num) {
		return num % 2 == 0;
	}
}
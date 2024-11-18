package ej2;

public class Ejercicio2 {

	public static void main(String[] args) {

		ForLoop();
		WhileLoop();
		DoWhileLoop();
	}

	static void ForLoop() {
		for (int i = 0; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	static void WhileLoop() {
		int i = 1;
		while (i <= 10) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}

	static void DoWhileLoop() {
		int i = 1;
		do { 
			if (i % 2 == 0) {
				System.out.println(i);
			}
			i++;
		} while (i <= 10);
	}
}

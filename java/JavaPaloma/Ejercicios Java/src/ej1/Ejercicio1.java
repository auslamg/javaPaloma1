package ej1;

public class Ejercicio1 {

	public static void main(String[] args) {

		ForLoop();
		WhileLoop();
		DoWhileLoop();
	}

	static void ForLoop() {
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
	}

	static void WhileLoop() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
	}

	static void DoWhileLoop() {
		int i = 1;
		do { 
			System.out.println(i);
			i++;
		} while (i <= 10);
	}
}

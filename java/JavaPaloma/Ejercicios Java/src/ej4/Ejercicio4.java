package ej4;

public class Ejercicio4 {
    public static void main(String[] args) {

		PrintNumbers();
	}

	static void PrintNumbers() {
		for (int i = 10; i > 0; i--) {
            if (i % 2 == 0) {
                System.out.println(i);                
            }
		}
	}
}

package ej6;

public class Ejercicio6 {
    public static void main(String[] args) {

		PrintNumbers();
	}

	static void PrintNumbers() {
		for (int i = 0; i <= 100; i++) {
            if (i <= 70 || i >=80) {
                System.out.println(i);                
            }
		}
	}
}

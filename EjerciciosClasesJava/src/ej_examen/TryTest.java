package ej_examen;

public class TryTest {

	public static void main(String[] args) {
		try {
			try2();
			m1();
			m2();
			m3();
		} catch (ArithmeticException e) {
			System.out.println("Try exception");
		} finally {
			System.out.println("Try finished");
		}
	}

	static void m1() throws ArithmeticException{
		System.out.println("m1-A");
		System.out.println( (0/0) );
		System.out.println("m1-B");
	}

	static void m2() throws ArithmeticException{
		System.out.println("m2-A");
		System.out.println( (0/0) );
		System.out.println("m2-B");
	}

	public static void try2() {
		try {
			m1();
			m2();
			m3();
		} catch (ArithmeticException e) {
			System.out.println("Try2 exception");
			throw e;
		} finally {
			System.out.println("Try2 finished");
		}
	}

	static void m3() throws ArithmeticException{
		System.out.println("m3-A");
		System.out.println( (0/0) );
		System.out.println("m3-B");
	}
}

package apuntesclase.examenFinal;

public class SeguimientoTryCatchFinally {

	public static void main(String[] args) {
		try {
			try2();
			m1();
		} catch (ArithmeticException e) {
			System.out.println("1-catch");
		} finally {
			System.out.println("1-finally");
		}
	}

	public static void try2() {
		try {
			m1();
		} catch (ArithmeticException e) {
			System.out.println("2-catch");
			throw e;
		} finally {
			System.out.println("2-finally");
		}
	}

	static void m1() throws ArithmeticException {
		System.out.println("m1-A");
		System.out.println((0 / 0));
		System.out.println("m1-B");
	}
}
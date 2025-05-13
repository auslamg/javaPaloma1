package apuntesclase.examenFinal;

public class SeguimientoTryCatchFinally {

	public static void main(String[] args) {
		try {
			try2();
			m1();
		} catch (ArithmeticException e) { //8º 
			System.out.println("1-catch"); //9º SYSOUT
		} finally { //10º
			System.out.println("1-finally"); //11º SYSOUT
		}
	}

	public static void try2() {
		try {
			m1();
		} catch (ArithmeticException e) { //3º
			System.out.println("2-catch"); //4º SYSOUT
			throw e; //5º
		} finally { //6º
			System.out.println("2-finally"); //7º SYSOUT
		}
	}

	static void m1() throws ArithmeticException {
		System.out.println("m1-A"); //1º SYSOUT
		System.out.println((0 / 0)); //2º
		System.out.println("m1-B");
	}
}
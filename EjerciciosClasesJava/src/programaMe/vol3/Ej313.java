package programaMe.vol3;

import java.util.Scanner;
//DONE
public class Ej313 {
	static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        int casos = scn.nextInt();
        scn.nextLine();

        for (int i = 0; i < casos; i++) {
            CasoPrueba();
        }

    }

    @SuppressWarnings("unused")
	private static void CasoPrueba() {
		int saldo = scn.nextInt();
		int variacion = scn.nextInt();

		int saldoFinal = saldo + (variacion);

		if (saldoFinal >= 0) {
			System.out.println("SI");
		}
		else {
			System.out.println("NO");
		}
    }

}

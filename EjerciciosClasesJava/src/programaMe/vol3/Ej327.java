package programaMe.vol3;

import java.util.Scanner;

public class Ej327 {

    static Scanner scn = new Scanner(System.in);
	static boolean running = true;

    public static void main(String[] args) {
		while (running) { 
			CasoPrueba();
		}
    }

    private static void CasoPrueba() {
		int nFormaciones = scn.nextInt();
		if (nFormaciones == 0) {
			running = false;
			return;
		}

		//Todos los numeros hasta lim
		for (int r = 1; r < 1000000000; r++) {
			//Divisores de R
			int dR = 0;

			for (int i = 1; i < r+1; i++) {

				if (r % i == 0) {
					dR++;
				}
				if (dR == nFormaciones) {
					System.out.println(r);
					return;
				}
			}
		}
		System.out.println("+INF");
    }

    
}

package programaMe.vol3;

import java.util.Scanner;
//DONE
public class Ej362 {

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int casos = scn.nextInt();

		for (int i = 0; i < casos; i++) {
	           CasoPrueba();
        }

    }

    private static void CasoPrueba() {
        int d = scn.nextInt();
		int m = scn.nextInt();

		if (d == 25 && m ==12) {
			System.out.println("SI");
		}
		else {
			System.out.println("NO");
		}
    }
}

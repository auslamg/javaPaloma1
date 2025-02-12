package programaMe.vol3;

import java.util.Scanner;
//DONE
public class Ej390 {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int casos = scn.nextInt();
		scn.nextLine();

        for (int i = 0; i < casos; i++) {
            CasoPrueba();
        }
    }

    private static void CasoPrueba() {
		int m = scn.nextInt();
		int a = scn.nextInt();
		int c = scn.nextInt();

		char[] colors = scn.next().toCharArray();
		scn.nextLine();

	       for (char col : colors) {

            switch (col) {
                case 'M':
                    m--;
                    break;
                case 'A':
                    a--;
                    break;
                case 'C':
                    c--;
                    break;
                case 'R':
                    m--;
                    a--;
                    break;
                case 'V':
                    a--;
                    c--;
                    break;
                case 'L':
                    m--;
                    c--;
                    break;
                case 'N':
                    a--;
                    m--;
                    c--;
                    break;
                default:
                    break;
            }
            if (m < 0 || a < 0 || c < 0) {
                System.out.println("NO");
                return;
            }
		}
		System.out.println("SI " + m + " " + a + " " + c);
    }
}

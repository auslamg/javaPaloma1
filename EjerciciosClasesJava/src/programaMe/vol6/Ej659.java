package programaMe.vol6;

import java.util.Scanner;
//DONE 0.162s exTime, 2 submits
public class Ej659 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int caso = in.nextInt();
        while (caso != 0) { 
            CasoPrueba(caso);

            caso = in.nextInt();
        }

    }

    private static void CasoPrueba(int caso) {
        
        int H = ((caso - (caso % 1000000)) / 1000000);
        caso -= H * 1000000;

        int R = ((caso - (caso % 100000)) / 100000);
        caso -= R * 100000;

        int D = ((caso - (caso % 10000)) / 10000);
        caso -= D * 10000;

        int F = ((caso - (caso % 1000)) / 1000);
        caso -= F * 1000;

        int C = ((caso - (caso % 100)) / 100);
        caso -= C * 100;

        int G = ((caso - (caso % 10)) / 10);
        caso -= G * 10;

        int T = ((caso - (caso % 1)) / 1);
        caso -= T;
        
        for (int i = 0; i < H; i++) {
            System.out.print("H");
        }
        for (int i = 0; i < R; i++) {
            System.out.print("R");
        }
        for (int i = 0; i < D; i++) {
            System.out.print("D");
        }
        for (int i = 0; i < F; i++) {
            System.out.print("F");
        }
        for (int i = 0; i < C; i++) {
            System.out.print("C");
        }
        for (int i = 0; i < G; i++) {
            System.out.print("G");
        }
        for (int i = 0; i < T; i++) {
            System.out.print("T");
        }
        System.out.println();

    }

}

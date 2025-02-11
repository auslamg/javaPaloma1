package programaMe.vol3;

import java.util.Scanner;

public class Ej315 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int h = scn.nextInt(); //height
        int b = scn.nextInt(); //base
        scn.nextLine();

        char[][] board = new char[h][b];

        for (int i = 0; i < h; i++) {
            board[i] = scn.nextLine().toCharArray();
        }

        int moves = scn.nextInt();
        scn.nextLine();

        for (int i = 0; i < moves; i++) {
            int y = scn.nextInt();
            int x = scn.nextInt();
            Check(y, x, board);
            System.out.println();
        }

        for (char[] cs : board) {
            for (char cs2 : cs) {
                System.out.print(cs2);
            }
            System.out.println();
        }

    }

    private static void Check(int y, int x, char[][] board) {
		
		//Abajo
		//Arriba
		//Izquierda
		//Derecha
		
	}
}

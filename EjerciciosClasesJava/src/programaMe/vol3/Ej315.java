package programaMe.vol3;

import java.util.Scanner;
//REDO
public class Ej315 {

    static boolean isGameOver = false;
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
            int y = scn.nextInt() -1;
            int x = scn.nextInt() -1;
            Check(y, x, board, true);
            System.out.println();
        }

        if (isGameOver) {
            System.out.println("GAME OVER");
        }

        for (char[] cs : board) {
            for (char cs2 : cs) {
                System.out.print(cs2);
            }
            System.out.println();
        }

    }

    private static char Check(int y, int x, char[][] board, boolean root) {
        if (y < 0 || x <0 || y >= board.length || x >= board.length) {
            return 0;
        }

        int mineCount = 0;

        switch (board[y][x]) {
            case '-' -> {
                System.out.println("Checking " + y + " " + x);
                board[y][x] = 'X';
                //Vertical
                mineCount += Check(y-1, x, board, false);
                mineCount += Check(y+1, x, board, false);
                //Horizontal
                mineCount += Check(y, x-1, board, false);
                mineCount += Check(y, x+1, board, false);
                //Diagonal
                mineCount += Check(y-1, x-1, board, false);
                mineCount += Check(y-1, x+1, board, false);
                mineCount += Check(y+1, x-1, board, false);
                mineCount += Check(y+1, x+1, board, false);
            }
            case '*' -> {
                if (root) {
                    isGameOver = true;
                }
                else {
                    return 1;
                }
            }
            default -> {
                return 0;
            } 
        }

        if (mineCount > 0) {
            board[y][x] = String.valueOf(mineCount).toCharArray()[0];
        }
        return 0;
	}
}

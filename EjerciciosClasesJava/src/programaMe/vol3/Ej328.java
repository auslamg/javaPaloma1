package programaMe.vol3;

import java.util.Scanner;
//DEBUG: PE
public class Ej328 {

    static Scanner scn = new Scanner(System.in);
    static int[][] tablero;

    public static void main(String[] args) {

        int casos = scn.nextInt();

        for (int i = 0; i < casos; i++) {
            CasoPrueba();
        }
    }

    private static void printTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void CasoPrueba() {
        int filas = scn.nextInt();
        int columnas = scn.nextInt();
        int nPollos = scn.nextInt();
        scn.nextLine();

        tablero = new int[filas][columnas];

        for (int i = 0; i < nPollos; i++) {
            MoverPollo();
        }

        printTablero();
        System.out.println("---");
    }

    static Dir CharToDir(String s) {
        switch (s) {
            case "N":
                return Dir.N;
            case "S":
                return Dir.S;
            case "W":
                return Dir.W;
            case "E":
                return Dir.E;
        }
        return null;
    }

    static void MoverPollo() {

        int posYPollo = scn.nextInt() -1;
        int posXPollo = scn.nextInt() -1;
        Dir polloDir = CharToDir(scn.next());
        int aguantePollo = scn.nextInt();

        int moveN = 1;
        int nextMoveN = moveN;
        boolean addMove = false;
        try {
            while (aguantePollo >= 0) {
                
                moveN = nextMoveN;
                for (int i = 0; i < moveN; i++) {
                    if (aguantePollo < 0) {
                        return;
                    }
                    tablero[posYPollo][posXPollo]++;
                    switch (polloDir) {
                        case N:
                            posYPollo--;
                            break;
                        case S:
                            posYPollo++;
                            break;
                        case W:
                            posXPollo--;
                            break;
                        case E:
                            posXPollo++;
                            break;
                    }
                    aguantePollo--;
                }
                polloDir= SwitchDir(polloDir);

                nextMoveN = addMove? nextMoveN+1 : nextMoveN;
                addMove = !addMove;
            }

        } catch (Exception e) {
            return;
        }
    }

    static Dir SwitchDir(Dir d) {
        switch (d) {
            case N:
                d = Dir.E;
                break;
            case S:
                d = Dir.W;
                break;
            case W:
                d = Dir.N;
                break;
            case E:
                d = Dir.S;
                break;
        } 
        return d;
    }
}

enum Dir {
    N,
    S,
    W,
    E
}
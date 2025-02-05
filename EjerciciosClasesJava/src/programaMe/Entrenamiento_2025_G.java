package programaMe;

import java.util.Scanner;

public class Entrenamiento_2025_G {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int f = scn.nextInt(); //1-100
		int c = scn.nextInt(); //1-100

		String mapStream = new String();
		for (int i = 0; i <= f; i++) {
			mapStream += scn.nextLine();			
		}
		
		System.out.println( checkMap (makeMap(f, c, mapStream)) );
				
	}

	private static int checkMap(char[][] map) {
		boolean[][] checked = new boolean[map.length][map[0].length];
		char T = '#';

		int counter = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				//If checked go next
				if (!checked[i][j]) {
					//If its garden
				if (map[i][j] == T) {
					counter++;

					//Check up
					if (i > 0) {
						checked[i-1][j] = true;
					}
					//Check down
					if (i < map.length-1) {
						checked[i+1][j] = true;
					}
					//Check left
					if (j > 0) {
						checked[i][j-1] = true;
					}
					//Check right
					if (j < map[0].length-1) {
						checked[i][j+1] = true;
					}

				}
					//Check
					checked[i][j] = true;
				}				
			}
		}		
		return counter;
	}

    private static char[][] makeMap(int f, int c, String ctx) {
		char[][] map = new char[f][c];
		int counter = 0;
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = ctx.charAt(counter);
				System.out.print(ctx.charAt(counter));
				counter++;
			}
			System.out.println();
		}
		return map;
    }

}


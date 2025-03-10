package programaMe.vol6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Ej662 {

	static Scanner in = new Scanner(System.in);

	
	public static void main(String[] args) {
		try {
			
			while (true) {
				String measures = in.nextLine();
				
				//Read input
				int ancho = Integer.parseInt( measures.split(" ")[0] ); 
				int alto = Integer.parseInt( measures.split(" ")[1] ); 
				
				int[][] terreno = new int[ancho][alto];
				
				for (int i = 0; i < alto; i++) {
					for (int j = 0; j <ancho; j++) {
						terreno[j][i] = in.nextInt();
					}					
				}
				
				
				CasoPrueba(terreno, ancho, alto);
				
			}
			
		} catch (Exception e) {
			return;
		}
		
		

	}


	private static void CasoPrueba(int[][] terreno, int ancho, int alto) {
		//River
		int[][] rio = new int[ancho][alto];
		int obj = ancho*alto/2;
		
		Resolve(0, alto/2 ,rio, terreno);
	}


	static int Resolve(int i, int j, int[][] rio, int[][] terreno) {
		
		return 0;
	}

}

package programaMe.vol3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ej301 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int[] vals = new int[n];
		for (int i = 0; i < n; i++) {
			vals[i] = scn.nextInt();
		}

		int[] nMonedas = new int[n];
		for (int i = 0; i < n; i++) {
			nMonedas[i] = scn.nextInt();
		}

		int precio = scn.nextInt();

		while (scn.nextLine() != null) {
			int in_nTipos = scn.nextInt(); //1-50
			scn.nextLine();
	
			String[] in_val = scn.nextLine().split(" "); //1-1000
			String[] in_nMonedas = scn.nextLine().split(" ");//0-50
			int in_precioCoche = scn.nextInt();
			scn.nextLine();


			Map<Integer, Integer> MAP_val_num = new HashMap<>();
			
			for (int i = 0; i < in_val.length; i++) {
				MAP_val_num.put(Integer.valueOf(in_val[i]), Integer.valueOf(in_nMonedas[i]));
			}
			EjecutarAlgoritmo(0, 0);
		}
		scn.close();
    }

    private static void EjecutarAlgoritmo(int numTipos, int precio) {
        return;
    }

}

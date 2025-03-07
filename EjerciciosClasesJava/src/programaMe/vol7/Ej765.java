package programaMe.vol7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//DONE: 1.59 exTime, 7 submits
public class Ej765 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Map<String,Integer> listaP;
		Map<String,Integer> listaG;

		//Por cada caso de prueba
		while (true) {
			int count = in.nextInt();
			if (count == 0) {
				return;
			}
			listaP = new HashMap<>();
			listaG = new HashMap<>();

			//Por cada iteracion
			for (int i = 0; i < count; i++) {

				String p = in.next();

				//Si es Grande
				if ( Character.isUpperCase(p.toCharArray()[0]) ) {
					if (!listaG.containsKey(p)) {
						listaG.put(p, 1);
					}
					else {
						listaG.put(p, listaG.get(p) + 1 );
					}
				}
				//Si es Pequeño
				else {
					if (!listaP.containsKey(p)) {
						listaP.put(p, 1);
					}
					else {
						listaP.put(p, listaP.get(p) + 1 );
					}
				}
			}

			String resultP = null;
			int topCountP = 0;

			//Ganador pequeño
			for (String pal : listaP.keySet()) {
				int recount = listaP.get(pal);

				if (recount > topCountP) {
					resultP = pal;
					topCountP = recount;
				}
				else if (recount == topCountP) {
					resultP = "empate";
				}
			}

			String resultG = null;
			int topCountG = 0;

			//Ganador mayor
			for (String pal : listaG.keySet()) {
				int recount = listaG.get(pal);

				if (recount > topCountG) {
					resultG = pal;
					topCountG = recount;
				}
				else if (recount == topCountG) {
					resultG = "EMPATE";
				}
			}
			
			System.out.println(resultP + " " + resultG);
		}		
	}
}

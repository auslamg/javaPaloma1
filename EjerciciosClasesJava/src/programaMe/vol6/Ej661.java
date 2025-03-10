package programaMe.vol6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//DONE 0.756 exTime, 2 submits
public class Ej661 {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int casos = in.nextInt();
		
		while (casos != 0) {
			
			ArrayList<Art> list = new ArrayList<>();
			
			for (int i = 0; i < casos; i++) {
				list.add(new Art( in.next(), in.nextInt(), in.nextInt() ));
			}
			
			Collections.sort(list, new ArtComparator());
			
			for (int idx = 0; idx < list.size(); idx++) {
				System.out.print(list.get(idx).nombre);
				if (idx != list.size()-1) {
					System.out.print(" ");
				}				
			}
			System.out.println();
			
			casos = in.nextInt();
		}
		
	}
}

class Art {
	public String nombre;
	public int hValue;
	public int peso;
	
	public Art(String n, int hVal, int p) {
		nombre = n;
		hValue = hVal;
		peso = p;
	}
}

class ArtComparator implements Comparator<Art> {

	@Override
	public int compare(Art a1, Art a2) {
		if (a1.hValue < a2.hValue) {
			return 1;
		}
		else if (a1.hValue == a2.hValue) {
			if (a1.peso < a2.peso) {
				return -1;
			}
			else if (a1.peso == a2.peso) {
				return 0;
			}
			else {
				return 1;			
			}
		}
		else {
			return -1;			
		}
	}
	
}

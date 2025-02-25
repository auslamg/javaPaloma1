package programaMe.vol3;

import java.util.Scanner;
//DONE: 0.8s exTime, 3 submits
public class Ej314 {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int casos = in.nextInt();
		
		for (int i = 0; i < casos; i++) {
			CasoPrueba();			
		}
		
		in.close();
	}

	private static void CasoPrueba() {
		int reps = in.nextInt();
		
		int picos = 0;
		int valles = 0;
		
		int[] values = new int[reps];
		for (int i = 0; i < reps; i++) {
			values[i] = in.nextInt();
		}
		
		for (int i = 1; i < values.length -1; i++) {
			if (values[i] < values[i+1] && values[i] < values[i-1]) {
				valles++;
			}
			else if (values[i] > values[i+1] && values[i] > values[i-1]){
				picos++;
			}
		}
		
		System.out.println(picos + " " + valles);
	}
}

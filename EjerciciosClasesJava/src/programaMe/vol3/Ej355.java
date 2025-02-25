package programaMe.vol3;

import java.util.Scanner;
//DONE: 0.23s exTime, 1 submits
public class Ej355 {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int casos = in.nextInt();
		
		for (int i = 0; i < casos; i++) {
			CasoPrueba();
		}
	}

	private static void CasoPrueba() {
		int n = in.nextInt();
		boolean n4 = n%4==0;
		boolean n100 = n%100==0;
		boolean n400 = n%400==0;

		if (n4 && !n100 || n400) {	
			System.out.println(29);
		} 
		else System.out.println(28);
	}

}

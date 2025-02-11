package programaMe.vol3;

import java.util.Scanner;

//DONE
public class Ej340 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int casos = scn.nextInt();
		for (int i = 0; i < casos; i++) {
			int b = scn.nextInt();
			int h = scn.nextInt();
			System.out.println(b+h + 2*(b*h));
		}
		scn.close();
	}
	
}
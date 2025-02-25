package programaMe.vol3;

import java.util.Scanner;

public class Ej380 {
	static Scanner in = new Scanner(System.in);
	static boolean running = true;
	
	public static void main(String[] args) {
		while (running) {
			int casos = in.nextInt();
			if (casos == 0) {
				return;
			}
			
			int sum = 0;
			for (int i = 0; i < casos; i++) {
				sum+=in.nextInt();
			}
			System.out.println(sum);
		}
	}

}

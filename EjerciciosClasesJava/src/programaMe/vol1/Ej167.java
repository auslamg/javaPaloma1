package programaMe.vol1;

import java.util.Scanner;
//DONE: 0.338s exTime, 3 submits
public class Ej167 {

	static Scanner in = new Scanner(System.in);
	static String s;
	
	public static void main(String[] args) {
		try {
			while (true) {
				s = in.nextLine();
				int l = Integer.valueOf(s);
				Caso(l);
			}
		} catch (Exception e) {
			return;
		}
    }

    private static void Caso(int l) {
		int count = 0;
		int order = 1;

		count += l*4;
		while (l > 1) {
			l /= 2;
			order++;
			count += l * Math.pow(4, order);
		}

		System.out.println(count);
    }
}

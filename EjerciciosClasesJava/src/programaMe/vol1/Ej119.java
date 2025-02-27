package programaMe.vol1;

import java.util.Scanner;
//DONE: 0.24s exTime, 3 submits
public class Ej119 {

    static Scanner in = new Scanner(System.in);
    static boolean running = true;

    public static void main(String[] args) {
        while (running) {
            int caso = in.nextInt();
            if (caso == 0) {
                return;
            }

            CasoPrueba(caso);
        }
    }

    private static void CasoPrueba(int count) {
        int r = 0;
        int shields = 0;

		while (count > 0) {
			int round = (int) Math.floor(Math.sqrt(count));

			count -= round*round;
			shields += AddShields(round);
		}       

        System.out.println(shields);
    }

    private static int AddShields(int i) {
        return (int) Math.pow(i, 2) + (4*i);
    }

}

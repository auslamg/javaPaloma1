package programaMe.vol6;

import java.util.Scanner;
//DONE 0.262 exTime, 1 submits
public class Ej657 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int casos = in.nextInt();

        for (int i = 0; i < casos; i++) {
            CasoPrueba();
        }
    }

    private static void CasoPrueba() {
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        int num1 = n1;
        int num2 = n2;
        int num3 = n3;

        int d1;
        int d3;

        if (num1 < 0) {
            num1++;            
        }
        if (num2 < 0) {
            num2++;
        }
        if (num3 < 0) {
            num3++;
        }

        d1 = Math.abs(num1 - num2);
        d3 = Math.abs(num3 - num2);

        if (d1 < d3) {
            System.out.println(n1);
        }
        else if (d1 == d3) {
            System.out.println("EMPATE");
        }
        else {
            System.out.println(n3);
        }

    }
}

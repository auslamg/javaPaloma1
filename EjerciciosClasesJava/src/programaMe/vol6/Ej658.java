package programaMe.vol6;

import java.util.Scanner;

public class Ej658 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int caso = in.nextInt();
        while (caso != 0) {
            CasoPrueba(caso);
            caso = in.nextInt();
        }
    }

    private static void CasoPrueba(int caso) {
        int resultado = 1;
        int recuento = 1;

        float fin = (float) Math.ceil(Math.sqrt((float) caso));

        while (recuento < caso) {
            resultado++;
            recuento += Math.pow((resultado*2) + 1, 2) - resultado;
            if (resultado >2) {
                recuento -= (Math.pow((resultado-2 * 2) + 1, 2));
            }
        }

        System.out.println(resultado);
    }

}

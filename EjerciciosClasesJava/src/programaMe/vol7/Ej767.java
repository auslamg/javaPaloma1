package programaMe.vol7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//DEBUG: Not validating
public class Ej767 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            int metros = in.nextInt();

            if (metros == 0) {
                return;
            }

            List<Integer> lista = new ArrayList<>();
            for (int i = 0; i < metros; i++) {
                lista.add(in.nextInt());
            }

            int max = Collections.max(lista);
            int offset = lista.indexOf(max);

            for (int e : lista) {
                while (max + offset - e - lista.indexOf(e) < 0 && e < max) {
                    offset++;
                }
            }

            for (int i = 0; i < lista.size(); i++) {
                int res = (max + offset - i) - lista.get(i);
                if (i < lista.size() - 1) {
                    System.out.print(res + " ");
                } else {
                    System.out.println(res);
                }
            }
        }

    }

}

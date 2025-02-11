package programaMe.vol3;

public class Ejemplo {

    static java.util.Scanner scn;

    public static boolean casoDePrueba() {
        return scn.hasNext(); //Siempre devuelve true
    }

    public static void main(String[] args) {
        scn = new java.util.Scanner(System.in);

        while (casoDePrueba()) {
            if (scn.hasNextInt()) {
                scn.nextLine();
                continue;
            }
            //<Ejecución del algoritmo>
            String palabra = scn.next();
            String salida = TestWord(palabra) ? "SI" : "NO";

            System.out.println(salida);
        }
    }

    private static boolean TestWord(String word) {
        boolean hasA = false;
        boolean hasE = false;
        boolean hasI = false;
        boolean hasO = false;
        boolean hasU = false;

        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            switch (c) {
                case 'a':
                    hasA = true;
                    break;
                case 'e':
                    hasE = true;
                    break;
                case 'i':
                    hasI = true;
                    break;
                case 'o':
                    hasO = true;
                    break;
                case 'u':
                    hasU = true;
                    break;
            }
        }

        return hasA && hasE && hasI && hasO && hasU;
    }
}

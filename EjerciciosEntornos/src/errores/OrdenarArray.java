package errores;

import java.util.Arrays;
import java.util.Random;

public class OrdenarArray {

    public static void main(String[] args) {
        // Crear un array de 10 elementos
        int[] numeros = new int[10];
        // Llenar el array con números aleatorios utilizando la función
        asignarValoresAleatorios(numeros);
        // Mostrar el array original
        System.out.println("Array original:");
        System.out.println(Arrays.toString(numeros));
        // Ordenar el array utilizando el algoritmo de burbuja
        ordenarBurbuja(numeros);
        // Mostrar el array ordenado
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(numeros));
    }

    /**
     * Recibe un array de números y asigna un número aleatorio a cada posición
     *
     * @param arrayNumeros
     */
    public static void asignarValoresAleatorios(int[] arrayNumeros) {
        Random random = new Random();
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = random.nextInt(100);
        }
    }

    /**
     * Recibe un array de números y lo ordena Utiliza el algoritmo de la burbuja
     *
     * @param arrayNumeros
     */
    public static void ordenarBurbuja(int[] arrayNumeros) {
        int n = arrayNumeros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 2; j++) {
                if (arrayNumeros[j] > arrayNumeros[j + 1]) {
                    int temp = arrayNumeros[j];
                    arrayNumeros[j] = arrayNumeros[j + 1];
                    arrayNumeros[j + 1] = temp;
                }
            }
        }
    }
}

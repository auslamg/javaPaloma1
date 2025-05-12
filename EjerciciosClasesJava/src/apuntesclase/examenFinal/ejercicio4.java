package apuntesclase.examenFinal;

import java.util.Map;
import java.util.TreeMap;

public class ejercicio4 {

    public static void main(String[] args) {
        comprobarResultado();
    }

    static Map<Character,Integer> ej4(String palabra) {

        // TreeMap ordena los elementos automáticamente, por lo que no hace falta crear
        // un algoritmo de ordenación
        Map<Character,Integer> coleccion = new TreeMap<>(); 

        //Por cada letra de la palabra introducida
        for (char letra : palabra.toCharArray()) {
            //Si la letra ya está registrada, añadir +1 a su contador
            if (coleccion.containsKey(letra)) {
                coleccion.put(letra, (coleccion.get(letra) + 1) );
            }
            //Sino añadirla con un valor 1
            else {
                coleccion.put(letra, 1);
            }
        }

        //Devuelve la coleccion tras contar las repeticiones de cada letra
        return coleccion;
    }

    static void comprobarResultado() {
        //Crea un nuevo mapa y le da el valor calculado por ej4() para la palabra "paloma"
        Map<Character, Integer> coleccionPrueba = ej4("paloma");
        //Muestra por pantalla los valores del mapa
        for (Character key : coleccionPrueba.keySet()) {
            System.out.println(key + ": " + coleccionPrueba.get(key));
        }

    }
}

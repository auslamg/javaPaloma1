package ej24;

public class Ejercicio24 {

	public static void main(String[] args) {
        int[] vector = {1,2,3,4,5};
        int[] newVector = {0,0,0,0,0};

		for (int i = 0; i < vector.length ; i++) {
            newVector[i] = vector[(vector.length - i)];
		}
        System.out.println(newVector[1]);
	}

}

package ej24;

public class Ejercicio24 {

	public static void main(String[] args) {
		float[] vector = {-2,3,-1,7,2};
        float[] newVector = new float[vector.length];

		for (int i = 0; i < vector.length ; i++) {
            newVector[i] = vector[(vector.length - i)];
		}
        System.out.println(newVector[1]);
	}

}

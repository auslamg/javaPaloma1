package ej24;

public class Ejercicio24 {

	public static void main(String[] args) {
		float[] vector = {-2,3,-1,7,2};
        float[] newVector = {0,0,0,0,0};
        
		for (int i = vector.length - 1; i >= 0 ; i--) {
            newVector[vector.length - i] = vector[i];
		}
        System.out.println(newVector[1]);
	}

}

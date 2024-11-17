package ej22;

public class Ejercicio22 {
    public static void main(String[] args) {
		float[] vector = {2,3,-1,7,2};

        float totalSum = 0;
		for (int i = 0; i < vector.length; i++) {
            totalSum += vector[i];
		}
        System.out.println("Average is " + totalSum / vector.length);
	}
}

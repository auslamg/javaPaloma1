package ej22;

public class Ejercicio22 {
    public static void main(String[] args) {
		float[] vector2 = {2,3,-1,7,2};

        float totalSum = 0;
		for (int i = 0; i < vector2.length; i++) {
            totalSum += vector2[i];
		}
        System.out.println("Average is " + totalSum / vector2.length);
	}
}

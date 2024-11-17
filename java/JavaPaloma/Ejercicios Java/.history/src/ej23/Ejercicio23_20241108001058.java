package ej23;

public class Ejercicio23 {

	public static void main(String[] args) {
		float[] vector2 = {-2,3,-1,7,2};

        float totalSum = 0;
		float itemCount = 0;
		for (int i = 0; i < vector2.length; i++) {
			if (vector2[i] > 0) {
				totalSum += vector2[i];
				itemCount++;
			}
		}
        System.out.println("Average is " + totalSum / itemCount);
	}

}

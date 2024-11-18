package ej23;

public class Ejercicio23 {

	public static void main(String[] args) {
		int[] vector2 = {2,3,-1,7,2};

        int totalSum = 0;
		int itemCount = 0;
		for (int i = 0; i < vector2.length; i++) {
			if (vector2[i] > 0) {
				totalSum += vector2[i];
				itemCount++;
			}
		}
        System.out.println("Average is " + totalSum / itemCount);
	}

}

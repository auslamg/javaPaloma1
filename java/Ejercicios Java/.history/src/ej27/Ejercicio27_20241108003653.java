package ej27;

public class Ejercicio27 {

	public static void main(String[] args) {
        int[][] matrix = {
			{0,0,0},
			{0,0,0},
			{0,0,0}
			};

		int totalSum = 0;

            for (int[] matrix1 : matrix) {
                for (int col = 0; col < matrix1.length; col++) {
                    totalSum += matrix1[col];
                }
            }

		System.out.println(totalSum);
	}

}

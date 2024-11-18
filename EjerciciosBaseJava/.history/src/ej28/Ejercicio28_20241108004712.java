package ej28;

public class Ejercicio28 {

	public static void main(String[] args) {
        int[][] matrix = {
			{0,1,0},
			{0,0,3},
			{5,0,-1}
			};

		int positiveSum = 0;
        int negativeSum = 0;

        for (int[] matrix1 : matrix) {
            for (int col = 0; col < matrix1.length; col++) {
                if (matrix1[col] > 0) {
                    positiveSum += matrix1[col];
                }
                else if (matrix1[col] < 0) {
                    negativeSum += matrix1[col];
                }
            }
        }


        int[] sumVector = {positiveSum,negativeSum};

        for (int i = 0; i < sumVector.length; i++) {
			System.out.println(sumVector[i]);
		}
	}

}

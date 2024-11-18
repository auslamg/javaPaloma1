package ej28;

public class Ejercicio28 {

	public static void main(String[] args) {
        int[][] matrix = {
			{0,1,0},
			{0,0,3},
			{5,0,0}
			};

		int positiveSum = 0;
        int positiveCount = 0;
        int negativeSum = 0;
        int negativeCount = 0;

        for (int[] matrix1 : matrix) {
            for (int col = 0; col < matrix1.length; col++) {
                if (matrix1[col] > 0) {
                    positiveSum += matrix1[col];
                    positiveCount++;
                }
                else if (matrix1[col] < 0) {
                    negativeSum += matrix1[col];
                    negativeCount++;
                }
            }
        }

        int[] sumVector = {positiveSum / positiveCount,negativeSum / negativeCount};

        for (int i = 0; i < sumVector.length; i++) {
			System.out.println(sumVector[i]);
		}
	}

}

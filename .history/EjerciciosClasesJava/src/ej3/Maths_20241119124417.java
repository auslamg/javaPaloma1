package ej3;

public class Maths {

    public static int Factorial(int num) {
        if (num < 0) {
            //throw new Exception("asdasda");
            System.err.println("MENOR QUE 0");
        }
        
        int totalSum = 1;
        for (int i = 1; i <= num; i++) {
            totalSum = totalSum * i;
        }

        return totalSum;
    }

    public static float avgVectors(int[] vector) {
        int totalSum = 0;
        for (int i : vector) {
            totalSum += i;
        }

        return totalSum / vector.length;
    }
    public static boolean asd(int num) {
        int totalSum = 0;

        for (int i = 0; i < num; i++) {
            
        }


        return false;
    }

}

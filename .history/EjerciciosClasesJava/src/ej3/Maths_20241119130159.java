package ej3;

public abstract class Maths {

    public static int factorial(int num) {
        if (num < 0) {
            //throw new Exception("asdasda");
            System.err.println("MENOR QUE 0");
        }
        
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }

        return result;
    }

    public static float avgVectors(int[] vector) {
        int totalSum = 0;
        for (int i : vector) {
            totalSum += i;
        }

        return totalSum / vector.length;
    }

    public static boolean isPrime(int num) {
        int i = 1;
        while (i < num) {
            if (num % i == 0) {
                return false;
            }
            else {
                i++;
            }
        }

        return true;
    }

}

package ej3;

public class Maths {

    public static int factorial(int num) {
        if (num < 0) {
            throw new ArithmeticException("Can't run factorial of negative numbers.");
        }
        
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }

        return result;
    }

    public static int factorialRecursive(int num) {
        if (num < 0) {
            throw new ArithmeticException("Can't run factorial of negative numbers.");
        }

        if (num < 2) {
            return 1;
        }
        else return num * factorialRecursive(num - 1);
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

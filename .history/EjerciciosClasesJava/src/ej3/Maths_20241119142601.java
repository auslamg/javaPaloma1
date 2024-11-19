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

    public static int fibonacciRecursive(int num) {
        if (num < 0) {
            throw new ArithmeticException("Can't run fibonacci of negative numbers.");
        }

        switch (num) {
            case 0:
                return  0;
            case 1:
                return 1;
            default:
                return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
        }
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

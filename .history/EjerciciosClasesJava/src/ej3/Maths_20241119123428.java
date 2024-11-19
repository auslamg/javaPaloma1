package ej3;

public class Maths {

    public static int Factorial(int num1) {
        if (num1 < 0) {
            //throw new Exception("asdasda");
            System.err.println("MENOR QUE 0");
        }
        
        int totalSum = 1;
        for (int i = 1; i <= num1; i++) {
            totalSum = totalSum * i;
        }

        return totalSum;
    }

    public static float avgVectors() {
        

        return 0;
    }
}

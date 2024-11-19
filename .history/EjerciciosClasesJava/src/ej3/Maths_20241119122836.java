package ej3;

public class Maths {

    public static int Factorial(int num1) {
        if (num1 < 0) {
            //throw new Exception("asdasda");
        }
        
        int totalSum = 1;
        for (int i = 1; i <= num1; i++) {
            totalSum = totalSum * i;
        }
        
        return totalSum;
    }
}

package errores;

public class Calculadora {

    private int num1;
    private int num2;

    public Calculadora(int a, int b) {
        System.out.println("Gabriel Ausejo Lamadrid");
        num1 = a;
        num2 = b;
    }

    public int suma() {
        int resul = num1 + num2;
        return resul;
    }

    public int resta() {
        int resul = num1 - num2;
        return resul;
    }

    public int producto() {
        int resul = num1 * num2;
        return resul;
    }

    public int division() {
        int resul = num1 / num2;
        return resul;
    }
}

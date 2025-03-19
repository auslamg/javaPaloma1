package programaMe.resources;

public class StringFormats {
    static int myInt = 12;
    static double myDecimal = 3.14159d;
    static String myString = "¡Hola mundo!";

    public static void main(String[] args) {
        //Padding
        System.out.println(String.format("%06d", myInt) ); //Cifras enteras - "000012"
        System.out.println(String.format("%-6d", myInt)); //Padding izq - "    12"
        System.out.println(String.format("%6d", myInt)); // Padding dcha - "12    "

        //Decimales
        System.out.println(String.format("%.2f", 3.14159)); //Cifras decimales - "3.14"
        System.out.println(String.format("%.2f%%", myDecimal)); //% con dos decimales - "314.16%"

        //Palabras
        System.out.println(String.format("%.5s", myString)); // "¡Hola"
    }
}

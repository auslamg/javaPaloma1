package apuntesclase.examenFinal;

public class ejercicio6 {
    public static void main(String[] args) {
        //Inicializa una variable B, que llama al constructor de su superclase sin parámetros {A()} y despues al constructor
        //con los parámetros pasados {B("Hola") => B(String dato)}
        B b = new B("Hola");

        //Por tanto, se imprime "JuanHola"
    }
}

class A {
    A() {
        System.out.print("Juan"); // Primero se ejecuta esta linea
    }

    A(String dato) {
        System.out.println(dato);
    }
}

class B extends A {
    B(String dato) {
        System.out.print(dato); //D se ejecuta esta linea
    }
}
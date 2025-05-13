package apuntesclase.examenFinal;

public class TestHerencia {

}

class A {

    public A(String s) {
        System.out.println(s);
    }
}

class B extends A {
    public B(String s) {
        super(s);
        System.out.println(s);
    }
}


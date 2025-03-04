package gab.util.testing;

public class TryCatch {

    public static void main(String[] args) {
        try {
            System.out.println("Try1");
            MyMethod();
        } catch (Exception e) {
            System.out.println("Catch2");
        } finally {
            System.out.println("Fin1");
        }
    }

    private static void MyMethod() throws UnsupportedOperationException{
        try {
            System.out.println("Try2");
            MyMethod2();
        } catch (Exception e) {
            System.out.println("Catch2");
            throw new UnsupportedOperationException("Unimplemented method 'MyMethod'");
        } finally {
            System.out.println("Fin2");
        }
    }

    private static void MyMethod2() {
        System.out.println("3");
        throw new UnsupportedOperationException("Unimplemented method 'MyMethod2'");
    }

}

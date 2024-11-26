package ej_bancos;

public class Bank {
    Code code; //5 chars
    String name; 

    public Bank(String _code, String _name) throws IllegalArgumentException {
        if (_code.length() != 5) {
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters!");
        }
        this.code = _code;
        this.name = _name;
    }

    /*
    public static void main(String[] args) {
        try {
            Bank myBank = new Bank("123", null);
        } catch (Exception e) {
            System.err.println("Could not create a Bank instance");
        }
    }
    */
}

class Code {
    int code;
    public Code(int _code) throws IllegalArgumentException{
        if (String.valueOf(_code).length() != 5) {
            throw new IllegalArgumentException("Code must be 5 digits long");
        }
        this.code = _code;
    }
}
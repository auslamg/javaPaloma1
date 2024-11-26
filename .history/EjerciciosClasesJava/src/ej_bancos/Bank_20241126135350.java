package ej_bancos;
import java.util.ArrayList;
//DONE
public class Bank {
    String code; //5 chars
    String name;
    ArrayList<Sucursal> sucursals;

    public Bank(String _code, String _name, ArrayList<Sucursal> _sucursals) throws IllegalArgumentException {
        if (_code.length() != 5) {
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters!");
        }
        if (_sucursals.size() < 1) {
            throw new IllegalArgumentException("Sucursal must have at least one phone number");
        }

        this.code = _code;
        this.name = _name;
        this.sucursals = _sucursals;
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
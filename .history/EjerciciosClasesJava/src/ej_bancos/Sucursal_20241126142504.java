package ej_bancos;
import java.util.ArrayList;
//DONE
public class Sucursal {
    String code;
    Adress adress;
    ArrayList<Integer> telephoneNumbers; 
    Email email;
    Bank bank;

    public Sucursal(String _code, Adress _adress, ArrayList<Integer> _telephoneNumbers, Email _email, Bank _bank) throws IllegalArgumentException {
        if (_code.length() != 5) {
            throw new IllegalArgumentException("Sucursal code must have 5 characters");
        }
        if (_telephoneNumbers.size() < 1) {
            throw new IllegalArgumentException("Sucursal must have at least one phone number");
        }

        this.code = _code;
        this.adress = _adress;
        this.telephoneNumbers = _telephoneNumbers;
        this.email = _email;
        this.bank = _bank;

        bank.sucursals.add(this);
    }
}

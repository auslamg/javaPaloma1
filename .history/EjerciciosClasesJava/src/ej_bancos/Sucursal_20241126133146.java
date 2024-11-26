package ej_bancos;

import java.util.ArrayList;

public class Sucursal {
    String code;
    Adress adress;
    ArrayList<Integer> telephoneNumbers; //9digits
    Email email; //Nchars 1@ Nchars

    public Sucursal(String _code, Adress _adress, ArrayList<Integer> _telephoneNumbers, Email _email) throws IllegalArgumentException {
        if (_code.length() != 5) {
            throw new IllegalArgumentException("Code must have 5 alphanumeric characters!");
        }

        this.code = _code;
        this.adress = _adress;
        this.telephoneNumbers = _telephoneNumbers;
        this.email = _email;
    }
}

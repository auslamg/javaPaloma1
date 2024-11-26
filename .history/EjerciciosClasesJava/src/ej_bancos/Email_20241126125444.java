package ej_bancos;

public class Email {
    String firstPart;
    String dominion;

    public String getEmailAdress() {
        return firstPart + "@" + dominion;
    }

    public Email(String _firstPart, String _dominion) {
        this.firstPart = _firstPart;
        this.dominion = _dominion;
    }
}

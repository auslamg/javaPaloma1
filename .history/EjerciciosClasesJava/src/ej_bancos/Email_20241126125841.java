package ej_bancos;

public class Email {
    String firstPart;
    String dominion;

    public String getEmailAdress() {
        return firstPart + "@" + dominion;
    }

    public Email(String _firstPart, String _dominion) throws IllegalArgumentException {
        if (!(_dominion.endsWith(".com") || _dominion.endsWith(".net"))) {
            throw new IllegalArgumentException("Unknown dominion");
        }

        this.firstPart = _firstPart;
        this.dominion = _dominion;
    }
}

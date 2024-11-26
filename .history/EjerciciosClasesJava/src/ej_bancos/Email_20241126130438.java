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

        if (!(_firstPart.contains("@") || _dominion.contains("@"))) {
            throw new IllegalArgumentException("Don't include the @");
        }

        this.firstPart = _firstPart;
        this.dominion = _dominion;
    }

    public Email(String _fullEmail) {
        String[] splitMail = _fullEmail.split(_fullEmail.indexOf("@"));
        
        _fullEmail.indexOf("@");
    }
}

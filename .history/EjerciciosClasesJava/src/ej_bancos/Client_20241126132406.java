package ej_bancos;
import java.util.ArrayList;

public class Client {
    String NIF; //8digits 1char
    String name;
    String[] surnames;
    Adress adress; //optional
    ArrayList<Account> accounts;

    public Client(String _NIF, String _Name, String[] _surnames, ArrayList<Account> _accounts) {
        this(_NIF, _Name, _surnames, null, _accounts);
    }

    public Client(String _NIF, String _name, String[] _surnames, Adress _adress, ArrayList<Account> _accounts) {
        this.NIF = _NIF;
        this.name = _name;
        this.surnames = _surnames;
        this.adress = _adress;
        this.accounts = _accounts;
    }

    //Add accounts to account list
    public void addAccounts(Account _accountToAdd) {
        this.accounts.add(_accountToAdd);
    }
    public void addAccounts(ArrayList<Account> _accountsToAdd) {
        this.accounts.addAll(_accountsToAdd);
    }
}

//DONE
class Email {
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

    public Email(String _fullEmail) throws IllegalArgumentException {
        if (!(_fullEmail.endsWith(".com") || _fullEmail.endsWith(".net"))) {
            throw new IllegalArgumentException("Unknown dominion");
        }
        if (_fullEmail.length() - _fullEmail.replace("@", "").length() != 1 ) {
            throw new IllegalArgumentException("Email includes the wrong amount of @'s");
        }

        String[] splitMail = _fullEmail.split("@");
        this.firstPart = splitMail[0];
        this.dominion =splitMail[1];
    }
}
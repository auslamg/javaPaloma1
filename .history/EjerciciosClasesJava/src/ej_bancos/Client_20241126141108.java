package ej_bancos;
import java.util.ArrayList;

public class Client {
    String NIF; //8digits 1char
    String name;
    String[] surnames;
    Adress adress; //optional
    ArrayList<Account> accounts;

    public Client(String _NIF, String _Name, String[] _surnames, ArrayList<Account> _accounts) throws IllegalArgumentException {
        this(_NIF, _Name, _surnames, null, _accounts);
    }

    public Client(String _NIF, String _name, String[] _surnames, Adress _adress, ArrayList<Account> _accounts) throws IllegalArgumentException {
        if ( (_NIF.length() != 9) || !Character.isLetter(_NIF.charAt(_NIF.length() - 1)) ) {
            throw new IllegalArgumentException("Client NIF format is erroneous");
        }

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
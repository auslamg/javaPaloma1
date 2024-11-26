package ej_bancos;

public class Client {
    String NIF; //8digits 1char
    String name;
    String surnames[];
    Adress adress; //optional
    Account[] accounts;


    public Client(String _NIF, String _Name, String[] _surnames, Account[] _accounts) {
        this(_NIF, _Name, _surnames, null, _accounts);
    }

    public Client(String _NIF, String _name, String[] _surnames, Adress _adress, Account[] _accounts) {
        this.NIF = _NIF;
        this.name = _name;
        this.surnames = _surnames;
        this.adress = _adress;
        this.accounts = _accounts;
    }
}
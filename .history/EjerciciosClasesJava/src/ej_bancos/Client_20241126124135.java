package ej_bancos;

public class Client {
    String NIF; //8digits 1char
    String name;
    String surnames[];
    Adress adress; //optional
    Account account;


    public Client(String _NIF, String _Name, String[] _surnames, Account _account) {
        this(_NIF, _Name, _surnames, null, _account);
    }

    public Client(String _NIF, String _name, String[] _surnames, Adress _adress, Account _account) {
        this.NIF = _NIF;
        this.name = _name;
        this.surnames = _surnames;
        this.adress = _adress;
        this.account = _account;
    }
}
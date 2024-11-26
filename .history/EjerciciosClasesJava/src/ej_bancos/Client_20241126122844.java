package ej_bancos;

public class Client {
    String NIF; //8digits 1char
    String name;
    String surnames[];
    Adress myAdress; //optional
    Account myAccount;


    public Client(String _NIF, String _Name, String[] _surnames, Account _myAccount) {
        this(_NIF, _Name, _surnames, null, _myAccount);
    }

    public Client(String _NIF, String _name, String[] _surnames, Adress _myAdress, Account _myAccount) {
        this.NIF = _NIF;
        this.name = _name;
        this.surnames = _surnames;
        this.myAdress = _myAdress;
        this.myAccount = _myAccount;
    }
}
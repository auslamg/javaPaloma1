package ej_bancos;
//DONE
public class Account {
    String code;
    float balance;
    Bank bank;

    public Account(String _code, float _balance, Bank _bank) {
        this.code = _code;
        this.balance = _balance;
        bank = _bank;
    }

    public float getBalance() {
        return balance;
    }

    public String getCode() {
        return code;
    }
}

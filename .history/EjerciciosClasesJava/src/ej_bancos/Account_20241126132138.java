package ej_bancos;
//IDEA DONE
public class Account {
    String code;
    float balance;

    public Account(String _code, float _balance) {
        this.code = _code;
        this.balance = _balance;
    }

    public float getBalance() {
        return balance;
    }

    public String getCode() {
        return code;
    }
}

package ej_bancos;

public class PhoneNumber {
    int prefix;
    Integer number;

    public PhoneNumber(Integer _number) throws IllegalArgumentException {
        if (String.valueOf(_number).length() != 9) {
            throw new IllegalArgumentException("Wrong number length");
        }

        this.prefix = 34;
        this.number = _number;
    }

    public PhoneNumber(int _prefix, int _number) throws IllegalArgumentException {
        if ((String.valueOf(_prefix).length() != 2) && (String.valueOf(_prefix).length() != 3)) {
            throw new IllegalArgumentException("Wrong prefix length");
        }
        if (String.valueOf(_number).length() != 9) {
            throw new IllegalArgumentException("Wrong number length");
        }

        this.prefix = _prefix;
        this.number = _number;
    }
}

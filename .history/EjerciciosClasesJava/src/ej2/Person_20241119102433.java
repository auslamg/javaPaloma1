package ej2;

public class Person {

    String DNI;
    String name;
    Adress adress;

    public Person(String DNI, String name, Adress adress) {
        this.DNI = DNI;
        this.name = name;
        this.adress = adress;
    }

    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}

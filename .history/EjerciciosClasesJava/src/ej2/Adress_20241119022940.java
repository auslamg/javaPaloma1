package ej2;

public class Adress {

    //Tipo de vía
    enum roadType {
        lane,
        street,
        district,
        road,
        boulevard
    }

    String roadName;
    int roadNumber;
    int postCode;

    String city;    
    enum province {
        Madrid,
        Guadalajara,
        Segovia,
        Ávila,
        Toledo,
        other
        //...
    }

}

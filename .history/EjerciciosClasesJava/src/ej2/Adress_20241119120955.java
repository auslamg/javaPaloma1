package ej2;

public class Adress {


    //Tipo de vía
    enum roadTypes {
        lane,
        street,
        district,
        road,
        boulevard
    }

    roadTypes roadType;
    String roadName;
    int roadNumber;
    int postCode;

    String city;    
    enum provinces {
        Madrid,
        Guadalajara,
        Segovia,
        Ávila,
        Toledo,
        other
        //...
    }
    provinces province;

    String fullDirection;
    
    public String getFullDirection() {
        return (roadName + " " + roadType.toString() + " " + roadNumber + ", " + city + ", " + province.toString() + " (" + postCode + ")");
    }


    //Sin opcionales
    public Adress(roadTypes myRoadType, String myRoadName, int myPostCode, String myCity) {
        this(myRoadType, myRoadName, 0, myPostCode, myCity, provinces.other);
    }

    //roadNumber
    public Adress(roadTypes myRoadType, String myRoadName, int myRoadNumber, int myPostCode, String myCity) {
        this(myRoadType, myRoadName, myRoadNumber, myPostCode, myCity, provinces.other);
    }

    //province
    public Adress(roadTypes myRoadType, String myRoadName, int myPostCode, String myCity, provinces myProvince) {
        this(myRoadType, myRoadName, 0, myPostCode, myCity, myProvince);
    }

    //Con opcionales
    public Adress(roadTypes myRoadType, String myRoadName, int myRoadNumber, int myPostCode, String myCity, provinces myProvince) {
        roadType = myRoadType;
        roadName = myRoadName;
        roadNumber = myRoadNumber;
        postCode = myPostCode;
        city = myCity;
        province = myProvince;
    }

}

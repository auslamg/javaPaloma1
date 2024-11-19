package ej2;

public class Adress {

    public String getFullDirection() {
        return (roadType.toString() + " " + roadName + " " + roadNumber + ", " + city + ", " + province.toString() + " (" + postCode + ")");
    }

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


    //Sin opcionales
    public Adress(roadTypes myRoadType, String myRoadName, int myPostCode, String myCity) {
        this(myRoadType, myRoadName, 0, myPostCode, myCity, null);
    }

    //roadNumber
    public Adress(roadTypes myRoadType, String myRoadName, int myRoadNumber, int myPostCode, String myCity) {
        this(myRoadType, myRoadName, myRoadNumber, myPostCode, myCity, null);
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

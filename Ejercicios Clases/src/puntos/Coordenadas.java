package puntos;

public class Coordenadas {
    int x;
    int y;
    int z;

    int dimensions;

    public Coordenadas() {
        x = 0;
        y = 0;

        dimensions = 2;
    }

    public Coordenadas(int xValue, int yValue) {
        x = xValue;
        y = yValue;

        dimensions = 2;
    }

    public Coordenadas(int xValue, int yValue, int zValue) {
        x = xValue;
        y = yValue;
        z = zValue;

        dimensions = 3;
    }

    public int GetX() {
        return this.x;
    }

    public int GetY() {
        return  this.y;
    }

    public int GetZ() {
        return this.z;
    }

    public int[] GetCoords() {
        int[] myCoordsArray = new int[0];
        myCoordsArray[0] = this.x;
        myCoordsArray[1] = this.y;
        if (this.dimensions > 2) {
            myCoordsArray[2] = this.z;
        }
        return myCoordsArray;
    }
}

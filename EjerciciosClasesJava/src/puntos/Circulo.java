package puntos;

import puntos.Circulo.Color;

public class Circulo {

	Coordenadas position;
	float radius;


	enum Color {
		white,
		black,
		red,
		yellow,
		green,
		blue
	}

	Color fillColor = Color.white;
	Color borderColor;

	public Circulo() {
		this(0,0,1, Color.white);
	}

	public Circulo(int xCoord, int yCoord, float radiusLength, Color fillColorValue) {
		this(xCoord,yCoord,radiusLength,fillColorValue,null);
	}

	public Circulo(int xCoord, int yCoord, float radiusLength, Color fillColorValue, Color borderColorValue) {
		position = new Coordenadas(xCoord,yCoord);
		this.radius = radiusLength;
		this.fillColor = fillColorValue;
		this.borderColor = borderColorValue;
	}

	public Circulo(int xCoord, int yCoord, int zCoord, float radiusLength, Color fillColor, Color borderColor) {
		position = new Coordenadas(xCoord,yCoord,zCoord);
		this.radius = radiusLength;
		this.fillColor = fillColor;
		this.borderColor = borderColor;
	}

    public Coordenadas getPosition() {
        return position;
    }

    public float getRadius() {
        return radius;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

}

package puntos;

class Circulo {

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
		this(new Coordenadas(), 1, Color.white);
	}

	public Circulo(Coordenadas newPosition, float radiusLength, Color fillColorValue) {
		this(newPosition,radiusLength,fillColorValue,null);
		this.position.dimensions = 2;
	}

	public Circulo(Coordenadas newPosition, float radiusLength, Color fillColorValue, Color borderColorValue) {
		position = newPosition;
		this.radius = radiusLength;
		this.fillColor = fillColorValue;
		this.borderColor = borderColorValue;
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

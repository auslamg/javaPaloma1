package ej1;

class Circle {

	Coordinates position;
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

	public Circle() {
		this(new Coordinates(), 1, Color.white);
	}

	public Circle(Coordinates newPosition, float radiusLength, Color fillColorValue) {
		this(newPosition,radiusLength,fillColorValue,null);
		this.position.dimensions = 2;
	}

	public Circle(Coordinates newPosition, float radiusLength, Color fillColorValue, Color borderColorValue) {
		position = newPosition;
		this.radius = radiusLength;
		this.fillColor = fillColorValue;
		this.borderColor = borderColorValue;
	}

    public Coordinates getPosition() {
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

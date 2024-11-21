package ej1;

class Circle {

	public static void main(String[] args) {
		Circle circulo1;
		circulo1 = new Circle(new Coordinates(), -500, Color.white);

		System.out.println(circulo1.radius);
	}

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

	public Circle() throws ArithmeticException {
		this(new Coordinates(), 1, Color.white);
	}

	public Circle(Coordinates centerPosition, float radiusLength, Color fillColorValue) throws ArithmeticException {
		this(centerPosition,radiusLength,fillColorValue,null);
	}

	public Circle(Coordinates centerPosition, float radiusLength, Color fillColorValue, Color borderColorValue) throws ArithmeticException {
		if (radiusLength <= 0) {
			try {
				throw new Exception("Not possible");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return;
		}

		position = centerPosition;
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

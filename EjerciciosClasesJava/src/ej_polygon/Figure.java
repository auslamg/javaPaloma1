package ej_polygon;

@SuppressWarnings("unused")
abstract class Figure {
	protected float perimeter;
	protected Color lineColor;

	protected enum Color {
		R,
		G,
		B
	}

    protected Figure(Color lineColor) {
		this.lineColor = lineColor;
    }

	void getType() {
		System.out.println("Figure");
	}
}

@SuppressWarnings("unused")
abstract class OpenFigure extends Figure {

	protected float length;
	protected OpenFigure(Color lineColor, float length) {
		super(lineColor);
		this.length = length;
	}

	@Override
	void getType() {
		System.out.println("Open Figure");
	}
}

@SuppressWarnings("unused")
abstract class ClosedFigure extends Figure {
	
	protected float area;
	protected Color bgColor;

	protected ClosedFigure(Color lineColor, Color bgColor) {
		super(lineColor);
		this.bgColor = bgColor;
	}

	public abstract float getArea();

	@Override
	void getType() {
		System.out.println("Closed Figure");
	}
}

@SuppressWarnings("unused")
class Triangle extends ClosedFigure {
	float base;
	float height;

	public Triangle(Color lineColor, Color bgColor, float base, float height) {
		super(lineColor, bgColor);
		this.base = base;
		this.height = height;
	}

	@Override
	public float getArea(){
		return base*height/2;
	}

	@Override
	void getType() {
		super.getType();
		System.out.println("Triangle");
	}
}

@SuppressWarnings("unused")
class Rectangle extends ClosedFigure{
	float base;
	float height;

	public Rectangle(Color lineColor, Color bgColor,float base, float height) {
		super(lineColor, bgColor);
		this.base = base;
		this.height = height;
	}

	@Override
	public float getArea() {
		return base*height;
	}

	@Override
	void getType() {
		System.out.println("Rectangle");
	}
}
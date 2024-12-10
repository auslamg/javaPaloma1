package ej_polygon;

@SuppressWarnings("unused")
abstract class ClosedFigure {
	protected float area;
	public abstract float dameArea();

	void Euclidean() {
		System.err.println("SOY UN POLIGONO");
	}
}

@SuppressWarnings("unused")
class Square extends ClosedFigure{
	float sideLength;

	@Override
	public float dameArea() {
		return sideLength*sideLength;
	}
}

@SuppressWarnings("unused")
class Triangle extends ClosedFigure {
	float base;
	float height;

	public Triangle(float base, float height) {
		this.base = base;
		this.height = height;
	}

	@Override
	public float dameArea(){
		return base*height/2;
	}
	void Pithagorean() {
		System.out.println("SOY UN TRIANGULO");
	}
}

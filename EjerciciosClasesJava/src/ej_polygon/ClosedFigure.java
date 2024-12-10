package ej_polygon;

@SuppressWarnings("unused")
abstract class ClosedFigure {
	protected float area;
	public abstract float dameArea();
}

@SuppressWarnings("unused")
class Square {
	float sideLength;

	public float dameArea() {
		return sideLength*sideLength;
	}
}

@SuppressWarnings("unused")
class Triangle {
	float base;
	float height;

	public Triangle(float base, float height) {
		this.base = base;
		this.height = height;
	}

	public float dameArea() throws Exception {
		return base*height/2;
	}
}

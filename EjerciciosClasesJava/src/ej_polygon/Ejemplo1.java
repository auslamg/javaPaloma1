package ej_polygon;

import ej_polygon.Figure.Color;

public class Ejemplo1 {

	public static void main(String[] args) {
		Figure tri = new Triangle(Color.B,Color.R,3, 2);
		Triangle tri2 = new Triangle(Color.B,Color.R,3, 2);

		ClosedFigure quad = new Rectangle(Color.B,Color.R,4,2);
		
		tri.getType();
		tri2.getType();

		test(quad);
	}

	static void test(ClosedFigure figure) {
		System.out.println(figure.getArea());
	}

}

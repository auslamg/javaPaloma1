package ej1;

import ej1.Circle.Color;

public class MainCircle {

	public static void main(String[] args) {

        Circle myCircle1 = new Circle(new Coordinates(),1,Color.black);
        Circle myCircle2 = new Circle(new Coordinates(),1,Color.green);


        System.out.println(DoTheseShareColor(myCircle1,myCircle2));
	}

    static boolean DoTheseShareColor(Circle circle1, Circle circle2) {
        return circle1.fillColor == circle2.fillColor;
    }
}

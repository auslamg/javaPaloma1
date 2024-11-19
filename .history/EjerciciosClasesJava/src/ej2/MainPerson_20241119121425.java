package ej2;

import ej2.Adress.roadTypes;

public class MainPerson {

	public static void main(String[] args) {
		Person BruceWayne = new Person("98742284B","Bruce Wayne",new Adress(roadTypes.Street, "Baker", 28800, "Gotham"));

		System.out.println(BruceWayne.getPersonData());
	}

}

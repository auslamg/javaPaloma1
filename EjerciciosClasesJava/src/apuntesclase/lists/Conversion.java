package apuntesclase.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversion {

	public static void main(String[] args) {

		
	}

	//Conversion
	public static void ArrayToList() {
		String[] arrayNom = {"Juan","Pepe"};

		List<String> listNom = new ArrayList<>();
		listNom = Arrays.asList (arrayNom);
	}

	public static void ListToArray() {
		List<String> listNom = new ArrayList<>();

		listNom.add("Juan");
		listNom.add("Pepe");

		String[] arrayNom = listNom.toArray(new String[listNom.size()]);
	}
}

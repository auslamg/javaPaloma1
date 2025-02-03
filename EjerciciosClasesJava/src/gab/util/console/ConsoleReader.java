package gab.util.console;

import java.util.List;
import java.util.Scanner;

public class ConsoleReader{

	Scanner scn;

	public ConsoleReader() {
		scn = new Scanner(System.in);
	}

	public static void main(String[] args) {
		ConsoleReader cr = new ConsoleReader();

		cr.askT("Dame un Entero", Integer.class);

		enum enumEjemplo {
			PRADO,
			DESIERTO,
			MAR,
			MONTE,
			BOSQUE
		}

		//Test Enums
		cr.askEnumConstByName("Dame el bioma que quieres guardar", enumEjemplo.class);

		System.out.println(cr.askEnumConstByIndex("Choose your enum element", enumEjemplo.class));
		System.out.println(cr.askEnumConstByName("Choose your enum element", enumEjemplo.class)); 

		cr = new ConsoleReader();

		System.out.println(cr.askEnumConstByIndex("Choose your enum element", enumEjemplo.class));
	}

	public <T> T askT(String question, Class<T> returnType) {
		Scanner s = this.scn;
		return AskGeneric.askT(question, returnType, s);
	}

	public <T> T askEnumConstByIndex(String question, Class<T> returnType) {
		Scanner s = this.scn;
		return AskEnumConst.askEnumConstByIndex(question, returnType, s);
	}

	public <T> T askEnumConstByName(String question, Class<T> returnType) {
		Scanner s = this.scn;
		return AskEnumConst.askEnumConstByName(question, returnType, s);
	}

	public <T> Object askListElementByIndex(String question, List<T> list) {
		Scanner s = this.scn;

		return AskListElement.askListElementByIndex(question, list, s);
	}	

}

class AskGeneric {

	public static <T> T askT(String question, Class<T> returnType, Scanner scn) {
		T output;

		//Ask question
		System.out.println(question);
		
		//Assert type
		switch (returnType.getSimpleName()) {
			case "Integer" -> output = returnType.cast(readInteger(scn));
			case "Double" -> output = returnType.cast(readDouble(scn));
			case "String" -> output = returnType.cast(readString(scn));
			case "Character" -> output = returnType.cast(readCharacter(scn));
			case "Boolean" -> output = returnType.cast(readBoolean(scn));
			//If the type is not supported, return null
			default -> {
				System.out.println("Invalid type");
				return null;
			}
		}
		
		return output;
	}

	private static Integer readInteger(Scanner scn) {
		Scanner s = scn;
		
		//Read input
		try {
			Integer input = s.nextInt();
			return input;
		}
		//Retry
		catch (Exception e) {
			scn.nextLine();
			return askT("Invalid input. Try Integer value", Integer.class, scn);
		}
	}

	private static Double readDouble(Scanner scn) {
		Scanner s = scn;

		//Read input
		try {
			Double input = s.nextDouble();
			return input;
		} 
		//Retry
		catch (Exception e) {
			scn.nextLine();
			return askT("Invalid input. Try Double value", Double.class, scn);
		}
	}

	private static String readString(Scanner scn) {
		Scanner s = scn;

		//Read input
		try {
			String input = s.next();
			return input;
		} 
		//Retry
		catch (Exception e) {
			scn.nextLine();
			return askT("Invalid input. Try String value", String.class, scn);
		}
	}

	private static Character readCharacter(Scanner scn) {
		Scanner s = scn;

		//Read input
		try {
			Character input = s.next().charAt(0);
			return input;
		} 
		//Retry
		catch (Exception e) {
			scn.nextLine();
			return askT("Invalid input. Try Character value", Character.class, scn);
		}
	}

	private static Boolean readBoolean(Scanner scn) {
		Scanner s = scn;

		//Read input
		try {
			Boolean input = s.nextBoolean();
			return input;
		} 
		//Retry
		catch (Exception e) {
			scn.nextLine();
			return askT("Invalid input. Try Boolean value", Boolean.class, scn);
		}
	}
}

class AskEnumConst {
	
	static <T> T askEnumConstByIndex(String question, Class<T> returnType, Scanner scn) {
		T output;
		
		//Ask question
		System.out.println(question);

		//Check if enum has values
		if (returnType.getEnumConstants().length == 0) {
			System.out.println("No enum values");
			return null;
		}

		//List all enum values
		System.out.println("Enum values: ");
		T[] enumConstants = returnType.getEnumConstants();
		for (int i = 0; i < enumConstants.length; i++) {
			System.out.println(i + " - " + enumConstants[i] + " ");
		}

		//Ask for value index
		Integer choice = AskGeneric.askT("Choose an option", Integer.class, scn);
		if (choice >= 0 && choice < enumConstants.length) {
			output = enumConstants[choice];
		}
		//Retry
		else {
			output = askEnumConstByIndex("Invalid index. Try again", returnType, scn);
		}
		
		return output;
	}

	static <T> T askEnumConstByName(String question, Class<T> returnType, Scanner scn) {
		T output = null;

		System.out.println(question);

		//Check if enum has values
		if (returnType.getEnumConstants().length == 0) {
			System.out.println("No enum values");
			return null;
		}

		//List all enum values
		System.out.print("Enum values: ");
		T[] enumConstants = returnType.getEnumConstants();
		for (int i = 0; i < enumConstants.length; i++) {
			System.out.print(enumConstants[i]);
			if (i != enumConstants.length - 1) {
				System.out.print(" - ");
			}
			else {
				System.out.println();
			}
		}

		//Ask for string value
		String choice = AskGeneric.askT("Choose an option", String.class, scn);
		for (T t : enumConstants) {
			if (t.toString().equals(choice.toUpperCase())) {
				output = t;
				break;
			}
		}

		//If the input is not valid, ask again
		if (output == null) {
			return askEnumConstByName("Invalid option. Try again", returnType, scn);
		}

		return output;
	}
}

class AskListElement {

	static <T> T askListElementByIndex(String question, List<T> list, Scanner scn) {
		T output;
		
		//Ask question
		System.out.println(question);

		//Check if enum has values
		if (list.isEmpty()) {
			System.out.println("No list values");
			return null;
		}

		//List all enum values
		System.out.println("List values: ");
		for (T t : list) {
			System.out.println(t + " - " + list.indexOf(t) + " ");
		}

		//Ask for value index
		Integer choice = AskGeneric.askT("Choose an option", Integer.class, scn);
		if (choice >= 0 && choice < list.size()) {
			output = list.get(choice);
		}
		//Retry
		else {
			output = askListElementByIndex("Invalid index. Try again", list, scn);
		}
		
		return output;
	}
}

package consoleReader;

import java.util.Scanner;

public class ConsoleReader{

	public static <T> T askT(String question, Class<T> returnType) {
		T input = null;		

		System.out.println(question);
		
		switch (returnType.getSimpleName()) {
			case "Integer" -> input = returnType.cast(readInteger());
			case "Double" -> input = returnType.cast(readDouble());
			case "String" -> input = returnType.cast(readString());
			case "Character" -> input = returnType.cast(readCharacter());
			case "Boolean" -> input = returnType.cast(readBoolean());
			default -> System.out.println("Invalid type");
		}
		
		return input;
	}

	private static Integer readInteger() {
		Scanner scn = new Scanner(System.in);
		Integer input = null;

		if (scn.hasNextInt()) {
			input = scn.nextInt();
			scn.close();
			return input;
		}
		else {
			scn.close();
			return askT("Invalid input. Try Integer value", Integer.class);
		}
	}

	private static Double readDouble() {
		Scanner scn = new Scanner(System.in);
		Double input = null;

		if (scn.hasNextDouble()) {
			input = scn.nextDouble();
			scn.close();
			return input;
		}
		else {
			scn.close();
			return askT("Invalid input. Try Double value", Double.class);
		}
	}

	private static String readString() {
		Scanner scn = new Scanner(System.in);
		String input = null;

		if (scn.hasNext()) {
			input = scn.next();
			scn.close();
			return input;
		}
		else {
			scn.close();
			return askT("Invalid input. Try String value", String.class);
		}
	}

	private static Character readCharacter() {
		Scanner scn = new Scanner(System.in);
		Character input = null;

		if (scn.hasNext()) {
			input = scn.next().charAt(0);
			scn.close();
			return input;
		}
		else {
			scn.close();
			return askT("Invalid input. Try Character value", Character.class);
		}
	}

	private static Boolean readBoolean() {
		Scanner scn = new Scanner(System.in);
		Boolean input = null;

		if (scn.hasNextBoolean()) {
			input = scn.nextBoolean();
			scn.close();
			return input;
		}
		else {
			scn.close();
			return askT("Invalid input. Try Boolean value", Boolean.class);
		}
	}

	public static <T> T askEnumMemberByList(String question, Class<T> returnType) {
		T input = null;

		System.out.println(question);

		if (returnType.getEnumConstants()[0].toString().equals("A")) { 
			
		}

		System.out.print("Enum values:");
		T[] enumConstants = returnType.getEnumConstants();
		for (int i = 0; i < enumConstants.length; i++) {
			System.out.print(i + ". " + enumConstants[i] + " ");
		}
		Integer choice = askT("Choose an option", Integer.class);
		if (choice >= 0 && choice < enumConstants.length) {
			input = enumConstants[choice];
		}
		else {
			input = askEnumMemberByList("Invalid option. Try again", returnType);
		}
		return input;
	}
}

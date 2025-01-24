package juegosclase.haggle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class HaggleBot {
	public static void main(String[] args) {
		Integer name = ConsoleReader.askT("What is your name?", Integer.class);

		System.out.println("Hola "	+ name + ", bienvenido a HaggleBot");
	}
	
}

class Deal {
	Actor actor1;

	Actor actor2;

	int settledPrice;

	public static void MakeDeal(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Actor 1 set offer");
		int act1Price = scanner.nextInt();

		System.out.println("Actor 2 set offer");
		int act2Price = scanner.nextInt();
	}
}

class ConsoleReader{

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

	static Integer readInteger() {
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

	static Double readDouble() {
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

	static String readString() {
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

	static Character readCharacter() {
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

	static Boolean readBoolean() {
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
}

enum ActorActions {
	SELL,
	BUY
}

class Offer {
	Actor actor;
	int priceOffer;
	List<Article> articles;

	public Offer(Actor actor, int offer) {
		this.actor = actor;
		this.priceOffer = offer;
		this.articles = new ArrayList<>();
	}

	public Offer(Actor actor, int offer, List<Article> articles) {
		this.actor = actor;
		this.priceOffer = offer;
		this.articles = articles;
	}

	public static void main(String[] args) {
		
	}
}

class Actor {
	String name;
	int cash;
	List<Article> ownedArticles;

	public Actor(String name, int cash) {
        this.name = name;
        this.cash = cash;
        this.ownedArticles = new ArrayList<>();
    }
}

class Article {
	String name;
	int baseValue;
	public Article(String name, int baseValue) {
		this.name = name;
		this.baseValue = baseValue;
	}
}
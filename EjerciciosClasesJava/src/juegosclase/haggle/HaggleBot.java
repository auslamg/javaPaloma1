package juegosclase.haggle;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class HaggleBot {
	public static void main(String[] args) {
		//Integer name = ConsoleReader.askT("What is your name?", Integer.class);

		//System.out.println("Hola "	+ name + ", bienvenido a HaggleBot");
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
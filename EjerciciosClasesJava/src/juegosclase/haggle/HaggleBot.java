package juegosclase.haggle;

import gab.utils.console.ConsoleReader;
import java.util.Random;

@SuppressWarnings("unused")
public class HaggleBot {
	
	public static void main(String[] args) {
		
		boolean isTrading = true;

		float baseValue = 100;
		float maxValue = baseValue * 1.5f; //Initial value
		float minValue = baseValue *1.1f; //Minimum sell value to take

		float currentValue = maxValue;

		ActorActions myAction = null;

		while (isTrading) { 
			System.out.println("Current value is: " + currentValue);

			//Mayor que el minimo
			if (currentValue > minValue) {
				ConsoleReader c = new ConsoleReader();
				myAction = c.askEnumMemberByListIndex("What action do you want to make?", ActorActions.class); 
			}
			//Ultima oferta
			else {
				System.out.println("Price went below minPrice, finishing trading");
				isTrading = false; //Terminar

				ActorActions2 myLastAction = null;
				myLastAction = new ConsoleReader().askEnumMemberByListIndex("What action do you want to make?", ActorActions2.class); 

				//Ultima acción
				switch (myLastAction) {
					case BUY:
						isTrading = false;
						break;
					default:
						isTrading = false;
				}

				return;
			}

			//Acción
			switch (myAction) {
				case BUY -> {
					isTrading = false; //Terminar
				}
				case Lower_price -> {
					Random r = new Random();
					float randomNum = r.nextFloat(minValue,currentValue);
					float roundedNumber = 5*Math.round(randomNum/5);
					currentValue = roundedNumber;
				}
				default -> throw new AssertionError();
			}

			System.out.println("Current value is now: " + currentValue);
			if (!isTrading) {
				System.out.println("Trading has finished");
			}
		}
	}
}

enum ActorActions {
	BUY,
	Lower_price
}

enum ActorActions2 {
	BUY,
	LEAVE
}


/* 
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
} */
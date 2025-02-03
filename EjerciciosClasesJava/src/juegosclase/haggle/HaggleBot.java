package juegosclase.haggle;

import gab.util.console.ConsoleReader;
import java.util.ArrayList;
import java.util.List;
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

		enum SellerType {
			Modest(0,0,0),
			Trader(0,0,0),
			Hustler(0,0,0);

			int attempts;
			int morale;
			int startOfferMultiplier;

                private SellerType(int attempts, int morale, int startOfferMultiplier) {
					this.attempts = attempts;
					this.morale = morale;
					this.startOfferMultiplier = startOfferMultiplier;
                }
            }

		/* 
			 * SELLER
			 * 
			 * int attempts = [2-3] | [2-4] | [2-5]
			 * int morale = [80-90] | [65-80] | [50-70]
			 * int startOfferMultiplier = [1.1 - 1.3] | [1.3 - 1.7] | [1.7 - 2.5]
			 * 
			 * 
			 * 
			 */

			//Valor mayor que minimo
				//Preguntar acción

					//COMPRA
						//Terminar
						//Buyer.cash -= importe

					//REBAJA (Precio)
						//minPercentReduction = (currentValue/ - 100)/2
						//maxPercentReduction = 100 - Morale 

						//Increase = Random[20 - maxPercentReduction]
						//Valor -= Round5(Random)% * (maxValue - minValue)

						//M += Increase/2

					//LEAVE
						//Terminar

		while (isTrading) { 
			System.out.println("Current value is: " + currentValue);
			
			//Mayor que el minimo
			if (currentValue > minValue) {
				ConsoleReader c = new ConsoleReader();
				myAction = c.askEnumConstByIndex("What action do you want to make?", ActorActions.class); 
			}
			//Ultima oferta
			else {
				System.out.println("Price went below minPrice, finishing trading");
				isTrading = false; //Terminar

				ActorActions2 myLastAction = null;
				myLastAction = new ConsoleReader().askEnumConstByIndex("What action do you want to make?", ActorActions2.class); 

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

	void Leave() {

	}
}

class Buyer extends Actor {

	public Buyer(String name, int cash) {
		super(name, cash);
	}

	void Buy() {

	}

	void Bargain() {
		
	}
}

class Seller extends Actor {

	public Seller(String name, int cash) {
		super(name, cash);
	}

	void Yield() {

	}

	void Stand() {
		
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
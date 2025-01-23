package juegosclase.haggle;

import java.util.ArrayList;


public class HaggleBot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Actor player = new Actor("Player", false);
		Actor bot = new Actor("Bot", true);

		Article a1 = new Article("a1", 100, 1);
		Article a2 = new Article("a2", 200, 1);
		Article a3 = new Article("a3", 20, 3);
		Article a4 = new Article("a4", 50, 5);
		Article a5 = new Article("a5", 5, 10);

		bot.articles.add(a1);
		bot.articles.add(a2);
		bot.articles.add(a3);
		bot.articles.add(a4);
		bot.articles.add(a5);


	}
	
}

class Deal {
	Actor buyer;
	Actor seller;

	ArrayList<Article> articles;

	int settledPrice;

	int buyerLastOffer;
	int sellerLastOffer;

	public Deal(Actor buyer, Actor seller, ArrayList<Article> articles) {
		this.buyer = buyer;
		this.seller = seller;
		this.articles = articles;
	}

	public void strikeDeal() {
		for (Article article : articles) {
			buyer.articles.add(article);
			seller.articles.remove(article);
		}
	}

	public void refuseDeal() {
		buyer.articles.clear();
		seller.articles.clear();
	}

	public void yield(int amount) {
		for (Article article : articles) {
			buyer.articles.add(article);
			seller.articles.remove(article);
		}
	}

	public void stand() {
		settledPrice = 0; //Last offer
	}

	public void defy(int amount) {
		buyer.articles.clear();
		seller.articles.clear();
	}

	public void bundle(Article articleBundled, int addedPrice) {
		this.articles.add(articleBundled);
		settledPrice += addedPrice;		
	}
	public void bundle(ArrayList<Article> articlesBundled, int addedPrice) {
		for (Article a : articlesBundled) {
			this.articles.add(a);
		}
		settledPrice += addedPrice;
	}

}

enum ActorAction {
	StrikeDeal,
	RefuseDeal,
	Yield,
	Stand,
	Defy,
	Bundle
}

class Actor {
	String name;
	boolean isBuyer;

	ArrayList<Article> articles;

	public Actor(String name, boolean isBuyer) {
		this.name = name;
		this.isBuyer = isBuyer;
		articles = new ArrayList<>();
	}
}

class Article {
	String name;
	int baseValue;
	int count;
	public Article(String name, int baseValue, int count) {
		this.name = name;
		this.baseValue = baseValue;
		this.count = count;
	}
}
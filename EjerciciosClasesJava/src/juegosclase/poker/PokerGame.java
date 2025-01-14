package juegosclase.poker;

import java.util.ArrayList;
import java.util.Random;

public class PokerGame {

	public static void main(String[] args) {
		TestNextPlayer();
	}

	@SuppressWarnings("unused")
	static void TestRandomCards(){
		//Test for getting random cards
		Deck deck = new Deck();
		System.out.println(deck.takeRandomCard());
		System.out.println(deck.takeRandomCard());
	}
	@SuppressWarnings("unused")
	static void TestRearrangedPlayerList(){		
		//Test for rearranging playerList
		ArrayList<Player> testPlayerListArray = new ArrayList<>();
		testPlayerListArray.add(new Player("A", 1000));
		testPlayerListArray.add(new Player("B", 1000));
		testPlayerListArray.add(new Player("C", 1000));
		testPlayerListArray.add(new Player("D", 1000));
		PlayerList testPlayerList = new PlayerList(testPlayerListArray);

		Game round = new Game(testPlayerList);

		//Test RearrangedPlayerList()
		for (Player player : testPlayerList.list) {
			System.out.println(player.name);			
		}
	}
	@SuppressWarnings("unused")
	static void TestRearrangedPlayerList2(){		

		//Test for rearranging playerList
		ArrayList<Player> testPlayerListArray = new ArrayList<>();
		testPlayerListArray.add(new Player("A", 1000));
		testPlayerListArray.add(new Player("B", 1000));
		testPlayerListArray.add(new Player("C", 1000));
		testPlayerListArray.add(new Player("D", 1000));
		PlayerList testPlayerList = new PlayerList(testPlayerListArray);

		Game round = new Game(testPlayerList);

		//Test RearrangedPlayerList()
		for (Player player : testPlayerList.list) {
			System.out.println(player.name);			
		}

		//Test playerTurns values
		for (Player player : round.playersInTheTable.list) { //FIX
			System.out.println(player.name);			
		} 

		//Test share card distribution
		round.PlayRound(RoundType.Preflop);
		System.out.println(round.playingDeck.deckCards.size() + " cards in the deck");

		for (Card card : round.communityCards) {
			System.out.print(card.rank.symbol + card.suit.symbol + " ");
		} //TODO: TextMateScope for rank if possible
		System.out.println();

		round.dealer = round.playersInTheTable.list.get(0); //FIX
		System.out.println(round.dealer.name);

		round.roundCount = 3;
		round.dealer = round.playersInTheTable.list.get(0); //FIX
		round.PlayRound(RoundType.Preflop);
		System.out.println(round.dealer.name);
	}
	@SuppressWarnings("unused")
	static void TestNextPlayer() {

		//Test for nextPlayer playerList
		ArrayList<Player> testPlayerListArray = new ArrayList<>();
		testPlayerListArray.add(new Player("A", 1000));
		testPlayerListArray.add(new Player("B", 1000));
		testPlayerListArray.add(new Player("C", 1000));
		testPlayerListArray.add(new Player("D", 1000));
		PlayerList testPlayerList = new PlayerList(testPlayerListArray);

		System.out.println(testPlayerList.nextPlayer(testPlayerList.list.get(0),1).name ); 
	}
}


class Game {
	
	int roundCount = 1;

	int pot = 0;
	int lastBet = 0;

	int smallBlind = 1;
	int bigBlind = 2;
	
	protected Deck playingDeck;
	protected ArrayList<Card> communityCards;
	
	public PlayerList playersInTheTable;
	public PlayerList playersPlaying;

	Player dealer;	
	
	RoundType currentRoundType;
	
	
	Game(PlayerList players) {
		this.playingDeck = new Deck();
		this.playersInTheTable = players;
		this.playersPlaying = new PlayerList(players);
		this.communityCards = new ArrayList<>();
	}
	
	public void PlayRound(RoundType roundType) {
		
		//DEBUG
		if (roundType == null) {
			System.err.println("NO ROUND SPECIFIED");
			return;
		}
		
		switch (roundType) {
			case Preflop -> {
				playersPlaying = new PlayerList(playersInTheTable);
			
				//2 cards for each player
				for (Player p : playersPlaying.list) {
					p.holeCards.add(playingDeck.takeRandomCard());
					p.holeCards.add(playingDeck.takeRandomCard());
				}
				
				//Choose dealer
				//-Choose random dealer if in first round
				if (dealer == null) { 		
					dealer = playersPlaying.getRandomPlayer();
				}
				else {
					dealer = playersPlaying.previousPlayer(dealer);
				}

				//Small blind
				playersPlaying.currentPlayer = playersPlaying.nextPlayer(dealer);
				Player p = playersPlaying.currentPlayer;
				//Move(p, playersPlaying);


				//Start game
				//BetRound

				currentRoundType = RoundType.Flop;
			}
			
			case Flop -> {
				//5 cards in the middle (community cards)
				for (int i = 0; i < 5; i++) {
					communityCards.add(playingDeck.takeRandomCard());
				}
				currentRoundType = RoundType.Turn;
			}
			
			case Turn -> {

				currentRoundType = RoundType.River;
			}

			case River -> {

				currentRoundType = RoundType.Showdown;
			}

			case Showdown -> {

				currentRoundType = RoundType.Preflop;
				roundCount++;
			}

			case Discard -> {

			}
			
			default -> PlayRound(RoundType.Discard);
		}
		//TODO
		
	}

	public void ClearCards() {
		//Discard holeCards for each player
		for (Player p : playersInTheTable.list) {
			for (Card card : p.holeCards) {
				playingDeck.discardCard(card);
				p.holeCards.remove(card);				
			}
		}
		
		//Discard communityCards
		for (Card card : communityCards) {
			playingDeck.discardCard(card);
			communityCards.remove(card);				
		}
	}
}

@SuppressWarnings("unused")
class Move {

	int pot = 0;
	int lastBet = 0;

	int smallBlind = 1;
	int bigBlind = 2;
	
	protected Deck playingDeck;
	protected ArrayList<Card> communityCards;
	
	public PlayerList playersInTheTable;
	public PlayerList playersPlaying;

	Player dealer;	
	
	RoundType currentRound;
	
	
	Move(PlayerList players) {
		this.playingDeck = new Deck();
		this.playersInTheTable = players;
		this.playersPlaying = new PlayerList(players);
		this.communityCards = new ArrayList<>();
	}
	
	
	public void Move(Player p, PlayerList turns) {
		System.out.println("What move do you want to make? (/help for info)");

		enum MoveActions {
			Check,
			Bet,
			Call,
			Raise,
			Fold
		}

		MoveActions playedAction = MoveActions.Bet;
		int amount = 0;

		switch (playedAction) {
			case Check -> {
				//Finish turn
				turns.currentPlayer = turns.nextPlayer(p);
				turns.list.remove(p);				
			}

			case Bet -> {
				//Remove bet amount from player stash
				if (!(p.stash >= amount)) {
					break; //FIX
				}
				p.stash -= amount;				
				pot += amount; //Increase pot				
				lastBet += amount; //Increase bet

				//Select next player			
				Player nextPlayer = playersInTheTable.nextPlayer(playersPlaying.currentPlayer);
				
				//Restart round
				playersPlaying = new PlayerList(playersInTheTable.list);
				playersPlaying.list = playersPlaying.rearrangedPlayerList(playersPlaying.list, playersPlaying.list.indexOf(nextPlayer));				
			}

			case Call -> {

			}

			case Raise -> {
				Move(p, turns); //Call
			}

			case Fold -> {
				p.isPlaying = false;
			}

			default -> {
				Move(p, turns);
			}
		}

		p.hasMoved = true;
	}

	public void ClearCards() {
		//Discard holeCards for each player
		for (Player p : playersInTheTable.list) {
			for (Card card : p.holeCards) {
				playingDeck.discardCard(card);
				p.holeCards.remove(card);				
			}
		}
		
		//Discard communityCards
		for (Card card : communityCards) {
			playingDeck.discardCard(card);
			communityCards.remove(card);				
		}
	}
}

class PlayerList {
	public ArrayList<Player> list;
	public Player currentPlayer;
	
	public PlayerList(ArrayList<Player> list) {
		this(list, null);
	}
	public PlayerList(ArrayList<Player> list, Player currentPlayer) {
		this.list = new ArrayList<>(list);
		this.currentPlayer = currentPlayer;
	}
	public PlayerList(PlayerList playerList) {
		this.list = new ArrayList<>(playerList.list);

		if (playerList.currentPlayer != null) {
			int currentPlayerIndex = playerList.list.indexOf(playerList.currentPlayer);
			this.currentPlayer = this.list.get(currentPlayerIndex);
		}		
	}


	public Player getRandomPlayer() {
		Random rand = new Random();
		int randomIndex = rand.nextInt(list.size());
		return list.get(randomIndex);
	}

	public ArrayList<Player> rearrangedPlayerList(ArrayList<Player> playerList, int firstPlayerIndex) {
		ArrayList<Player> newList = new ArrayList<>();
		
		//Add all from the selected to the end
		for (int i = firstPlayerIndex; i < playerList.size(); i++) {
			newList.add(playerList.get(i));
		}
		//Add all from the start to the selected
		for (int i = 0; i < firstPlayerIndex; i++) {
			newList.add(playerList.get(i));
		}
		return newList;
	}

	public Player previousPlayer(Player p) {
		//DEBUG
		if (!list.contains(p)) {
			System.err.println("ERROR: Player is not part of the list");
			return null;
		}

		int selectedIndex;
		//If there are previous elements
		if (list.indexOf(p) > 0) {
			selectedIndex = list.indexOf(p) - 1;
			return list.get(selectedIndex);
		}
		else {
			selectedIndex = (list.size() - 1);
			return list.get(selectedIndex);
		}
	}

	public Player nextPlayer(Player p) {
		//DEBUG
		if (!list.contains(p)) {
			System.err.println("ERROR: Player is not part of the list");
			return null;
		}

		int selectedIndex;
		//If there are next elements
		if (list.indexOf(p) < (list.size() - 1)) {
			selectedIndex = list.indexOf(p) + 1;
			return list.get(selectedIndex);
		}
		else {
			selectedIndex = 0;
			return list.get(selectedIndex);
		}
	}

	public Player nextPlayer(Player p, int jumps) {
		//DEBUG
		if (!list.contains(p)) {
			System.err.println("ERROR: Player is not part of the list");
			return null;
		}

		int selectedIndex;
		//If there are next elements
		if (list.indexOf(p) < (list.size()) - jumps) {
			selectedIndex = list.indexOf(p) + jumps;
		}
		else {
			selectedIndex = list.indexOf(p) + jumps - list.size();
		}
		//While selected index exceeds size, size -= listSize
		while (selectedIndex > list.size()) { 
			selectedIndex %= list.size();
		}
		return list.get(selectedIndex);

	}
}

class Player {
	public String name;
	int stash = 200;
	int lastBet = 0;
	public boolean isPlaying = false;
	public boolean hasMoved = false;
	
	ArrayList<Card> holeCards;
	
    public Player(String name, int stash) {
		this.name = name;
		this.stash = stash;
		this.isPlaying = false;
		this.hasMoved = false;
		
		holeCards = new ArrayList<>();
    }
	

}

//FINISHED
final class Deck {
	ArrayList<Card> deckCards;
	
	//MARK: Deck
    public Deck() {
		deckCards = new ArrayList<>();
		
		//Add rank for each rank value
		for (Rank rank : Rank.values()) {
			//Add suit for each suit value
			for (Suit suit : Suit.values()) {
				//Add card of current rank and suit
				deckCards.add(new Card(rank, suit));
			}
		}
    }
	
	public Card takeRandomCard() {
		//Generate random card index
		Random rand = new Random();
		int randomIndex = rand.nextInt(deckCards.size());
		
		//Pick generated index
		Card returnCard = deckCards.get(randomIndex);
		//Remove generated index
		deckCards.remove(randomIndex);
		
		return returnCard;
	}
	
	public void discardCard(Card card) {
		deckCards.add(card);
	}
	
}

//FINISHED
final class Card {
	Rank rank;
	Suit suit;
	
	//MARK: Card
	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
}
		
enum RoundType {
	Preflop,
	Flop,
	Turn,
	River,
	Showdown,
	Discard
}

enum Rank {
	Ace ("A"),
	Two("2"),
	Three ("3"),
	Four ("4"),
	Five ("5"),
	Six ("6"),
	Seven ("7"),
	Eight ("8"),
	Nine ("9"),
	Ten ("10"),
	Jock ("J"),
	Queen ("Q"),
	King ("K");
	
	String symbol;
	Rank(String s) {
		symbol = s;
	}
}

enum Suit {
	Clubs ("-Tr"),
	Spades ("-Pi"),
	Hearts ("-Co"),
	Diamonds ("-Di");
	
	String symbol;
	Suit(String s) {
		symbol = s;
	}
}
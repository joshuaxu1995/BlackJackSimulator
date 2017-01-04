package Deck;
import Card.*;


import java.util.Collections;
import java.util.Stack;

public class Deck implements DeckPoller {
	
	Stack<Card> myCards;
	private int myDeckNum;
	public static int DECKSIZE;
	public static int CARDS_PER_DECK = 52;
	
	public Deck(int deckNum){
		myDeckNum = deckNum;
		DECKSIZE = CARDS_PER_DECK * deckNum;
		myCards = new Stack<Card>();
		resetDeck();
	}

	public void resetDeck() {
		for (int decks = 0; decks < myDeckNum; decks++){

			// TODO Auto-generated method stub
			for (int i = 1; i <= 13; i++){
				for (Suit suit: Suit.values()){
					Card newCard = new Card(suit,i);
					myCards.add(newCard);
				}
			}
			//		System.out.println(myCards);
		}
		shuffleDeck();
	}
	
	public Card seeTop(){
		return myCards.peek();
	}
	
	public void findAndRemoveCard(Card c){
//		System.out.println("Card.Card is " + c);
		boolean b = myCards.remove(c);
//		System.out.println("mycards size" + myCards.size() + "and removed was " + b);
		return;
	}

	public double deckPenetration(){
		return 1d -  myCards.size()/DECKSIZE;
	}

	public Card dealTop(){
		return myCards.pop();
	}
	
	public String toString(){
		return myCards.size() + myCards.toString();
	}
	
	public void shuffleDeck(){
		Collections.shuffle(myCards);
	}
	
}

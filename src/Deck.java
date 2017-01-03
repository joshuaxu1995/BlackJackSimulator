import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck implements DeckPoller {
	
	Stack<Card> myCards;
	
	public Deck(int deckNum){
		myCards = new Stack<Card>();
		createStandardDeck(deckNum);
	}

	private void createStandardDeck(int deckNum) {
		for (int decks = 0; decks < deckNum; decks++){

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
//		System.out.println("Card is " + c);
		boolean b = myCards.remove(c);
//		System.out.println("mycards size" + myCards.size() + "and removed was " + b);
		return;
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

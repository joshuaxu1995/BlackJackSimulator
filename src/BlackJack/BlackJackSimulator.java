package BlackJack;

import BlackJack.BlackJack;

public class BlackJackSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Card.Card c1 = new Card.Card(Card.Card.Suit.DIAMONDS, 1);
//		Card.Card c2 = new Card.Card(Card.Card.Suit.HEARTS, 1);
//		System.out.println(c1.equals(c2));
//		Card.Card c3 = new Card.Card(Card.Card.Suit.SPADES, 1);
//		BlackJack.BlackJack bj = new BlackJack.BlackJack(5, c1, c2, c3);
		BlackJack bj = new BlackJack(5, 10);
		bj.dealCards();
	}

	
}

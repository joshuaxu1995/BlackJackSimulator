package BlackJack;

import BlackJack.BlackJackPlayer;
import Card.Card;

public class BlackJackDealer extends BlackJackPlayer {

	public BlackJackDealer(Card cardHidden, Card card2Seen) {
		super(0, cardHidden, card2Seen);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("BlackJack.BlackJackDealer has ");
		sb.append(myHand);
		return sb.toString();
	}
	
	public Card getVisibleCard(){
		return myHand.getFirst();
	}
	

}

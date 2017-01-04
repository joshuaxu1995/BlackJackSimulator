package BlackJack;

import BlackJack.BlackJackPlayer;
import Card.Card;

public class BlackJackDealer extends BlackJackPlayer {

	public BlackJackDealer() {
		super(0, 0, 0);
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


public class Dealer extends Player {

	public Dealer(Card cardHidden, Card card2Seen) {
		super(0, cardHidden, card2Seen);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Dealer has ");
		sb.append(myHand);
		return sb.toString();
	}
	
	public Card getVisibleCard(){
		return myHand.getFirst();
	}
	

}

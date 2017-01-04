package Card;


public class Card {
	public int myValue;
	public Suit mySuit;
	

	public Card(Suit suit, int i) {
		// TODO Auto-generated constructor stub
		mySuit = suit;
		myValue = i;
	}
	
	@Override
	public String toString(){
		return (myValue + " of " + mySuit);
	}
	
	public int hashCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(myValue);
		sb.append(mySuit);
		return sb.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		Card c = (Card) o;
		return myValue == c.myValue && mySuit.equals(c.mySuit);
	}
	
}

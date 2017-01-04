import Card.*;
public class BlackJackCard extends Card {

	public BlackJackCard(Suit suit, int i) {
		super(suit, i);
		// TODO Auto-generated constructor stub
	}

	public int getTrueValue(){
		if (myValue >= 10){
			return 10;
		}
		else{
			return myValue;
		}
	}

}

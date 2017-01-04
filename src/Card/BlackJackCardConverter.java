package Card;

import Card.*;
public class BlackJackCardConverter {

	public static int getTrueValue(Card c){
		if (c.myValue >= 10){
			return 10;
		}
		else{
			return c.myValue;
		}
	}

}

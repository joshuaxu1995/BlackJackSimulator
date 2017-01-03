
public class BlackJackSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Card c1 = new Card(Suit.DIAMONDS, 1);
//		Card c2 = new Card(Suit.HEARTS, 1);
//		System.out.println(c1.equals(c2));
//		Card c3 = new Card(Suit.SPADES, 1);
//		BlackJack bj = new BlackJack(5, c1, c2, c3);
		BlackJack bj = new BlackJack(5);
		bj.dealCards();
	}

	
}

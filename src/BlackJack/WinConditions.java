package BlackJack;

import java.util.ArrayList;

public class WinConditions {
	
	public WinConditions(ArrayList<BlackJackPlayer> players, BlackJackDealer d){
		for (PlayerChanger bjp: players){
			double addScore = won(bjp,d) * bjp.getMyBet();
			bjp.alterScore(addScore);
			System.out.println("Hands here are " + bjp.getHands() + "and the size is " + bjp.getHands().size());
			System.out.println("The winnings or losings of player " + bjp.getID() + " is " + won(bjp,d)+ " and his newscore is " + bjp.getScore());
		}
		System.out.println("Dealers hand is " + d.getHands());
	}
	
	public double won(PlayerChanger p, BlackJackDealer d){
		double sum = 0;
//		System.out.println("Hands here are " + p.getHands() + "and the size is " + p.getHands().size());
		for (int i = 0; i < p.getHands().size(); i++) {
			if (p.busted(i) || p.surrendered(i)) {
				sum+= -1d;
			}
			else if (!p.busted(i) && d.busted(0)) {
				sum+= 1d;
			}
			else if (p.isBlackJack(i) && !d.isBlackJack(0)) {
				sum+= 1.5d;
			}
			else if (p.getSum(i) > d.getSum(0)) {
				sum+= 1d;
			} else if (p.getSum(i) < d.getSum(0)) {
				sum+= -1d;
			} else {
				sum+= 0d;
			}
		}
		return sum;
	}
	
}

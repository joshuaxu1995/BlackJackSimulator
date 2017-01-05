package BlackJack;

import java.util.ArrayList;

public class WinConditions {
	
	public WinConditions(ArrayList<BlackJackPlayer> players, BlackJackDealer d){
		for (PlayerChanger bjp: players){
			double addScore = won(bjp,d) * bjp.getMyBaseBet();
			bjp.alterScore(addScore);
			System.out.println("The winnings or losings of player " + bjp.getID() + " is " + won(bjp,d)+ " and his newscore is " + bjp.getScore());
		}
	}
	
	public double won(PlayerChanger p, BlackJackDealer d){
		double sum = 0;
		for (int i = 0; i < p.getScores().size(); i++) {
			if (p.busted(i)) {
				sum+= -1d;
			}
			if (!p.busted(i) && d.busted(i)) {
				sum+= 1d;
			}
			if (p.blackJack(i) && !d.blackJack(i)) {
				sum+= 1.5d;
			}
			if (p.getSum(i) > d.getSum(i)) {
				sum+= 1d;
			} else if (p.getSum(i) < d.getSum(i)) {
				sum+= -1d;
			} else {
				sum+= 0d;
			}
		}
		return sum;
	}
	
}

package BlackJack;

import java.util.ArrayList;

public class WinConditions {
	
	public WinConditions(ArrayList<BlackJackPlayer> players, BlackJackDealer d){
		for (PlayerChanger bjp: players){
			double addScore = won(bjp,d) * bjp.myBet();
			bjp.alterScore(addScore);
			System.out.println("The winnings or losings of player " + bjp.getID() + " is " + won(bjp,d)+ " and his newscore is " + bjp.getScore());
		}
	}
	
	public double won(PlayerChanger p, BlackJackDealer d){
		if (p.busted()){
			return -1;
		}
		if (!p.busted() && d.busted()){
			return 1;
		}
		if (p.blackJack() && !d.blackJack()){
			return 1.5;
		}
		if (p.getSum() > d.getSum()){
			return 1;
		}
		else if (p.getSum() < d.getSum()){
			return -1;
		}
		else{
			return 0;
		}
	}
	
}

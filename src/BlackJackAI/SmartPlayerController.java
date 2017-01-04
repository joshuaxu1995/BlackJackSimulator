package BlackJackAI;
import Card.*;
import Deck.*;
import BlackJack.*;
import Tools.*;

import java.util.List;

public class SmartPlayerController{
	
//	private int myOriginalBet;
	private List<String[]> optimalStrategy;
	
	public void printTable(List<String[]> table){
		for (String [] sTable: table){
			for (String s: sTable){
				System.out.print(s + " ");
			}
			System.out.println("");
		}
	}
	
	public SmartPlayerController(){
//		myOriginalBet = originalBet;
//		establishChart();
	}

	private void establishChart(HType type) {
		// TODO Auto-generated method stub
		TableParser tp = new TableParser();
		if (type == HType.HARD){
			optimalStrategy = tp.createTable("/BlackJackAI/HardTable.csv");
		}
		else{
			optimalStrategy = tp.createTable("/BlackJackAI/SoftTable.csv");
		}
//		System.out.println(optimalStrategy);
//		printTable(optimalStrategy);
//		for (int i = 4; i <= 21; i++){
//			for (int j = 1 ; j < 10; j++ ){
//				System.out.println("i: " + i + " j: " + j + " " + tp.tableLookUp(optimalStrategy, i, j));
//			}
//		}
	}

	public void makeDecision(BlackJackPlayer p, Card shownDealerCard, DeckPoller deckPoll){
		TableParser tp = new TableParser();
//		System.out.println("What is the score here " + p.getSum() + " " + shownDealerCard.myValue);
		establishChart(p.getType());
		System.out.println("Score " + p.getSum() + " BlackJack.BlackJackDealer: " + shownDealerCard.myValue);
		System.out.println("True value is " + BlackJackCardConverter.getTrueValue(shownDealerCard));
		String decision = tp.tableLookUp(optimalStrategy, p.getSum(), BlackJackCardConverter.getTrueValue(shownDealerCard));
		System.out.println("What is the hand here " + p);
		System.out.println("What is the decision here" + decision);
		int count = 0;
		while (count < 2) {
			if (decision.charAt(count) == 'S') {
				break;
			} else if (decision.charAt(count) == 'H') {
				while (decision.equals("H")) {
					p.hit(deckPoll.dealTop());
					establishChart(p.getType());
					decision = tp.tableLookUp(optimalStrategy, p.getSum(), BlackJackCardConverter.getTrueValue(shownDealerCard));
				}
				break;
			} else if (decision.charAt(count) == 'D') {
				if (!p.canSpecial()){
					count++;
				}
				else{
					p.doubleHand(deckPoll.dealTop());
					break;
				}
			}
			else if (decision.charAt(count) == 'R'){
				break;
			}
		}
		System.out.println("final hand of " + p);
		return;
	}

	
	
	
	
	
	
}

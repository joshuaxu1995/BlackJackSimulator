package BlackJackAI;
import Card.*;
import Deck.*;
import BlackJack.*;
import Tools.*;

import java.util.List;

public class SmartPlayerController{
	
//	private int myOriginalBet;
	private List<String[]> optimalStrategy;
	private BlackJackPlayer myPlayer;
	
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
	
//	public boolean busted(){
//		return myPlayer.busted();
//	}
	
	public void makeDecision(BlackJackPlayer p, Card shownDealerCard, DeckPoller deckPoll){
		myPlayer = p;
		TableParser tp = new TableParser();
//		System.out.println("What is the score here " + myPlayer.getSum() + " " + shownDealerCard.myValue);
		establishChart(myPlayer.getType());
		System.out.println("Score " + myPlayer.getSum() + " BlackJack.BlackJackDealer: " + shownDealerCard.myValue);
		System.out.println("True value is " + BlackJackCardConverter.getTrueValue(shownDealerCard));
		String decision = tp.tableLookUp(optimalStrategy, myPlayer.getSum(), BlackJackCardConverter.getTrueValue(shownDealerCard));
		System.out.println("What is the decision here" + decision);
		if (decision.charAt(0) =='S'){
		}
		else if (decision.charAt(0) == 'H'){
			while (decision.equals("H")){
				myPlayer.hit(deckPoll.dealTop());
				establishChart(myPlayer.getType());
				decision = tp.tableLookUp(optimalStrategy,myPlayer.getSum(), BlackJackCardConverter.getTrueValue(shownDealerCard));
			}
		}
		else if (decision.charAt(0) == 'D'){
			myPlayer.doubleHand(deckPoll.dealTop());
		}
		else if (decision.charAt(0) == 'R'){
		}
		System.out.println("final hand of " + myPlayer);
		return;
	}

	public BlackJackPlayer getPlayer() {
		// TODO Auto-generated method stub
		return myPlayer;
	}
	
	
	
	
	
	
	
}

package BlackJackAI;

import Deck.*;
import BlackJack.*;

import java.util.List;

public class SoftDealerController {

	private List<String[]> optimalStrategy;
	private BlackJackDealer myDealer;
	
	public void printTable(List<String[]> table){
		for (String [] sTable: table){
			for (String s: sTable){
				System.out.print(s + " ");
			}
			System.out.println("");
		}
	}
	
	public SoftDealerController(BlackJackDealer d){
		myDealer = d;
		establishChart();
	}

	private void establishChart() {
		// TODO Auto-generated method stub
//		TableParser tp = new TableParser();
//		optimalStrategy = tp.createTable("/BlackJackAI/HardTable.csv");
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
	
	public void makeDecision(DeckPoller deckPoll){
		if (myDealer.getSum() < 17){
			myDealer.hit(deckPoll.dealTop());
		}
		System.out.println("final hand of dealer is " + myDealer.toString());
	}

	public BlackJackDealer getDealer() {
		// TODO Auto-generated method stub
		return myDealer;
	}
	

}

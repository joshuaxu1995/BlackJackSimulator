package BlackJackAI;

import Card.*;
import Deck.*;
import BlackJack.*;
import Tools.*;

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
	
	public SoftDealerController( Card c1, Card c2){
		myDealer = new BlackJackDealer(c1, c2);
		establishChart();
	}

	private void establishChart() {
		// TODO Auto-generated method stub
		TableParser tp = new TableParser();
		optimalStrategy = tp.createTable("/BlackJackAI/HardTable.csv");
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
		if (myDealer.getScore() < 17){
			myDealer.hit(deckPoll.dealTop());
		}
	}

	public BlackJackDealer getDealer() {
		// TODO Auto-generated method stub
		return myDealer;
	}
	

}

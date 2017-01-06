package BlackJackAI;
import Card.*;
import Deck.*;
import BlackJack.*;
import Tools.*;

import java.util.List;

public class SmartPlayerController{
	
//	private int myOriginalBet;
	private List<String[]> softChart;
	private List<String[]> hardChart;
	private List<String[]> splitsChart;
	
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
		establishCharts();
	}

	private void establishCharts() {
		// TODO Auto-generated method stub
		TableParser tp = new TableParser();
		hardChart = tp.createTable("/BlackJackAI/HardTable.csv");
		softChart = tp.createTable("/BlackJackAI/SoftTable.csv");
		splitsChart = tp.createTable("/BlackJackAI/Splits.csv");
//		System.out.println(optimalStrategy);
//		printTable(softChart);
//		printTable( hardChart);
//		printTable(splitsChart);
//		for (int i = 4; i <= 21; i++){
//			for (int j = 1 ; j < 10; j++ ){
//				System.out.println("i: " + i + " j: " + j + " " + tp.tableLookUp(optimalStrategy, i, j));
//			}
//		}
	}

	private boolean decideSplit(BlackJackPlayer p, Card shownDealerCard){
		TableParser tp = new TableParser();
//		String chartVal = tp.tableLookUp(splitsChart, 1, BlackJackCardConverter.getTrueValue(shownDealerCard));
		String chartVal = tp.tableLookUp(splitsChart, p.splitVal(), BlackJackCardConverter.getTrueValue(shownDealerCard));
//		System.out.println("splits val here is " + chartVal);
		if (p.splitVal()!= -1 && chartVal.equals("Y")){
			return true;
		}
		else{
			return false;
		}
	}

	private List<String[]> returnCorrectChart(HType type){
		if (type.equals(HType.HARD)){
			return hardChart;
		}
		else{
			return softChart;
		}
	}


	public void makeDecision(BlackJackPlayer p, Card shownDealerCard, DeckPoller deckPoll){
		TableParser tp = new TableParser();
		while (!p.queueEmpty()) {
		System.out.println("What is the score here " + p.getCurrentSum() + " " + shownDealerCard.myValue);
			List<String[]> chart = returnCorrectChart(p.getCurrentType());
		System.out.println("Score " + p.getCurrentSum() + " BlackJack.BlackJackDealer: " + shownDealerCard.myValue);
		System.out.println("True value is " + BlackJackCardConverter.getTrueValue(shownDealerCard));
			String decision = tp.tableLookUp(chart, p.getCurrentSum(), BlackJackCardConverter.getTrueValue(shownDealerCard));
		System.out.println("What is the hand here " + p);
		System.out.println("What is the decision here" + decision);
			if (decideSplit(p, shownDealerCard)) {
				System.out.println("SPLIT HERE " + p);
				split(p, deckPoll);
				continue;
			}
			int count = 0;
			while (count < 2) {
				if (decision.charAt(count) == 'S') {
					break;
				} else if (decision.charAt(count) == 'H') {
					while (decision.equals("H")) {
						p.hit(deckPoll.dealTop());
//						System.out.println(p + " is p");
						chart = returnCorrectChart(p.getCurrentType());
						decision = tp.tableLookUp(chart, p.getCurrentSum(), BlackJackCardConverter.getTrueValue(shownDealerCard));
//					System.out.println("The decision after hitting many times is " + decision);
					}
					break;
				} else if (decision.charAt(count) == 'D') {
					if (!p.canSpecial()) {
						count++;
					} else {
						p.doubleHand(deckPoll.dealTop());
						break;
					}
				} else if (decision.charAt(count) == 'R') {
					break;
				}
			}
			p.finishHand();
		}

//		System.out.println("final hand of " + p);
		return;
	}

	private void split(BlackJackPlayer p, DeckPoller deckPoller) {
		p.splitHand(deckPoller.dealTop(), deckPoller.dealTop());
	}

	private void playHand(){

	}
	
	
	
	
	
}

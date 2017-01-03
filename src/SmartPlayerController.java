import java.util.List;

public class SmartPlayerController{
	
	private int myOriginalBet;
	private List<String[]> optimalStrategy;
	private Player myPlayer;
	
	public void printTable(List<String[]> table){
		for (String [] sTable: table){
			for (String s: sTable){
				System.out.print(s + " ");
			}
			System.out.println("");
		}
	}
	
	public SmartPlayerController(int originalBet, int playerNum, Card c1, Card c2){
		myOriginalBet = originalBet;
		myPlayer = new Player(playerNum, c1, c2);
//		establishChart();
	}

	private void establishChart(HType type) {
		// TODO Auto-generated method stub
		TableParser tp = new TableParser();
		if (type == HType.HARD){
			optimalStrategy = tp.createTable("HardTable.csv");	
		}
		else{
			optimalStrategy = tp.createTable("SoftTable.csv");	
		}
//		System.out.println(optimalStrategy);
		printTable(optimalStrategy);
//		for (int i = 4; i <= 21; i++){
//			for (int j = 1 ; j < 10; j++ ){
//				System.out.println("i: " + i + " j: " + j + " " + tp.tableLookUp(optimalStrategy, i, j));
//			}
//		}
	}
	
//	public boolean busted(){
//		return myPlayer.busted();
//	}
	
	public void makeDecision(Card shownDealerCard, DeckPoller deckPoll){
		TableParser tp = new TableParser();
//		System.out.println("What is the score here " + myPlayer.getScore() + " " + shownDealerCard.myValue);
		establishChart(myPlayer.getType());
		System.out.println("Score " + myPlayer.getScore() + " Dealer: " + shownDealerCard.myValue);
		String decision = tp.tableLookUp(optimalStrategy, myPlayer.getScore(), shownDealerCard.myValue);
//		System.out.println("What is the decision here" + decision);
		if (decision.charAt(0) =='S'){
		}
		else if (decision.charAt(0) == 'H'){
			while (decision.equals("H")){
				myPlayer.hit(deckPoll.dealTop());
				establishChart(myPlayer.getType());
				decision = tp.tableLookUp(optimalStrategy,myPlayer.getScore(), shownDealerCard.myValue);
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

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return myPlayer;
	}
	
	
	
	
	
	
	
}

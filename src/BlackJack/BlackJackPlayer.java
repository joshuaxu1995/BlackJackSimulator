package BlackJack;

import Card.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BlackJackPlayer implements PlayerChanger {
	
	private int myPlayerNum; 
	protected Queue<Hand> myHands;
	private List<Hand> processedHands;
	private double myScore;
	private double myBaseBet;
	private double myBet;
	private boolean surrendered;
	
	public BlackJackPlayer(int playerNum, double initScore, double initBet){
		myBaseBet = initBet;
		myScore = initScore;
		myPlayerNum = playerNum;
		myHands = new LinkedList<Hand>();
		processedHands = new ArrayList<Hand>();
	}

	public void establishHand(Card c1, Card c2){
		myHands.offer(new Hand(c1, c2));
		myBet = myBaseBet;
		surrendered = false;
	}

	public void alterScore(double score){ myScore += score;}
	
	public void hit(Card addCard){
		myHands.peek().addCard(addCard);
	}
	
	public void doubleHand(Card addCard){
		hit(addCard);
		myBet = myBet*2;
	}

	public void surrender(){
		myBet = 1/2* myBet;
		surrendered = true;
	}

	public HType getCurrentType(){
		return myHands.peek().getHandInfo().myType;
	}

	public int getCurrentSum(){
		return myHands.peek().getHandInfo().mySum;
	}

	public void splitHand( Card c1, Card c2){
		Hand h= myHands.poll();
		ArrayList<Card> c = h.getCards();
		Hand h1 = new Hand(c1, c.get(0));
		Hand h2 = new Hand(c2, c.get(1));
		myHands.offer(h1);
		myHands.offer(h2);
	}

	public int splitVal(){
		if (canSpecial() && myHands.peek().sameValue()){
			return myHands.peek().getCards().get(0).myValue;
		}
		return -1;
	}

	public void resetHands(){
		myHands.clear();
		processedHands.clear();
	}

	public double getMyBet(){
		return myBet;
	}

	public void finishHand(){
		Hand h = myHands.poll();
		processedHands.add(h);
	}

	public double getScore(){
		return myScore;
	}

	public void stay(){
		return;
	}
	
	public boolean canSpecial(){
		return myHands.peek().handSize() == 2;
	}

	public boolean queueEmpty(){
		return myHands.isEmpty();
	}

	public boolean surrendered(int handNum){
		return surrendered;
	}

	public boolean busted(int handNum){
		return processedHands.get(handNum).busted();
	}

	public List<Hand> getHands() {
		return processedHands;
	}
	
	public boolean isBlackJack(int handNum){
		return processedHands.get(handNum).blackJack();
	}


	public int getSum(int handNum){
		return processedHands.get(handNum).getHandInfo().mySum;
	}

	@Override
	public int getID() {
		return myPlayerNum;
	}

	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("BlackJack.BlackJackPlayer " + myPlayerNum + " has ");
		sb.append(myHands);
		return sb.toString();
	}

}

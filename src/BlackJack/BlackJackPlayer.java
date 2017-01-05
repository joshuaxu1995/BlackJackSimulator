package BlackJack;

import Card.*;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer implements PlayerChanger {
	
	private int myPlayerNum; 
	protected List<Hand> myHands;
	private double myScore;
	private double myBaseBet;
	private double myBet;
	
	public BlackJackPlayer(int playerNum, double initScore, double initBet){
		myBaseBet = initBet;
		myScore = initScore;
		myPlayerNum = playerNum;
		myHands = new ArrayList<Hand>();
	}

	public void establishHand(Card c1, Card c2){
		myHands.add(new Hand(c1, c2));
	}

	public void alterScore(double score){ myScore += score;}
	
	public void hit(int handNum, Card addCard){
		myHands.get(handNum).addCard(addCard);
	}
	
	public void doubleHand(int handNum, Card addCard){
		hit(handNum, addCard);
	}

	public void resetHands(){
		myHands.clear();
	}

	public double getMyBaseBet(){
		return myBet;
	}

	public void splitHand(int handNum, Card c1, Card c2){
		Hand h= myHands.get(handNum);
		ArrayList<Card> c = h.getCards();
		Hand h1 = new Hand(c1, c.get(0));
		Hand h2 = new Hand(c2, c.get(1));
		myHands.remove(h);
		myHands.add(h1);
		myHands.add(h2);
	}

	public boolean canSplit(int handNum){
		if (canSpecial(0) && myHands.get(handNum).sameValue()){
			return true;
		}
		return false;
	}

	public double getScore(){
		return myScore;
	}

	@Override
	public List<Integer> getScores() {
		List<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < myHands.size(); i++){
			newList.add(getSum(i));
		}
		return newList;
	}

	public void stay(){
		return;
	}
	
	public boolean canSpecial(int handNum){
		return myHands.get(handNum).handSize() == 2;
	}
	
	public boolean busted(int handNum){
		return myHands.get(handNum).busted();
	}
	
	public void surrender(){}
	
	public boolean blackJack(int handNum){
		return myHands.get(handNum).blackJack();
	}
	
	public int getSum(int handNum){
		return myHands.get(handNum).getHandInfo().mySum;
	}

	@Override
	public int getID() {
		return myPlayerNum;
	}

	public HType getType(int handNum){
		return myHands.get(handNum).getHandInfo().myType;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("BlackJack.BlackJackPlayer " + myPlayerNum + " has ");
		sb.append(myHands);
		return sb.toString();
	}


	public void alterBet(double multiplier) {
		myBet = multiplier * myBaseBet;
	}
}

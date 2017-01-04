package BlackJack;

import Card.*;

public class BlackJackPlayer implements PlayerChanger {
	
	private int myPlayerNum; 
	protected Hand myHand;
	private double myScore;
	private double myBet;
	
	public BlackJackPlayer(int playerNum, double initScore, double initBet){
		myBet = initBet;
		myScore = initScore;
		myPlayerNum = playerNum;
	}

	public void establishHand(Card c1, Card c2){
		myHand = new Hand(c1, c2);
	}

	public void alterScore(double score){ myScore += score;}
	
	public void hit(Card addCard){
		myHand.addCard(addCard);
	}
	
	public void doubleHand(Card addCard){
		hit(addCard);
	}

	public double myBet(){
		return myBet;
	}

	public void splitHand(Card c1, Card c2){
		
	}

	public boolean canSplit(){
		if (canSpecial() && myHand.sameValue()){
			return true;
		}
		return false;
	}

	public double getScore(){
		return myScore;
	}

	public void stay(){
		return;
	}
	
	public boolean canSpecial(){
		return myHand.handSize() == 2;
	}
	
	public boolean busted(){
		return myHand.busted();
	}
	
	public void surrender(){}
	
	public boolean blackJack(){
		return myHand.blackJack();
	}
	
	public int getSum(){
		return myHand.getHandInfo().mySum;
	}

	@Override
	public int getID() {
		return myPlayerNum;
	}

	public HType getType(){
		return myHand.getHandInfo().myType;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("BlackJack.BlackJackPlayer " + myPlayerNum + " has ");
		sb.append(myHand);
		return sb.toString();
	}
	
	
}

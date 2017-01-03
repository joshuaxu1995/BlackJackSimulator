
public class Player {
	
	private int myPlayerNum; 
	protected Hand myHand;
	protected int playerLimit;
	
	public Player(int playerNum, Card card1, Card card2){
		myHand = new Hand(card1, card2);
		myPlayerNum = playerNum;
		playerLimit = 16;
	}
	
	public void hit(Card addCard){
		myHand.addCard(addCard);
	}
	
	public void doubleHand(Card addCard){
		hit(addCard);
	}
	
	public void splitHand(){
		
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
	
	public void surrender(){
		
	}
	
	public boolean blackJack(){
		return myHand.blackJack();
	}
	
	public int getScore(){
		return myHand.getHandInfo().mySum;
	}
	
	public HType getType(){
		return myHand.getHandInfo().myType;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Player " + myPlayerNum + " has ");
		sb.append(myHand);
		return sb.toString();
	}
	
	
}

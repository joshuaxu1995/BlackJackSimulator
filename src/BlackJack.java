import java.util.ArrayList;

public class BlackJack {

	
	private ArrayList<SmartPlayerController> players;
	private Deck deck1;

	
	public BlackJack(int numPlayers){
		players = new ArrayList<SmartPlayerController>();
		deck1 = new Deck(4);
		SoftDealerController d = new SoftDealerController(deck1.dealTop(), deck1.dealTop());
		boolean allBusted = false;
		for (int i =1; i < numPlayers; i++){
			SmartPlayerController p = new SmartPlayerController(10,i+1, deck1.dealTop(), deck1.dealTop());
			p.makeDecision(d.getDealer().getVisibleCard(), deck1);
			if (!p.getPlayer().busted()){
				allBusted = true;
			}
			players.add(p);
		}
		if (allBusted){
			d.makeDecision(deck1);
		}
		
	}	
	
	public BlackJack(int numPlayers, Card playerCard1, Card playerCard2, Card dealerCard){
		players = new ArrayList<SmartPlayerController>();
		deck1 = new Deck(4);
		SmartPlayerController me = new SmartPlayerController(10, 1, playerCard1, playerCard2);
		System.out.println(me);
		SoftDealerController d = new SoftDealerController(dealerCard, deck1.dealTop());
		System.out.println(d);
		players.add(me);
		deck1.findAndRemoveCard(playerCard1);
		deck1.findAndRemoveCard(playerCard2);
		deck1.findAndRemoveCard(dealerCard);
		for (int i =1; i < numPlayers; i++){
			SmartPlayerController p = new SmartPlayerController(10, i+1, deck1.dealTop(), deck1.dealTop());
			p.makeDecision(dealerCard, deck1);
//			System.out.println(p);
			players.add(p);
		}
//		System.out.println(deck1);
//		players.add(d);
	}
	
	public void dealCards(){
//		System.out.println("DEALING CARDS BELOW");
//		for (Player p: players){
//			if (!p.limReached() && !p.busted()){
//				p.hit(deck1.dealTop());
//			}
//			System.out.println(p);
//		}
	}
	
 
}

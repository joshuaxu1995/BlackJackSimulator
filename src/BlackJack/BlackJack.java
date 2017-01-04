package BlackJack;

import Card.*;
import Deck.*;
import BlackJackAI.*;

import java.util.ArrayList;

public class BlackJack {

	
	private ArrayList<BlackJackPlayer> players;
	private Deck deck1;
	private BlackJackDealer dealer;
	public static final double BET = 5;
	public static final double SCORE = 100;
	
	public BlackJack(int numPlayers, int numHands){
		initialize(numPlayers);
		playHands(numHands);
	}

	public void initialize(int numPlayers){
		players = new ArrayList<BlackJackPlayer>();
		deck1 = new Deck(4);
		dealer = new BlackJackDealer();
		for (int i =0; i < numPlayers; i++){
			BlackJackPlayer p = new BlackJackPlayer(i+1, SCORE, BET);
			players.add(p);
		}
	}

	private void playHands(int numHands){
		for (int i =0 ; i < numHands; i++){
			playSingleHand();
		}
	}

	private void playSingleHand(){
		if (deck1.deckPenetration() > 0.25){
			deck1.resetDeck();
		}
		boolean allBusted = false;
		dealer.establishHand(deck1.dealTop(), deck1.dealTop());
		SmartPlayerController ai = new SmartPlayerController();
		SoftDealerController d = new SoftDealerController(dealer);
		for (BlackJackPlayer p: players){
			p.establishHand(deck1.dealTop(), deck1.dealTop());
			ai.makeDecision(p,dealer.getVisibleCard(), deck1);
			if (!p.busted()){
				allBusted = true;
			}
		}
		if (allBusted){
			d.makeDecision(deck1);
		}
		WinConditions wc = new WinConditions(players, dealer);
	}
	
	public BlackJack(int numPlayers, Card playerCard1, Card playerCard2, Card dealerCard){
//		BlackJackPlayer me = new BlackJackPlayer(1, SCORE, BET, playerCard1, playerCard2);
//		System.out.println(me);
//		BlackJackDealer dealer = new BlackJackDealer(dealerCard, deck1.dealTop());
//		SoftDealerController d = new SoftDealerController(dealer);
//		System.out.println(d);
//		players.add(me);
		deck1.findAndRemoveCard(playerCard1);
		deck1.findAndRemoveCard(playerCard2);
		deck1.findAndRemoveCard(dealerCard);
	}
	
	public void dealCards(){
//		System.out.println("DEALING CARDS BELOW");
//		for (BlackJack.BlackJackPlayer p: players){
//			if (!p.limReached() && !p.busted()){
//				p.hit(deck1.dealTop());
//			}
//			System.out.println(p);
//		}
	}
	
 
}

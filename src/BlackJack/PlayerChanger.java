package BlackJack;

import Card.Hand;

import java.util.List;

/**
 * Created by joshuaxu on 1/3/17.
 */
public interface PlayerChanger {
    public double getMyBet();
    public boolean surrendered(int handNum);
    public boolean isBlackJack(int handNum);
    public boolean busted(int handNum);
    public int getSum(int handNum);
    public int getID();
    public double getScore();
    public List<Hand> getHands();
    public void alterScore(double scoreChange);
}

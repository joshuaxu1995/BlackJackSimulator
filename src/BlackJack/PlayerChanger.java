package BlackJack;

import java.util.List;

/**
 * Created by joshuaxu on 1/3/17.
 */
public interface PlayerChanger {

    public double getMyBaseBet();
    public boolean blackJack(int handNum);
    public boolean busted(int handNum);
    public int getSum(int handNum);
    public int getID();
    public double getScore();
    public List<Integer> getScores();
    public void alterScore(double scoreChange);
}

package BlackJack;

/**
 * Created by joshuaxu on 1/3/17.
 */
public interface PlayerChanger {

    public double myBet();
    public boolean blackJack();
    public boolean busted();
    public int getSum();
    public int getID();
    public double getScore();
    public void alterScore(double scoreChange);
}


public class WinConditions {
	
	public WinConditions(){
		
	}
	
	public double won(Player p, Dealer d){
		if (p.busted()){
			return 0;
		}
		if (!p.busted() && d.busted()){
			return 2;
		}
		if (p.blackJack() && !d.blackJack()){
			return 2.5;
		}
//		if (p.score > d.score){
//			return 2;
//		}
//		else if (p.score < d.score){
//			return 0;
//		}
		else{
			return 1;
		}
	}
	
}

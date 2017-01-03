
public class HandInfo {
	HType myType;
	int mySum;
	
	public HandInfo(HType h, int sum){
		myType = h;
		mySum = sum;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Sum: " + mySum + " Type: " + myType);
		return sb.toString();
	}
}

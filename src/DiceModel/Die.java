package DiceModel;

public class Die {
	public int faceValue = 0;
	
	int roll() {
		faceValue = (int) (Math.random()*6)+1;
		return faceValue;
	}
}
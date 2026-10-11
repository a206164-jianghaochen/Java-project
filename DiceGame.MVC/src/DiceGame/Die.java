package DiceGame;

import java.util.Random;

public class Die {
	private int faceValue;
	
	public void roll() {
		Random rn = new Random();
		faceValue = rn.nextInt(6) + 1;
	}
	
	public int getFaceValue() {
		return faceValue;
	}
}

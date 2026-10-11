package DiceGame;

public class DiceGame {
	private Die die1 = new Die();
	private Die die2 = new Die();
	
	private int fv1, fv2;
	
	public void play() {
		die1.roll();
		fv1 = die1.getFaceValue();
		
		die2.roll();
		fv2 = die2.getFaceValue();
	}
	
	public Die getDie1() {
		return die1;
	}
	
	public Die getDie2() {
		return die2;
	}
	
	public String getResult() {
		if ((fv1 + fv2) >= 7)
			return "You won!";
		
		return "You lost!";
	}
}


package refactoringTest3;

public class currentAccount extends Account {
	private final double LIMIT = -500.00;
	
	
	public boolean withdraw(double amount) {
		
			if ((balance - amount) > LIMIT) {
				balance = balance - amount;
				return true;
			}
			return false;
		}
	
}

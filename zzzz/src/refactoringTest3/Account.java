package refactoringTest3;

public abstract class Account {
	protected double balance;		
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public abstract boolean withdraw(double amount);		
		
}

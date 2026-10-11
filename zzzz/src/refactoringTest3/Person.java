package refactoringTest3;

public class Person {
	private String name;
	private Account account;
	
	public Person(String name, Account account) {
		this.name = name;
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	
	public void depositMoney(double amount) {
		account.deposit(amount);
	}
	
	public double getBalance() {
		return account.getBalance();
	}
	
	public boolean withdraw(double amount) {
		return account.withdraw(amount);
	}
}

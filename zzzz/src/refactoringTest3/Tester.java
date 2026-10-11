package refactoringTest3;

public class Tester {	
	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.runExample();
	}
	
	public void runExample() {
		Account acc1 = new savingAccount();
		Account acc2 = new savingAccount();		
				
		Person p1 = new Person("Tom", acc1);		
		depositPersonMoney(p1, 1000.00);
		withdrawPersonMoney(p1, 700.00);
		withdrawPersonMoney(p1, 500.00);
		
		Person p2 = new Person("Jack", acc2);
		depositPersonMoney(p2, 1000.00);
		withdrawPersonMoney(p2, 700.00);
		withdrawPersonMoney(p2, 500.00);
	}
	
	public void depositPersonMoney(Person p, double amount) {
		System.out.println("\nBefore deposit, "+p.getName()+" has RM"+p.getBalance());
		p.depositMoney(amount);
		System.out.println("After deposit, "+p.getName()+" has RM"+p.getBalance());
	}
	
	public void withdrawPersonMoney(Person p, double amount) {
		System.out.println("\nBefore withdrawal, "+p.getName()+" has RM"+p.getBalance());
		
		if (p.withdraw(amount))
			System.out.println("After withdrawal, "+p.getName()+" has RM"+p.getBalance());
	
		else
			System.out.println("Withdrawal failed. "+p.getName()+" still has RM"+p.getBalance());
	}
}

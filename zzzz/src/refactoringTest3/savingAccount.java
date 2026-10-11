package refactoringTest3;

public class savingAccount extends Account {
	     
       

 public boolean withdraw(double amount) {
	
			if (balance >= amount) {
				balance = balance - amount;
				return true;
			}
			return false;
		}
 }
 
package driver;
import java.util.Scanner;
public class BankAccountApp {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String Bankacc1 = sc.next();
		 double balance1 = sc.nextDouble();
		 BankAccount bankAccount1 = new BankAccount(Bankacc1, balance1);
		 double depamount1 = sc.nextDouble();
		 double withdrawamount1 = sc.nextDouble();
		 double transferamount1 = sc.nextDouble();
		 bankAccount1.deposit(depamount1);
		 bankAccount1.withdraw(withdrawamount1);
		 System.out.printf("Account 1 Balance: %.1f", bankAccount1.transfer(bankAccount1, transferamount1));	 
		 String Bankacc2 = sc.next();
		 double balance2 = sc.nextDouble();
		 BankAccount bankAccount2 = new BankAccount(Bankacc2, balance2);
		 double depamount2 = sc.nextDouble();
		 double withdrawamount2 = sc.nextDouble();
		 double transferamount2 = sc.nextDouble();
		 bankAccount2.deposit(depamount2);
		 bankAccount2.withdraw(withdrawamount2);
		 System.out.printf("Account 2 Balance: %.1f", bankAccount2.transfer(bankAccount2, transferamount2));	 
	 }
}
   class BankAccount{
	   String accountNumber;
	   double balance;	   
	   public BankAccount(String Bankacc, double balance ) {
		   this.accountNumber = Bankacc;
		   this.balance = balance;	   
	   }
	     public void deposit(double amount) {
	    	 balance = balance + amount;	    	 	    	 
	     }	     
	     public void withdraw(double amount) {
	    	 balance = balance - amount;	    	 	    	 	    	 
	     }
	  public double transfer(BankAccount targetAccount, double amount) {
		 return balance - amount;  
	  }  
   }

package driver;
import java.text.DecimalFormat;
import java.util.Scanner;

public class eWalletApp {
	public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		 DecimalFormat df = new DecimalFormat("0.00");
		 eWalletAccount account = new eWalletAccount();
		  
		 int N = sc.nextInt(); // N refers to the number of transactions.
		 for(int i = 0; i < N; i++) {
		 int option = sc.nextInt();
		 
		 double amountOfBalance;
		 switch(option) {
		 case 1:
			 amountOfBalance = sc.nextDouble();
			 account.topupAccount(amountOfBalance);
		 System.out.println("Balance :" + df.format(account.getBalance()));
		 break;
		 case 2:
		 amountOfBalance = sc.nextDouble();
		 account.payService(amountOfBalance);
		 System.out.println(account.toString());
         break;
		 case 3:
			 amountOfBalance = sc.nextDouble();
             account.transfer(amountOfBalance);
             System.out.println(account.toString());
             break;
		 case 4:
			 System.out.println(account.toString());
             break;
         default:
             System.out.println("Invalid Operation");
             break;
		 }
		 }
		 
	}
}
     class eWalletAccount {
    	  double balance;
    	  double cashback;
    	  
    	  public eWalletAccount() {
    	 this.balance = 0.0;
    	 this.cashback = 0.0;
    	  }
    	 public void topupAccount(double amount) {
    	         this.balance = balance + amount;
    	 }
    	 public void payService(double amountOfBalance) {
    	      if(balance >= amountOfBalance) {
    	 this.balance = balance - amountOfBalance;
    	 addCashback(amountOfBalance);
    	      } else {
    	            System.out.println("Transaction failed!");
    	        }
    	    }
    	 public void transfer(double amountOfBalance) {
    	        if (balance >= amountOfBalance) {
    	            this.balance = balance - amountOfBalance;
    	            this.cashback += 0.10;
    	        } else {
    	            System.out.println("Transaction failed!");
    	        }
    	    }
    	 private void addCashback(double amount) {
    	        if (amount >= 2.00) {
    	            this.cashback += 0.50;
    	        }
    	    }
    	    public double getBalance() {
    	        return this.balance;
    	    }
    	    public double getCashback() {
    	        return this.cashback;
    	    }
    	    public String toString() {
    	    	 return String.format("Balance :RM %.2f Cashback :RM %.2f", this.balance, this.cashback);
    	    }
    	}
    	 
    	 
     
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
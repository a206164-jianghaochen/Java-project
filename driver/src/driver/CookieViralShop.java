package driver;
import java.util.Scanner;
import java.text.DecimalFormat;
public class CookieViralShop {
	public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
		 DecimalFormat df = new DecimalFormat("0.00");
		 Cookies cookies = new Cookies("Pineapple Tart", 35.00);
		 
		 
		 
		 int N = sc.nextInt(); // N represents the number of people.
	     for(int i = 0; i < N; i++) {
	    	 String name = sc.next();
	    	 Customer customer = new Customer(name);
	    	 
	    	 
	    	 int amount = sc.nextInt();
	    	 
	        Order order = new Order(customer, cookies, amount);
	    	 order.displayOrderSummary();
	    	 
	     }
	     System.out.println();
	     System.out.println("Total Jar Order: " + cookies.getJar());
	        System.out.println("Total Stock Balance: " + cookies.getStock());
	}
}
    class Customer{
    	private String name;
    	
    	
    public Customer(String name) {
    	this.name = name;
    }
    public String toString() {
    	return name;
    	
    }
    	
    }
    	class Cookies{
    		private String cookiesName;
    		private double pricePerJar;
    		private int stock;
    		int numOfJar;
    		boolean stockEnough;
    		
    		
    		public Cookies(String cookiesName, double pricePerJar) {
    		this.cookiesName = cookiesName;
    		this.pricePerJar = pricePerJar;
    		this.stock = 100;
    		this.numOfJar = 0;
    		this.stockEnough = true;
    		
    		}
    		public double calculateCookiesPrice(int amount) {
    		return amount * pricePerJar;
    		
    	
    	
    }
    		
    		
    		public String getCookiesName() {
    			return cookiesName;
    		}
    			
    			
         public int addJar(int amount) {
        	 if(amount > stock) {
        	 stockEnough = false;
        	 return stock;
        	 }else {
        		 numOfJar +=amount;
        		 stock -= amount;
        		 return stock;
        	 }
         }
         
         public int getJar() {
             return numOfJar;
         }

         public int getStock() {
             return stock;
         }
         
         
         
         
        	 
        	 public boolean isStockEnought() {
    	return stockEnough;
        	 }
    	}
    	
    	 class Order {
    	    private Customer customer;
    	    private Cookies cookies;
    	    private int amount;

    	    public Order(Customer customer, Cookies cookies, int amount) {
    	        this.customer = customer;
    	        this.cookies = cookies;
    	        this.amount = amount;
    	        cookies.addJar(amount);
    	    }

    	    public double getTotalPrice() {
    	        return cookies.calculateCookiesPrice(amount);
    	    }

    	    public void displayOrderSummary() {
    	    	DecimalFormat df = new DecimalFormat("0.00");
    	        System.out.println(customer + " order " + amount + " jar(s) of " + cookies.getCookiesName());
    	        System.out.println("Total Price: RM " + df.format(getTotalPrice()));
    	    }
    	}
         
         
         
         
         
         
         
         

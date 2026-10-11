package driver;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int a1 = sc.nextInt();
    	int b1 = sc.nextInt();
    	Calculator calculator = new Calculator();
    	System.out.println("Sum of integers: " + calculator.add(a1,b1));
    	double a2 = sc.nextDouble();
    	double b2 = sc.nextDouble();
    	System.out.println("Sum of doubles: " + calculator.add(a2,b2));
    	int a3 = sc.nextInt();
    	int b3 = sc.nextInt();
    	int c3 = sc.nextInt();
    	System.out.println("Sum of three integers: " + calculator.add(a3,b3,c3));
    }
}
  class Calculator{
	  public int add(int a, int b) {
		  return a + b;
	  }
	  public double add(double a, double b) {
	  return a + b;
  }
	  public int add(int a, int b, int c) {
		  return a + b + c;  
	  }
  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

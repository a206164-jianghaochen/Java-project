package driver;

import java.util.Scanner;

public class totalPrice {
	public static void main(String[] args) {
		
		double x;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input x");
		 x = sc.nextDouble();
		 double z = x + x * 0.06;
		 System.out.printf("%.2f\n", z);
		
	}

}

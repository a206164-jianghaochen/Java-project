package Consecutive_Integer;

import java.util.Scanner;

public class Consecutive_Integer {
	public static void main(String[] args) {
		System.out.print("Please enter the first integer: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.print("Please enter the second integer: ");
		int b = scanner.nextInt();
		int result = consecutiveInteger(a, b);
		System.out.println("The gcd of the two integers is " + result);
	}
	private static int consecutiveInteger(int a, int b) {
		int m = Math.min(a, b);
		for(int i = m; i >= 1; i--) {
			if(a % i ==0 && b % i == 0) {
				return i;
			}
		}
		return 1;	
	}	

}

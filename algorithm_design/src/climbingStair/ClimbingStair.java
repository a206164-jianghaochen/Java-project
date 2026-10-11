package climbingStair;

import java.util.Scanner;

public class ClimbingStair {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.println("Please enter the number of orders you want to climb: ");
			long num = sc.nextLong();
			if(num < 0) {
				System.out.println("Please enter a positive number!");
				return;
			}
			long result = climbStairDp(num);
			System.out.println("The number of methods is: " + result);
		}	
	}
	public static long climbStairDp(long n) {
		if(n <= 2) {
			return n;
		}
		long pre_1 = 1;
		long pre_2 = 2;
		long current = 0;
		for(long i = 3; i <= n; i++) {
			current = pre_1 + pre_2;
			pre_1 = pre_2;
			pre_2 = current;
		}
		return current;
	}
	
}
	



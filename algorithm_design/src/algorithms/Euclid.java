package algorithms;

import java.util.Scanner;

public class Euclid {
	public static void main(String[] args) {
		System.out.print("Please enter the first integer: ");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.print("Please enter the second integer: ");
		int b = scanner.nextInt();
		int result = gcd(a, b);
		System.out.printf("The gcd of %d and %d is %d", a, b, result);
	}
private static int gcd(int a, int b) {
	while(b!=0) {
		int temp = b;
		b = a%b;
		a = temp;		
	}
	return a;
}
}

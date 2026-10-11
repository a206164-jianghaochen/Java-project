package lcm;

import java.util.Scanner;

public class LCM {
	public static void main(String[] args) {
		try( Scanner sc = new Scanner(System.in) ){
		System.out.println("Please enter two integers: ");
		long a = sc.nextLong();
		long b = sc.nextLong();
		if(a == 0 && b == 0) {
			System.out.println("The two integers cannot be 0 at the same time.");
			return;
		}
		if(a == 0 || b == 0) {
			System.out.println("The LCM for the two integers is 0.");
			return;
		}
		a = Math.abs(a);
        b = Math.abs(b);
		long lcm = ( a / gcd(a, b) ) * b;
		System.out.println("The LCM for the two integers is: " + lcm);	
	}	
	}
	public static long gcd(long a, long b) {
		 while(b != 0) {
			 long c = a % b;
			 a = b;
			 b = c;
		 }
		 return a; 
	}
}

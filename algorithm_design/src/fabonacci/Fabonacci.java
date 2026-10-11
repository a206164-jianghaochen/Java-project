package fabonacci;

import java.util.Scanner;
public class Fabonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of Fabonacci series: ");
		int n = sc.nextInt();	
		if(n <= 0) {
			System.out.println("Please enter a positive number");
			return;
		}	
		if(n == 1) {
			System.out.println("The first number of Fabonacci series is 0");
		}else if(n == 2){
			System.out.println("The second number of Fabonacci series is 1");
		}else {
		long a = 0;
		long b = 1;
		long sum = 1;
		for(int i = 3; i <= n; i++) {
			long currentItem = a + b;
			a = b;
			b = currentItem;
			sum += b;
		}
		System.out.println("The " + n + "th number of Fabonacci series is " + b);	
		System.out.println("The summation of 1st-" + n + "th items is " + sum);
		}
	}
}

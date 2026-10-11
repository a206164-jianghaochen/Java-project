package Java001;

import java.util.Scanner;

public class selection {
	public static void main(String[] args) {
		int num;
		int amount;
		double price;
		System.out.println("num" + "amount");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		amount = sc.nextInt();
		
		if(num == 1) {
		price = amount * 7.50;
		System.out.printf("RM %.2f\n", price);
		} if(num == 2) {
			price = amount * 6.99;
		System.out.printf("RM %.2f\n", price);
		} if(num == 3) {
			price = amount * 4.70;
		System.out.printf("RM %.2f\n", price);
		} if(num == 4) {
			price = amount * 5.30;
		System.out.printf("RM %.2f\n", price);
		} if(num == 5) {
			price = amount * 5.99;
		System.out.printf("RM %.2f\n", price);
		}
		else {
			price = 0.00;
		System.out.printf("RM %.2f\n", price);
		}
		
		
		
	}

}

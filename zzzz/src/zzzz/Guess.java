package zzzz;

import java.util.Scanner;

public class Guess {
	public static void main(String[] args) {
		int NumberGuess = 75;
		int count = 0;
		int num = 0;
		 
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("please input your number");
			num = sc.nextInt();
			if(num > NumberGuess) {
				System.out.println("higher");
			}
			if(num < NumberGuess) {
				System.out.println("lower");
			}
			count++;
		}
		while(num != NumberGuess);
		
			System.out.print("you use" + count + "times to guess 75");
		}
	}



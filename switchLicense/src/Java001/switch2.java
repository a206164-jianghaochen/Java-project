package Java001;

import java.util.Scanner;

public class switch2 {
	public static void main(String[] args) {
		int numberguess = 75;//玩家猜测的数字
		int count = 0;
		int num = 0;
		 
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("input your number");
			num = sc.nextInt();
			
			if(num > numberguess) {
				System.out.println("higher");
			}
			if(num < numberguess) {
				System.out.println("lower");
			}
			count++;
		}
		while(num != numberguess) ;
		
			System.out.print("use " + count + " times guess number 75" );
		}
	}



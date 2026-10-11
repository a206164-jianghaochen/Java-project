package dynamic_programming;

import java.util.Scanner;

public class Dynamic_programming {

	public static void main(String[] args) {
		int coin[] = {1,3,4};
		int n = coin.length;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your target: ");
		int target = sc.nextInt();
		int dp[] = new int[target + 1];
		dp[0] = 0;
		
		for(int i = 1; i <= target; i++) {
			dp[i] = 2100000000;
			for(int j = 0; j < n; j++) {
				if(i >= coin[j]) {
					dp[i] = Math.min( dp[i], dp[i-coin[j]] + 1 );
				}
			}
			
			
		}
		
		System.out.println("You need at least " + dp[target] + " coins.");
		
	}

}

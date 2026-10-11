package knapsackProblem;

public class KnapsackProblem {

	public static void main(String[] args) {
		int weight[] = {3, 2, 4, 1};
		int value[] = {8, 5, 9, 4};
		int capacity = 10;
		int dp[][] = new int[5][capacity + 1];
		int n = 4;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= capacity; j++) {
				if(j < weight[i-1]){
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i-1][j - weight[i-1]]);
				}
					
			}	
		}
		System.out.println("The maximum happiness is: " + dp[n][capacity]);
	}
}

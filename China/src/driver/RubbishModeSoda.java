package driver;

import java.util.Scanner;

public class RubbishModeSoda {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int N = scanner.nextInt();
	        int[] sodaSum = new int[4];
	        int[][] responses = new int[N][4];
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < 4; j++) {
	                responses[i][j] = scanner.nextInt();
	                sodaSum[j] += responses[i][j];
	            }
	        }
	        for (int i = 0; i < 4; i++) {
	            double average = (double) sodaSum[i] / N;
	            System.out.printf("Soda-%d: %.2f\n", (i + 1), average );
	        }

	        scanner.close();
	    }
	}

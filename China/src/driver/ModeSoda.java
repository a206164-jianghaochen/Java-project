
package driver;

import java.util.Scanner;

public class ModeSoda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of respondents: ");
        int N = scanner.nextInt();
        int[] sodaTotals = new int[4];
        int[][] responses = new int[N][4];
        System.out.println("Enter the scores for each respondent (4 scores per line):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                responses[i][j] = scanner.nextInt();
                sodaTotals[j] += responses[i][j];
            }
        }
        System.out.println("Average scores for each soda:");
        for (int i = 0; i < 4; i++) {
            double average = (double) sodaTotals[i] / N;
            System.out.printf("Soda-%d: %.2f%n", (i + 1), average);
        }

        scanner.close();
    }
}

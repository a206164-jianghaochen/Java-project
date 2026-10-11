package driver;

import java.util.Scanner;

public class OvertimeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of workers
        int N = scanner.nextInt();

        // Arrays to store OT hours for each worker
        int[][] otHours = new int[N][7];

        // Read the OT hours for each worker
        for (int i = 0; i < N; i++) {
        	for(int j = 0; j < 7; j++)
            otHours[i][j] = scanner.nextInt();
        }


        // Calculate and print commissions for each worker
        for (int i = 0; i < N; i++) {
        	for(int j = 0; j < 7; j++) {
            int commission = calculateCommission(otHours[i][j]);
            System.out.print(commission + " ");
        }
        System.out.println();
        
        }
        
    }

       
    

    // Method to calculate commission
    private static int calculateCommission(int otHours) {
        int basicAmount = 50; // Basic OT amount
        int maxOTHours = 5;   // Maximum allowed OT hours
        int overtimeRate = 2; // Rate for overtime (if more than 3 hours)
        int workhour = 3;
        // Calculate commission
        int commission = basicAmount * otHours;
        if (otHours >= workhour) {
            commission = basicAmount * overtimeRate * otHours;
        }

        return commission;
    }
    
}

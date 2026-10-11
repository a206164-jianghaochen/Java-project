package Java001;

import java.text.DecimalFormat;
import java.util.Scanner;

public class exchange {
    private static final double EXCHANGE_RATE = 0.0033; // Exchange rate: 1 KRW to MYR

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(" ");
        double amountKRW = scanner.nextDouble();

        double amountMYR = convertToMYR(amountKRW);
        
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("RM " + df.format(amountMYR));

        scanner.close();
    }

    public static double convertToMYR(double amountKRW) {
        if (amountKRW < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        
        return amountKRW * EXCHANGE_RATE;
    }
}

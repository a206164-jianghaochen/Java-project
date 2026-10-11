import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of types of coffee
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        String[] coffeeNames = {"Hazelnut Latte", "Caffe Latte", "Caramel Machiato", "Matcha Latte"};
        double[] coffeePrices = {10.99, 9.90, 11.90, 12.90};
        double[][] prices = new double[N][5];

        // Reading the prices for each type of coffee over 5 days
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                prices[i][j] = scanner.nextDouble();
            }
        }

        // Calculate and display the discounted prices on Wednesday
        for (int i = 0; i < N; i++) {
            // Original price on Wednesday (index 2)
            double originalPrice = prices[i][2];
            // Discounted price on Wednesday (35% discount)
            double discountedPrice = originalPrice * 0.65;

            // Display the result
            System.out.printf("%s on Wednesday is only RM %.2f%n", coffeeNames[i], discountedPrice);
        }

        scanner.close();
    }
}



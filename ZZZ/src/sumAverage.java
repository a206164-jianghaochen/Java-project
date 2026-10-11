import java.util.Scanner;

public class sumAverage {
    public static void main(String[] args) {
        int amount;
        System.out.println("Input your amount:");
        Scanner sc = new Scanner(System.in);
        amount = sc.nextInt();
        System.out.println(amount);

        int[] num = new int[amount]; // Adjust the array size based on the input amount

        for (int i = 0; i < amount; i++) {
            int inputNum = sc.nextInt();
            num[i] = inputNum;
        }

        int sum = 0;
        for (int i = 0; i < amount; i++) {
            sum = sum + num[i];
        }
        System.out.printf("%.2f\n", sum);

        double average = (double) sum / amount;
        System.out.printf("%.2f\n", average);
    }
}
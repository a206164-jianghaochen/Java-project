package driver;
import java.util.Scanner;

public class ReverseOrder {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 9; i >= 0; i--) {
            System.out.print(numbers[i] + " ");
        }
    }
}
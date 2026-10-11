import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = 0;
        
        while (true) {
            System.out.print("Enter an integer (0 to exit): ");
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            if (num % 4 == 0) {
                amount++;
            }
        }
        
        System.out.println("Number of integers divisible by 4: " + amount);
    }
}
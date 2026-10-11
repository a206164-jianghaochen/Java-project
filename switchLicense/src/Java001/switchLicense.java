package Java001;
import java.util.Scanner;

public class switchLicense {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        
        while (true) {
            System.out.print("Enter an integer (0 to exit): ");
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            if (num % 4 == 0) {
                count++;
            }
        }
        
        System.out.println("Number of integers divisible by 4: " + count);
    }
}

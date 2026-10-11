package driver;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        System.out.println("Enter the integers:");

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        List<Integer> uniqueNumbers = new ArrayList<>();
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : numbers) {
            if (set.add(num)) {
                uniqueNumbers.add(num);
            }
        }

        System.out.println("Result after removing duplicates while retaining the original sequence:");
        for (int num : uniqueNumbers) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
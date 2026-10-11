package zzzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RandomArrayprimes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];
        System.out.println("Enter the integers:");

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        List<Integer> primes = findPrimeNumbersInArray(numbers);

        System.out.print("Prime numbers in the array are: ");
        for (int i = 0; i < primes.size(); i++) {
            System.out.print(primes.get(i));
            if (i < primes.size() - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }

    private static List<Integer> findPrimeNumbersInArray(int[] numbers) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int num : numbers) {
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
        }

        return primeNumbers;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
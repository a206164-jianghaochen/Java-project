package driver;

import java.util.Scanner;

public class IntegerOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] occurrences = new int[10]; // Initialize the array with a fixed size of 10

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num >= 1 && num <= 10) {
                if (num > occurrences.length) {
                    // Resize the array if the input number is greater than the current array size
                    int[] newOccurrences = new int[num];
                    System.arraycopy(occurrences, 0, newOccurrences, 0, occurrences.length);
                    occurrences = newOccurrences;
                }
                occurrences[num - 1]++;
            } else {
                System.out.println("Please enter integers between 1 and 10.");
                i--; // Decrement to re-enter the current number
            }
        }

        for (int i = 0; i < occurrences.length; i++) {
            System.out.println((i + 1) + ": " + occurrences[i]);
        }
    }
}
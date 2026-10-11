package driver;

import java.util.Scanner;

public class ArrayReverseDisplay {
    public static void display(int[] arr, int size) {
        for (int i = size - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        int N = scanner.nextInt();

        // Input array elements
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        // Call the display method
        display(array, N);
    }
}
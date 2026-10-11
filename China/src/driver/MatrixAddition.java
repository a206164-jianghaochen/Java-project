package driver;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        int M = scanner.nextInt(); // Number of rows
        int N = scanner.nextInt(); // Number of columns
        int[][] matrix1 = new int[M][N];
        int[][] matrix2 = new int[M][N];

        // Read matrix1
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Read matrix2
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Add matrices
        int[][] result = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Output
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
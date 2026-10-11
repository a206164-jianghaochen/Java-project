package driver;
import java.util.Scanner;

public class TheaterSeating {
    
    public static int[][] readSeatingArrangement(Scanner scanner, int N) {
        int[][] seating = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                seating[i][j] = scanner.nextInt();
            }
        }
        return seating;
    }
    public static void printSeatingArrangement(int[][] seating) {
        int N = seating.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(seating[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;

        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            if (N == 0) {
                break;  
            }

            int[][] seating = readSeatingArrangement(scanner, N);

            System.out.println("Case #" + caseNumber + ":");
            printSeatingArrangement(seating);

            caseNumber++;
        }

        scanner.close();
    }
}

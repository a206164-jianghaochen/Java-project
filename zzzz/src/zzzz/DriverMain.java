package zzzz;

import java.util.Scanner;

public class DriverMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("");
        int N = sc.nextInt();

        if (N % 2 == 0) {
            System.out.println("Please enter an odd integer.");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i == 1 || i == N){
                for (int j = 1; j <= N; j++) {
                    
                    System.out.print(j == 1 || j == N ? "+" : "-");
                }
            } else if (i % 2 == 0) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(j == 1 || j == N ? "-" : " ");
                }
            } else if(i % 2 == 1){
                for (int j = 1; j <= N; j++) {
                    System.out.print(j == 1 || j == N ? "+" : " ");
                }
            }
            System.out.println();
        }
    }
}
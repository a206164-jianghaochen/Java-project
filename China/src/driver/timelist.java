package driver;

import java.util.Scanner;

public class timelist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // Read the size of the array
        
        int[] monthCount = new int[12]; // Array to store the count of birthdays in each month
        
        for (int i = 0; i <= N; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input.length < 3) {
                
                continue;
            }
            int month = Integer.parseInt(input[1]) - 1; // Get the month from the input
            
            if (month >= 0 && month < 12) {
                monthCount[month]++;
            } else {
                System.out.println("Invalid month detected.");
            }
        }
        
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        
        for (int i = 0; i < 12; i++) {
             String asterisks = "*".repeat(monthCount[i]);
    if (monthCount[i] > 0) {
        System.out.print(monthNames[i] + ":");
        for (int j = 0; j < asterisks.length(); j++) {
            System.out.print("*");
        }
        System.out.println();
    } else {
        System.out.println(monthNames[i] + ":");
    }
        }
    }
}
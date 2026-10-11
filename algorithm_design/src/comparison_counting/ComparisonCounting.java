package comparison_counting;

import java.util.Scanner;

public class ComparisonCounting {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of integers: ");
		int n = scanner.nextInt();
        int arr[] = new int[n];
   		System.out.println("Please enter the integers: ");
   		for(int i = 0; i < n; i++) {
   			arr[i] = scanner.nextInt();
   		}
           int count[] = new int[n];
           for(int i = 0; i < n; i++) {
        	   count[i] = 0;
           }
           for(int i = 0; i < n - 1; i++) {
        	   for(int j = i + 1; j < n; j++) {
        		   if(arr[i] < arr[j]) {
        			   count[j]++;
        		   }else {
        			   count[i]++;
        		   }   
        	   }
           }
           int SortedArray[] = new int[n];
           for(int i = 0; i < n; i++) {
        	   SortedArray[count[i]] = arr[i];
           }
           System.out.print("[ ");
           for(int S : SortedArray) {
        	   System.out.print(S + " ");
           } 
           System.out.print("]");
	}
}

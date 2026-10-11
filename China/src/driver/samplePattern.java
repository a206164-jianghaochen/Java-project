package driver;

import java.util.Scanner;

public class samplePattern {
           public static void main(String[] args) {
        	   Scanner sc = new Scanner(System.in);
        	   int N = sc.nextInt();
        	   int[] arr = new int[N];
        	   for(int i = 0; i < N; i++) {
        	   arr[i] = sc.nextInt();
        	   }
        	   int M = sc.nextInt();
        	   int count = 0;
        	   for(int i = 0; i < N; i++) {
        	      if(arr[i] == M) {
        	      count++;
        	      }
        	   
        		   
        		   
        	   }
        	   System.out.printf("The number %d occurred %d times in the array." , M , count);
        	   
        	   
        	   
        	   
           }
}

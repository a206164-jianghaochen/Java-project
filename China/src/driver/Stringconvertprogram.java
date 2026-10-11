package driver;

import java.util.Scanner;

public class Stringconvertprogram {
      public static void main(String [] args) {
       
    	  Scanner sc = new Scanner(System.in);
    	  int N = sc.nextInt();
    	  int[][] arr = new int[N][N];
    	  int[] sum = new int[N];
    	  for(int i = 0; i < N; i++) {
    		  
    		  for(int j = 0; j < N; j++) {
    			   arr[i][j] = sc.nextInt();
    			   sum[j] += arr[i][j];
    			  
    		  } 
    		  
    		  }
    		  for(int j = 0; j < N; j++) {
    			  int everyColumnSum = sum[j];
    			  System.out.printf("Sum for column %d is %d\n", (j+1), sum[j]);
    			  
    			  
    		  }
    	  
      }
    	  
}  
    	  
    	  
    	  

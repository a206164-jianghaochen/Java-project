package driver;

import java.util.Scanner;

public class Wocaonima {
       public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	   int N = sc.nextInt();
    	   int[][] arr = new int[N][N];
    	   int[] columnSum = new int[N];
    	   for(int i = 0; i < N; i++) {
    	   for(int j = 0; j < N; j++) {
    	   arr[i][j] = sc.nextInt();
    	   }
    	  
    	   
    	   } 
    	   
    	   for(int i = 0; i < N; i++) {
    		   int sum = 0;
        	   for(int j = 0; j < N; j++) {
    	   sum += arr[i][j];
        	   }
        	   columnSum[i] = sum;
    	   }
        	   
        	   
        	   
    	   int maxindex = 0;
    	   for(int i = 0; i < N; i++) {
    	    if(columnSum[i] > columnSum[0]) {
    	       maxindex = i;
       }   
    	     
    	    
    	    
    	    
    	    
}	   
    	   
    	   System.out.printf("row %d has the maximum sum of %d", (maxindex+1), columnSum[maxindex]);
       } 	   
} 
    	   
    	   
    	   

package driver;

import java.util.Scanner;

public class CalculateSumOfEven {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 int N = sc.nextInt();
    	 int sum = 0;
    	    for(int i = 2; i <= N; i++) {
    	    	boolean isPrimeNum = true;
    	     for(int j = 2; j < i; j++) {
    	    	   if(i % j==0) {
    	    		   isPrimeNum = false;
    	    	 break;
    	    	   }
    	    	   
    	    	   
    	    	   
    	    } 
    	     if(isPrimeNum) {
    	    	 
    	    	 sum += i;
    	    }
    	     
    	      
}
    	    System.out.print(sum);
    	    
}
}
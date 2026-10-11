package driver;

import java.util.Scanner;

public class UniversalArea {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	 int N = sc.nextInt();
    	 for(int y = 1; y <= N; y++) {
    		 for(int x = 1; x <= N-y; x++) {
    			 System.out.print(" ");
    		 }
    
    	 for(int z = 1; z <= 2 * y - 1; z++) {
    	 System.out.print("*");
    	 
}
    	 System.out.println();
}
    	   for(int y = 1; y <= N-1; y++) {
    	       for(int x = 1; x <= y; x++) {
    	 System.out.print(" ");
    	       }
    	     for(int z = 1; z <= (2 * N - 1) - 2 * y; z++) {
    	     System.out.print("*");
    	     }
    	  System.out.println();
    }	 
    	    
    }
}

package driver;

import java.util.Scanner;

public class salesData {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int M = scanner.nextInt();
	int N = scanner.nextInt();
	int[][] sales = new int[M][N];
	for(int i = 0; i < M; i++) {
		for(int j = 0; j < N; j++) {
	       sales[i][j] = scanner.nextInt();
		}
	}
	
	scanner.close();
	
	int[] totalSalesperson = new int[M];
	 for(int i = 0; i < M ; i++) {
		 for(int j = 0; j < N ; j++) {
	 
	 totalSalesperson[i] += sales[i][j];
		 }
		 System.out.printf("Total Sales for Salesperson %d: %d\n" , (i+1),totalSalesperson[i]);
		
	 }
	 System.out.println();
	int[] totalSalesProduct = new int[N];
	 for(int j = 0; j < N ; j++) {
		 for(int i = 0; i< M ; i++) {
			 totalSalesProduct[j] += sales[i][j];
	}
		 
		 System.out.printf("Total Sales for Product %d: %d\n" , (j+1), totalSalesProduct[j]);
		 
		 }
	 
	System.out.println();
	
	int highestSalesProduct = 0;
	  for(int j = 0; j < N ; j++) {
	   if(totalSalesProduct[j] > totalSalesProduct[highestSalesProduct]) {
		   highestSalesProduct = j;
		   
	   }
	  }
	  System.out.printf("Hihest-Selling Product: Product %d", (highestSalesProduct+1));
	 System.out.println();
	  int mostSuccessfulPerson = 0;
	  for(int i = 0; i < M ; i++) {
		   if(totalSalesperson[i] > totalSalesperson[mostSuccessfulPerson]) {
			   mostSuccessfulPerson = i;
		   }
	  } 
	  
	  System.out.printf("Most Successful Salesperson: Salesperson %d", ( mostSuccessfulPerson+1));
	   System.out.println();
	}   
}  

		   
		   
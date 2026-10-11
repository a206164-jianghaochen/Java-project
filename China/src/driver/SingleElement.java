package driver;

import java.util.HashSet;
import java.util.Scanner;

public class SingleElement {
	public static void main(String[] arg) {
	  Scanner sc = new Scanner(System.in);
	  int i;
	int N = sc.nextInt();
	int[] num = new int[N];
	for(i=0; i<N; i++) {
		num[i] = sc.nextInt();
	}
		
	weatherduplicate(num);
		
	}	
	public static void weatherduplicate(int[] num) {
		HashSet<Integer> uniqueNumbers = new HashSet<>();
		for(int n : num) {
			uniqueNumbers.add(n);
		}
	             for(int unique : uniqueNumbers) {
	            	 System.out.print(unique + " ");
	             }
	}
}
	
	
	




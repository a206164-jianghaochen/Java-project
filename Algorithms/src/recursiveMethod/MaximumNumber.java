package recursiveMethod;
import java.util.Scanner;
public class MaximumNumber {
         public static void main(String[] args) {
        	 Scanner sc = new Scanner(System.in);
        	 int amount = sc.nextInt();
        	 int[] arr = new int[amount];
        	 for(int i = 0; i < amount; i++) {
        		 arr[i] = sc.nextInt();     		 
        	 }
        	 int max = arr[0];
        	 for(int i = 0; i < amount - 1; i++) {
        		 if(max < arr[i]) {
        			 max = arr[i];      			 
        		 }  		 
        	 }       	 
        	 System.out.println("The maximum number in the array is " + max);    	 
         }
}

package recursiveMethod;

import java.util.Scanner;

public class FactorialCalculation {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 int num = sc.nextInt();
    	 int result = FactorialRecursion(num);
    	 System.out.println("The factorial of the target number is " + result);   	 
     }   
     public static int FactorialRecursion(int num) {
    	 if(num == 0 || num == 1) {
    		 return 1;   		 
    	 }
    	  return num * FactorialRecursion(num - 1);  	 
     }
}

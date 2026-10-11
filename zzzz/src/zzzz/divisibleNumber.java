package zzzz;

import java.util.Scanner;

public class divisibleNumber {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("Enter an integer");
             num = sc.nextInt();
             
            if (num == -1) {
                break;
            }
            if(num % 2 == 0 && num % 3 == 0) {
            	System.out.println(num);
            }
         
        }    
        
        }
}
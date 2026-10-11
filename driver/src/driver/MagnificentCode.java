package driver;

import java.util.Scanner;

public class MagnificentCode {
     public static void main(String[] args) {
    	   Scanner sc = new Scanner(System.in);
    	 int N = sc.nextInt();
    	 
    	 for(int i = 1; i <= N; i++) {
    	 String input = sc.next();
    	 String result = isPalindrome(input)? "Yes" : "No";
    	 System.out.println("Case #" + i + ": " + result);
    	 
     }
}
     public static boolean isPalindrome(String str) {
    	 str = str.toLowerCase();
    	   int left = 0;
    	   int right = str.length() - 1;
    	 
    	   while(left < right) {
    	   if(str.charAt(left) != str.charAt(right)) {
    	 return false;
    	   } 
    	 left++;
    	 right--;
    	 
     }
     return true;
}
}
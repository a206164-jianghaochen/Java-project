package dataStructureAlgorithm;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class PalindromeCheck {
       public static void main(String[] args) {
    	   Scanner sc = new Scanner(System.in);
    	   String input = sc.next().trim();    	  
    	   boolean isPalindrome = CheckPalindrome(input);
    	  System.out.println(isPalindrome ? "This is a Palindrome." : "This is not a Palindrome."); 	   
       }
   public static boolean CheckPalindrome(String str) {
	   Stack<Character> stack = new Stack<>();
	   Queue<Character> q = new LinkedList<>();
	   for(int i = 0; i < str.length(); i++) {
		   stack.push(str.charAt(i));
		   q.add(str.charAt(i));		   
	   }
	   for(int i = 0; i < str.length(); i++) {
		   if(stack.pop() != q.poll()) {
			   return false;
		   }
	   }
	   return true;
	   
   }    
}

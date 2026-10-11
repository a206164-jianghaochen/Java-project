package dataStructureExercise;
import java.util.*;
public class PalindromeStack {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int N = sc.nextInt();
	   for(int i = 0; i < N; i++) {
		   String word = sc.next();
		   if(isPalindrome(word)) {
			   System.out.println("It is a Palindrome");
		   }else {
			   System.out.println("Not a Palindrome");
		   }
	   }	   
   }
    public static boolean isPalindrome(String str) {
    	Stack<Character> stack = new Stack<>();
    	Queue<Character> queue = new LinkedList<>();
    	for(int i = 0; i < str.length(); i++) {
    		stack.push(str.charAt(i)); 
    		queue.add(str.charAt(i));
    	}
    	for(int i = 0; i < stack.size(); i++) {
    		if( queue.poll()!= stack.pop()) {
    			return false;
    		}
    	}
    	return true;  	
    }
}

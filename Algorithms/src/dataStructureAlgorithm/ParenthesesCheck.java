package dataStructureAlgorithm;
import java.util.Scanner;
import java.util.Stack;
public class ParenthesesCheck {
         public static void main(String[] args) {
        	 Scanner sc = new Scanner(System.in);
        	 String input = sc.nextLine().trim();
        	 boolean isValid = CheckParentheses(input);
             System.out.println(isValid);     	  	 
         }
         public static boolean CheckParentheses(String str) {
        	 if(str.isEmpty()) {
        		 return true;       		 
        	 }
        	 char[] chars = str.toCharArray();        	 
        	 Stack<Character> stack = new Stack<>();
        	 for(Character c : chars) {
        		 if(c == '(' || c == '[' || c == '{'){
        			 stack.push(c);       			 
        		 }else if(c == ')' || c == ']' || c == '}') {        		
        			 if(!validateParentheses(c, stack)) {
        				 return false;       				 
        			 }
        		 }	 
        	 }
        	 if(stack.isEmpty()) {
        		 return true;
        	 }
        	 return false;        	        	 
         }
        public static boolean validateParentheses(char c, Stack<Character> stack) {
        	if(stack.isEmpty()) {
        		return false;
        	}
        	char topValue = stack.pop();
           if(c == ')' && topValue == '(') {
        	   return true;
        	   
           }else if(c == ']' && topValue == '[') {
            	   return true;
            	   
           }else if(c == '}' && topValue == '{') {
            	   return true;           	   
               }            	                   	   
        	return false; 
        }                       
}

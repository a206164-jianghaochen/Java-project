package driver;
import java.util.*;
public class PostFixMachine {
   static int evaluatePostfix(String exp) {
	   Stack<Integer> stack = new Stack<>();
	   for(int i = 0; i < exp.length(); i++) {
		   char c = exp.charAt(i);
		   if(Character.isWhitespace(c)) {
			   continue;
		   }			   			   
		   else if(Character.isDigit(c)) {			   
			   stack.push(c-'0');
		   }else {
			   int val1 = stack.pop();
			   int val2 = stack.pop();
			   switch(c) {
			   case '+': stack.push(val2+val1);
			   break;
			   case '-': stack.push(val2-val1);	
			   break;
			   case '/': stack.push(val2/val1);
			   break;
			   case '*': stack.push(val2*val1);
			   break;
			   }			   
		   }
	   }
			   return stack.pop();		   
		   }	   
	   public static void main(String[] args) {
		   String InStr = "2 3 1 * + 9 -";
		System.out.println("Postfix Notation: " + InStr);   
		System.out.println("Result: " + evaluatePostfix(InStr));   		   
	   }    
   }


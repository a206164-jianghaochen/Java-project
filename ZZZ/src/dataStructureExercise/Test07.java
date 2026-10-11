package dataStructureExercise;
import java.util.*;
public class Test07 {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 String input = sc.nextLine().trim();
    	 String[] tokens = input.split("\\s+");
    	 System.out.println(processExpression(tokens));
     }
        public static int processExpression(String[] tokens) {
        	Stack<Integer> stack = new Stack<>();
        	for(String token : tokens) {
        		if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")) {
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(calculateResult(a,b,token));
        		}else{
        			stack.push(Integer.parseInt(token));
        			
        		}	
        }
        	return stack.pop();
      }
      public static int calculateResult(int a, int b, String token) {
    	        switch(token) {
    	        case "+":
    	        	return a + b;
    	        case "-":
    	        	return a - b;
    	        case "*":
    	        	return a * b;
    	        case "/":
    	        	return a / b;
    	        default:
    	        	throw new IllegalArgumentException("Invalid operator: " + token);   	        
    	        }	  
      }
}

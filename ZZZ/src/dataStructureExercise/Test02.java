package dataStructureExercise;
import java.util.*;
public class Test02 {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 String input = sc.nextLine().trim();
    	 processExpression(input);   	 
     }
    public static void processExpression(String expression) {
    	if(expression.indexOf(";")!= expression.length()-1){
    		expression = expression.substring(0, expression.indexOf(";") + 1);    		
    	}
    	if(!expression.endsWith(";")) {
    		System.out.println("ERROR: no END OF STRING in the expression");
    		return;    		   		
    	}
    	expression = expression.substring(0, expression.length()-1).trim();
    	String[] tokens = expression.split("\\s+");
    	Stack<Integer> stack = new Stack<>();
    	for(String token : tokens) {
    		if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")) {
    			if(stack.size() < 2) {
    				return;
    			}
    			int a = stack.pop();
    			int b = stack.pop();
    			int result = applyOperator(a,b,token);
    			stack.push(result);
    		}else {
    			try {
    				int number = Integer.parseInt(token);
    				stack.push(number);
    			}catch (NumberFormatException e) {
    				return;
    			}
    		}
    	} 
    	if(stack.size()==1) {
    		System.out.println(stack.pop());
    	}else {
    		System.out.println("Error");
    	}
    }
    	public static int applyOperator(int a, int b, String operator) {
    		switch(operator) {   		
    		case "+": return a+b;
    		case "-": return a-b;
    		case "*": return a*b;
    		case "/": 
    			if(b==0) {
    				throw new ArithmeticException(" ");
    			}
    			return a / b;
   		default:
   			throw new IllegalArgumentException(" ");    				
    		           }
  	               }
                 }
      
    
    
    
    
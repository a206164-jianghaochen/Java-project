package reviewTest;
import java.util.*;
public class InfixToPostfixConversion {
     public static void main(String[] args) {
    	 Scanner sc = new Scanner(System.in);
    	 String input = sc.nextLine().trim();
    	  if(!input.endsWith(";")) {
    		  System.out.println("ERROR: no END OF STRING in the expression");
              return;   		  
    	  }
    	 input = input.substring(0, input.length()-1).trim();
    	 Stack<String> operatorStack = new Stack<>();
         List<String> output = new ArrayList<>();
    	 String[] tokens = input.split("\\s+");
    	 for(String token : tokens) {
    		 if (isOperand(token)) {
                 output.add(token);
       }else if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")) {
    	while(!operatorStack.isEmpty() && ranking(operatorStack.peek()) >= ranking(token)) {
    		output.add(operatorStack.pop());   		   		
    	}
    	operatorStack.push(token);
    } else {                
        return;
    }
    	 }	
     while (!operatorStack.isEmpty()) {
         output.add(operatorStack.pop());
     } 
     System.out.println(String.join(" ", output));
    }
     private static boolean isOperand(String token) {
         try {
             Integer.parseInt(token);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
     }
     private static int ranking(String operator) {
         switch (operator) {
             case "+": case "-": return 1;
             case "*": case "/": return 2;
             default: return -1;
         }
     }
 }

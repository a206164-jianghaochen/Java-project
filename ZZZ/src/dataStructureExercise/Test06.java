package dataStructureExercise;
import java.util.*;
public class Test06 {
    private static boolean isOperator(String c) {
        return c.equals("+")||c.equals("-")||c.equals("*")||c.equals("/");
    }
    private static int precedence(String c) {
        switch (c) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }
        public static boolean isOperand(String token) {
        	 try {
        		 Integer.parseInt(token);
        		 return true;
        	 } catch (NumberFormatException e) {
                 return false;
             }	
        }
    public static String infixToPostfix(String[] infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String token : infix) {           
            if (isOperand(token)) {
                postfix.append(token).append(" ");
            }
            else if (token.equals("(")) {
                stack.push(token);
            }
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
            else if (isOperator(token)) {
                while (!stack.isEmpty() && precedence(token) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String infixExpression = sc.nextLine().trim();
        if(!infixExpression.endsWith(";")) {
        	System.out.println("ERROR: no END OF STRING in the expression");
        	return;
        }
        String[] tokens = infixExpression.substring(0, infixExpression.length()-1).split("\\s+");
        String postfixExpression = infixToPostfix(tokens);
        System.out.println(postfixExpression);
    }
}




package driver;
import java.util.*;
public class InfixToPostfixTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        convertInfixToPostfix(input);
    }
    public static void convertInfixToPostfix(String expression) {
        if (!expression.endsWith(";")) {
            System.out.println("ERROR: no END OF STRING in the expression");
            return;
        }
        expression = expression.substring(0, expression.length() - 1).trim();
        Stack<String> operatorStack = new Stack<>();
        List<String> output = new ArrayList<>();
        String[] tokens = expression.split("\\s+");       
        for (String token : tokens) {
            if (isOperand(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && ranking(operatorStack.peek()) >= ranking(token)) {
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
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private static int ranking(String operator) {
        switch (operator) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            default: return -1;
        }
    }
}


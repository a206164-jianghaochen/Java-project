package driver;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<String> stack1 = new Stack<>();
        String temp = "";
        int count = 0;
        char symT = ' ';
        String infix = in.nextLine();
        StringTokenizer st = new StringTokenizer(infix);
        while (st.hasMoreTokens()) {
            String nextk = st.nextToken();
            if (nextk.equals(";"))
                count++;
        }
        if (count == 0) {
            System.out.print("ERROR: NO END OF STRING in the expression");
        } else {
            StringTokenizer kt = new StringTokenizer(infix);
            while (kt.hasMoreTokens()) {
                String nextT = kt.nextToken();
                if (!(nextT.equals(";"))) {
                    if (isOperator(nextT)) {
                        symT = atoc(nextT);
                        if (!stack1.empty())
                            temp = stack1.peek();
                        char d1 = temp.charAt(0);
                        while ((!stack1.empty()) && ((!isHigherThan(symT, d1)))) {
                            System.out.print(stack1.pop() + " ");
                            if (!stack1.empty())
                                temp = stack1.peek();
                                d1 = temp.charAt(0);
                        }
                        stack1.push(nextT);
                    } else {
                        System.out.print(nextT + " ");
                    }
                } else {
                    break;
                }
            }
            while (!stack1.empty()) {
                System.out.print(stack1.pop() + " ");
            }
        }
    }
    static char atoc(String str) {
        return str.charAt(0);
    }
    static boolean isHigherThan(char op1, char op2) {
        int precdence1 = getPrecedence(op1);
        int precdence2 = getPrecedence(op2);
        return precdence1 > precdence2;
    }
    static int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    static boolean isOperator(String token) {
   return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^");
    }
}
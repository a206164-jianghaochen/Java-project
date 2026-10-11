package machinetest;
import java.util.*;
public class Exam01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inPut = scanner.nextLine();
         compute(inPut);
    }
    public static void compute(String input) {
        boolean b = input.endsWith(";");
        if (!b) {
            System.err.println("");
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        String[] inner = input.split(" ");
        for (String s : inner) {
            if (s.equals("*")){
                Integer integer = stack.pop();
                Integer pop = stack.pop();
                int result = integer * pop;
                stack.push(result);
               continue;
            }
            if (s.equals("+")){
                Integer integer = stack.pop();
                Integer pop = stack.pop();
                int result = integer + pop;
                stack.push(result);
             continue;
            }
            if (s.equals("-")){
                Integer integer = stack.pop();
                Integer pop = stack.pop();
                int result = pop - integer;
                stack.push(result);
              continue;
            }
            if (s.equals("/")){
                Integer integer = stack.pop();
                Integer pop = stack.pop();
                if (pop == 0){
                    System.err.println("");
                    break;
                }
                int result = integer / pop;
                stack.push(result);
               continue;
            }
            if (s.equals(";")){
                continue;
            }
                stack.push(Integer.parseInt(s));
        }
        System.out.println(stack.pop());
    }
}

package dataStructureExercise;
import java.util.*;
public class Test04 {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	Stack<Integer> stack = new Stack<>();
    	int num = sc.nextInt();
    	while(num != 0) {
    		int res = num / 7;
    		int remin = num % 7;
    		stack.push(remin);
    		num = res;
    	}
    	   Collections.reverse(stack);
    	   Iterator<Integer> it = stack.iterator();
    	   while(it.hasNext()) {
    		   System.out.print(it.next());   		   
    	   }   	   
    }
}

     
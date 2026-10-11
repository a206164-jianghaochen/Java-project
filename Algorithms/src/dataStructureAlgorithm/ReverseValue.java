package dataStructureAlgorithm;
import java.util.Scanner;
import java.util.Stack;
public class ReverseValue {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int input = sc.nextInt();
    	int[] arr = new int[input];
    	Stack<Integer> stack = new Stack<>();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < arr.length; i++) {
    		arr[i] = sc.nextInt();   
    		stack.push(arr[i]);
    	}
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop()).append(" ");    		
    	}
    	System.out.println(sb);
    	
    }
}

package driver;
import java.util.*;
public class BalanceSymbolChecker {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	String inputStr = sc.nextLine().trim();	
	if(!inputStr.endsWith(";")) {		
		System.out.println("ERROR: no END OF STRING in the expression");
		return;
	}
	   inputStr = inputStr.substring(0, inputStr.length()-1);
	    if(isBalanced(inputStr)) {
	    	System.out.println("Balanced");
	    }else {
	    	System.out.println("Unbalanced");
	    }		
}
	public static boolean isBalanced(String inputStr) {
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for(char inputst : inputStr.toCharArray()) {
	if(inputst == '(' || inputst == ')' || inputst == '{'||inputst == '}'|| inputst == '[' || inputst == ']') {
		count ++;		
	}
		}
		if(count % 2 != 0) {
			return false;
		}
		for(char inputst : inputStr.toCharArray()) {
			if(inputst == '(' || inputst == '{' || inputst == '[') {
				stack.push(inputst);				
			}else if(inputst == ')' || inputst == '}' || inputst == ']') {
				if(stack.isEmpty()) {
					return false;
				}
				char topValue = stack.pop();
				if(!isPair(topValue, inputst)) {
					return false;					
				}
			}		
		}
		return true;		  		
	}
	  public static boolean isPair(char o, char c) {
		  return (o == '(' && c == ')') ||(o == '{' && c == '}') ||(o == '[' && c == ']');	  
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
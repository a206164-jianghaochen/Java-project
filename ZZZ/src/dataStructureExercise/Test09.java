package dataStructureExercise;
import java.util.*;
public class Test09 {
   public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String expression = sc.nextLine().trim();
	        if(!expression.endsWith(";")) {
	        	System.out.println("Error");
	        	return;
	        }
	        expression = expression.substring(0 , expression.length() - 1).trim();
	        if(isBalanced(expression)) {
	        	System.out.println("It is balanced");	        	
	        }else {
	        	System.out.println("It is not balanced");	
	        }    
   }
        public static boolean isBalanced(String inputStr) {
        	    Stack<String> stack = new Stack<>();
        	String[] words = inputStr.split("\\s+");
        	int countA = 0;
        	int countB = 0;
        	for(String word : words) {
        		if(word.equals("(")||word.equals("[")||word.equals("{")) {
        		countA++;
        	}else if(word.equals(")")||word.equals("]")||word.equals("}")) {
        		countB++;       		
        	}
        	}
        	if(countA!=countB) {
        		return false;        		
        	}
        	for(String word : words) {
        		  if(word.equals("(")||word.equals("[")||word.equals("{")) {
        			  stack.push(word);      			         			  
        		  }else if(word.equals(")")||word.equals("]")||word.equals("}")) {
        			     if(stack.isEmpty()) {     			    	 
        			    	return false; 
        			     }
        			     String topValue = stack.pop();
        			     if(!ismatchedPair(topValue, word)) {       			    	 
        			    	 return false;        			         			       			  
        		  }		
        	}
        	return true;       	
        } 
        	return stack.isEmpty();
}
         public static boolean ismatchedPair(String topValue, String word) {
        	 return (topValue.equals("(")&&word.equals(")"))||(topValue.equals("[")&&word.equals("]"))||(topValue.equals("{")&&word.equals("}"));       	 
         }
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   
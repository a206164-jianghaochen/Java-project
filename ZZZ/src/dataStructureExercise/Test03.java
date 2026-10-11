package dataStructureExercise;
import java.util.*;
public class Test03 {
  public static void main(String[] args) {
	  Scanner sc= new Scanner(System.in);
	  int num = sc.nextInt();
	  if(num >= 10000) {
		  return;
	  }
	    ProcessNum pro = new ProcessNum(num);
	    pro.printResult();	    
      }
}
    class ProcessNum{
    	int num;
    	Stack<Integer> stack;
    	public ProcessNum(int num) {
    		this.num = num;   		
    	}
    	public void printResult(){
    		stack = new Stack<>();
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
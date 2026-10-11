package dataStructureExercise;
import java.util.*;
public class Test01 {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   Queue<Integer> initialQueue = new LinkedList<>();
	   Stack<Integer> output = new Stack<>();
	   int N = sc.nextInt();
	   for(int i = 0; i < N; i++) {
		   int num = sc.nextInt();
		   initialQueue.add(num);   
	   }
	   System.out.println(initialQueue);
	   while(!initialQueue.isEmpty()) {
		   output.push(initialQueue.poll());		   
	   }
	   System.out.println(output); 
	   StringBuilder sb = new StringBuilder();
	   while(!output.isEmpty()) {
		   sb.append(output.pop()).append(" ");
	   }
	   System.out.println(sb.toString());
   }
}

package niubiclass;
import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	List<Integer> list = new LinkedList<>();
    	int N = sc.nextInt();
    	for(int i = 0; i < N; i++) {
    		int num = sc.nextInt();
    		list.add(num);   		
    	}
    	 int med = 0;
    	  for(int j = 0; j < list.size()-1; j++) {
    		  for(int i = 0; i < list.size()-1-j; i++) {
    			  if(list.get(i) > list.get(i+1)) {
    				  med = list.get(i);
    				  list.set(i , list.get(i+1));
    				  list.set(i+1, med);
    			  }		  
    		  }   		  
    	  }
         for(Integer in : list) {
        	 System.out.print(in + " ");
         }  	  
    }
}

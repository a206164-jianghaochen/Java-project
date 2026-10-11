package sort;
import java.util.*;
public class SortLinked {
      public static void main(String[] args) {
    	  Scanner sc = new Scanner(System.in);
    	  int N = sc.nextInt();
    	  List<Integer> list = new LinkedList<>();
    	  for(int i = 0; i < N; i++) {
    		  int num = sc.nextInt();
    		  list.add(num);   		  
    	  }
    	  Collections.sort(list);
    	  StringBuilder sb = new StringBuilder();
    	  for(Integer li : list) {
    		  sb.append(li).append(" ");
  	  }
    	  System.out.println(sb);	  
      }
}

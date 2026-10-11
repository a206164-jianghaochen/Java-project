package sort;
import java.util.*;
public class OddEvenList {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  List<Integer> oddList = new ArrayList<>();
	  List<Integer> evenList = new ArrayList<>();
	  while(sc.hasNextInt()) {
		  int num = sc.nextInt();	
		  if(num % 2 == 0) {
			  evenList.add(num);			  			  
		  }else {
			  oddList.add(num);
		  }	  
	  }
	      Collections.sort(oddList);
	      Collections.sort(evenList);
	System.out.println("Odd List" + "(" + oddList.size() + "):" + convertResult(oddList));
	System.out.println("Even List" + "(" + evenList.size() + "):" + convertResult(oddList));	  	  
  }
     public static String convertResult(List<Integer> lists) {
    	 StringBuilder sb = new StringBuilder();
    	 for(Integer list : lists) {
    		 sb.append(list).append(" ");	 
    	 }
    	 return sb.toString();   	 
     }
}

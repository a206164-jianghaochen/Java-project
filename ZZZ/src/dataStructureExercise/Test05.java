package dataStructureExercise;
import java.util.*;
public class Test05 {
  public static void main(String[] args) {
	     Scanner sc = new Scanner(System.in);
	     Queue<Integer> q = new LinkedList<>();         
	     int num;
	  while((num = sc.nextInt())!= 0) {
		  q.add(num);	  
	  }
	  int serviceTime = 5;
	  int previousEndingTime = 0; 
	  for(Integer arrivalTime : q) {
		 int startTime = Math.max(arrivalTime, previousEndingTime);
		 int endTime = startTime + serviceTime;	  
		int waitingTime = startTime - arrivalTime;  
		  System.out.println(arrivalTime + ":" + startTime + ":" + endTime + ":" + waitingTime);
		  previousEndingTime = endTime; 
		  }  
	  }  
  }


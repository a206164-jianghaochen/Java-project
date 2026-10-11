package test;
import java.util.*;
public class OddEvenNUmber {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();	
	for(int i = 0; i < N;  i++) {
		Queue<Integer> OddList = new LinkedList<>();
		Queue<Integer> EvenList = new LinkedList<>();
		int countOdd = 0;
		int countEven = 0;
		while(sc.hasNextInt()) {
			int num = sc.nextInt();	
		if(num == 0) {
			break;
		}else if(num % 2 == 0) {
			EvenList.add(num);
			countEven ++;
		}else {
			OddList.add(num);
			countOdd ++;
		}		
	}
		if(!OddList.isEmpty() && !EvenList.isEmpty()) {
		System.out.println("oddQueue " + countOdd + ": " + convertToString(OddList) + " ");		
		System.out.println("evenQueue " + countOdd + ": " + convertToString(EvenList) + " ");			
		}else if(!OddList.isEmpty() && EvenList.isEmpty()) {
			System.out.println("oddQueue " + countOdd + ": " + convertToString(OddList) + " ");
			System.out.println("evenQueue " + countEven + ": ");			
		}else if(!EvenList.isEmpty() && OddList.isEmpty()) {
			System.out.println("oddQueue " + countOdd + ": ");	
			System.out.println("evenQueue " + countOdd + ": " + convertToString(EvenList) + " ");
		}
		else {
			System.out.println("oddQueue " + countOdd + ": ");
			System.out.println("evenQueue " + countEven + ": ");
		}
	}	
}
    private static String convertToString(Queue<Integer> queue) {
    StringBuilder stringbuilder = new StringBuilder();
    for (Integer num : queue) {
        if (stringbuilder.length() > 0) {
        	stringbuilder.append(" ");
        }
        stringbuilder.append(num);
    }
    return stringbuilder.toString();
}	  
}

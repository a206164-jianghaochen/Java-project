package test;
import java.util.*;
public class MyList {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String passage = sc.nextLine();
		String delims = "\\W+";
		String[] words = passage.split(delims);
		  for(String str : words) {
			  str = str.trim();
			  if(!str.isEmpty()) {
			  list1.add(str);
			  }
		  }
		System.out.println("list1:" + list1);
		String result = String.join(", ", list1);
		System.out.println(result);
		
		
		
		
		
		
	}
}

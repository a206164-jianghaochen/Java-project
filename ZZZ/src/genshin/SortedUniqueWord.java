package genshin;
import java.util.*;
public class SortedUniqueWord {
     public static void main(String[] args) {
    	 List<String> list1 = new ArrayList<String>();
    	 Scanner sc = new Scanner(System.in);
    	 boolean isDuplicate;
    	 int size = 0;   	 
    	 String passage = sc.nextLine();
    	 String[] words = passage.split("\\W+");
    	 for(String word : words) {
    		 word = word.trim();
    		 isDuplicate = false;
    		 isDuplicate = CheckForDuplicate(list1,word);
    		 if(!isDuplicate) {
    			 list1.add(word);			 
    		 }    		
    	 }
    	 Collections.sort(list1);
    	 displayList(list1,size);	 
     }
     public static boolean CheckForDuplicate(List list1, String word) {
    	 if(!list1.contains(word)) {
    		  return false;		 
    	 }
    	 return true;   	 
     }
       public static void displayList(List<String> list1, int s) {
    	   Iterator<String> it = list1.iterator();
    	   while(it.hasNext()) {
    		   System.out.println(it.next());    		 
    	   }  	   
       } 
}

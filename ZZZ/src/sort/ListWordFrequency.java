package sort;
import java.util.*;
public class ListWordFrequency {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String passage = sc.nextLine();
    	String[] words = passage.split("\\W+");
    	Arrays.sort(words);
    	List<String> FrequencyList = new ArrayList<>();
    	String previousWord = "";
    	int count = 0;
    	for(String word : words) {
    		if(word.equals(previousWord)) {
    			count++;   			
    		}else {
    			if(!previousWord.isEmpty()) {
    				FrequencyList.add(previousWord  + "(" + count + ")");                   
    			}   					
    			previousWord = word;
    			count = 1;
    		}   		
    	}
    	FrequencyList.add(previousWord  + "(" + count + ")");
    	for(String Frequency : FrequencyList) {
    		System.out.println(Frequency);   		
    	}	
    }
}

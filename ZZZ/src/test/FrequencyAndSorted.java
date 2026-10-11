package test;
import java.util.*;
public class FrequencyAndSorted {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String passage = sc.nextLine();
		String[] words = passage.split("\\W+");
		int countWords = 0;
		for(String word : words) {
			countWords++;			
		}
		Arrays.sort(words);
		 List<String> FrequencyList = new ArrayList<>();
		 List<Integer> IntegerFrequencyList = new ArrayList<>();
	        String previousWord = "";
	        int count = 0;
	        int countRepeat = 0;
	        int countUnique = 0;
	        for (String word : words) {
	            if (word.equals(previousWord)) {
	                count++;
	            } else {
	                if (!previousWord.isEmpty()) {	                	
	                    FrequencyList.add(previousWord  + "(" + count + ")");
	                    IntegerFrequencyList.add(count);
	                    if(count > 1) {
	                    	countRepeat++;
	                    }
	                }
	                previousWord = word;
	                count = 1;
	            }
	        }
	        FrequencyList.add(previousWord + "(" + count + ")");
	        IntegerFrequencyList.add(count);
	        if(count > 1) {
            	countRepeat++;
            }
	        for (String wordFreq : FrequencyList) {
	            System.out.println(wordFreq);
	        }
	        int maxCount = 0;
	        String mostUsedWord = "";
	        for (int i = 0; i < FrequencyList.size(); i++) {
	            int frequency = IntegerFrequencyList.get(i);
	            if (frequency > maxCount) {
	                maxCount = frequency;
	                mostUsedWord = FrequencyList.get(i).split("\\(")[0];
	            }
	        }	        
	        System.out.println();
	        System.out.println("Total words: " + countWords);
	        System.out.println("Number of Repeated words: " + countRepeat);
	        System.out.println("Number of Unique words: " + countUnique);
	        System.out.println("Most used word: " + mostUsedWord);      
	    }
	}




























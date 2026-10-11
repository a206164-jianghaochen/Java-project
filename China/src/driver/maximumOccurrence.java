package driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class maximumOccurrence {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputstring = sc.next();
    
		char maxOccurringChar = findMaxOccurringChar(inputstring);
         System.out.println(maxOccurringChar);
        }
	
	public static char findMaxOccurringChar(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Input string is null or empty");
        }

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        // Count the frequency of each character
        for (char c : str.toCharArray()) {
            if (charFrequencyMap.containsKey(c)) {
                charFrequencyMap.put(c, charFrequencyMap.get(c) + 1);
            } else {
                charFrequencyMap.put(c, 1);
            }
        }

        char maxChar = ' ';
        int maxCount = 0;

        // Find the character with the maximum frequency
        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxChar;
        
        
        
}
}

package driver;

import java.util.Scanner;

public class Significantpractice {
           public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
       String inputString = sc.next();
       
       char maxOccurringChar = findMaxOccurringChar(inputString);
       System.out.println("Maximum occurring character: " + maxOccurringChar);
       
       sc.close();
   }

   // Method to find the maximum occurring character in a string
   public static char findMaxOccurringChar(String str) {
       // Check if the input string is null or empty
       if (str == null || str.isEmpty()) {
           throw new IllegalArgumentException("Input string is null or empty");
       }

       // Array to store character frequencies (for 'a' to 'z')
       int[] charFrequency = new int[26]; // 'a' to 'z'

       // Convert the string to lowercase to handle case insensitivity
       String lowerCaseStr = str.toLowerCase();

       // Count the frequency of each character in the string
       for (char c : lowerCaseStr.toCharArray()) {
           if (c >= 'a' && c <= 'z') {
               charFrequency[c - 'a']++;
           }
       }

       // Variables to track the maximum occurring character and its count
       char maxChar = ' ';
       int maxCount = 0;

       // Find the character with the maximum frequency
       for (int i = 0; i < 26; i++) {
           if (charFrequency[i] > maxCount) {
               maxChar = (char) ('a' + i);
               maxCount = charFrequency[i];
           }
       }

       return maxChar;
   }
}
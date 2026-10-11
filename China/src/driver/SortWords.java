package driver;

import java.util.Arrays;
import java.util.Scanner;

public class SortWords {
     public static void main(String[] args) {
    	 
    	 Scanner sc = new Scanner(System.in);
    	 String inputString = sc.nextLine();
    	 String sortString = sortWords(inputString);
    	 System.out.println(sortString);
     }
     
     public static String sortWords(String str) {
    	 if(str == null || str.isEmpty()) {
    		 return str;
    	 }
    	 String[] words = str.split("\\s+");
    	 
    	 Arrays.sort(words);
    	 
    	 StringBuilder sortString = new StringBuilder();
    	 for(int i = 0; i < words.length; i++) {
    		 sortString.append(words[i]);
    		 if(i < words.length - 1) {
    			 sortString.append(" ");
    		 }
    	 }
    	 return sortString.toString();
     }
}

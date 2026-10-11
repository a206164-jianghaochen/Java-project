package smallPractise;

import java.util.HashSet;
import java.util.Set;

public class Practise02 {
       public static void main(String[] args) {
    	   Set<Teacher> uniqueSet = new HashSet<>();
    	   uniqueSet.add(new Teacher("John", "ShangHai", "T001"));
    	   uniqueSet.add(new Teacher("John", "ShangHai", "T001"));
    	   uniqueSet.add(new Teacher("John", "ShangHai", "T001"));
    	   uniqueSet.add(new Teacher("Doe", "ShenZhen", "T002"));
    	   for(Teacher uni: uniqueSet) {
    	   System.out.println(uni);
    	   }
    	     
       }
	
	
	
	
}

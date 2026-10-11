package dataStructure01;
import java.util.*;
public class ManageProvince {
         public static void main(String[] args) {
        	 HashSet<Integer> num = new HashSet<>();
        	 Random random = new Random();
        	 while(num.size() < 10) {       		 
        		 int number = random.nextInt(20)+1;
        		 num.add(number);
        	 }
        	 for(Integer n : num) {       		 
        		 System.out.println(n);
        	 }
        	 
        	 
        	 
         }
}

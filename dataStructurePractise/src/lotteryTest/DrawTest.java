package lotteryTest;

import java.util.ArrayList;
import java.util.Random;

public class DrawTest {
       public static void main(String[] args) {
    	   double[] proArray = {0.904, 0.09, 0.006};
    	   ArrayList<String> itemArr = new ArrayList<>();
    	   Random random = new Random();
    	   for(int i = 0; i < 10; i++) {
    		   double number = random.nextDouble();
    		   if(number <= proArray[0]) { 
    			   itemArr.add("3-star item");
    			   
    		   }else if(number > proArray[0] && number <= (proArray[0] + proArray[1])) {  
    			   itemArr.add("4-star item");
    		   }else {   			     
    			   itemArr.add("5-star item");
    		   } 		   
    	   }	
    	   if(itemArr.contains("4-star item")) {
    		     for(String item:itemArr) {
    		    	System.out.println(item);     		    	 
    		     }  		   
    	   }else if(!itemArr.contains("4-star item") && !itemArr.get(9).equals("5-star item")) {
    		      itemArr.set(9, "4-star item");
    		      for(String item:itemArr) {
      		    	System.out.println(item);     		    	 
      		     }  		      
    	   }else if(!itemArr.contains("4-star item") && itemArr.contains("5-star item") && !itemArr.get(9).equals("5-star item")) {
    		   itemArr.set(9, "4-star item");
    		   for(String item:itemArr) {
     		    	System.out.println(item);     		    	 
     		     }  		        		   
    	   }else if(!itemArr.contains("4-star item") && itemArr.contains("5-star item") && itemArr.get(9).equals("5-star item")) {
    		   itemArr.set(8, "4-star item");
    		   for(String item:itemArr) {
    		    	System.out.println(item);     		    	 
    		     }  		        	
    		   
    	   }
    	   
       }

}

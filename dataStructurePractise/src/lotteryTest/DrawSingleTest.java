package lotteryTest;

import java.util.ArrayList;
public class DrawSingleTest {
      public static void main(String[] args) {
    	  double[] proArray = {0.904, 0.09, 0.006};
    	  ArrayList<String> itemArr = new ArrayList<>();
    	  int count = 0;
    	  int ThreeCount = 0;
    	  int FourCount = 0;
    	  do {
    		  double number = Math.random();
    		  if(number <= proArray[0]) {
    			  itemArr.add("3-star item"); 
    			  System.out.println("3-star item");
    			  ThreeCount++;
    		  }else if(number > proArray[0] && number <= (proArray[0] + proArray[1])) {
    			  itemArr.add("4-star item");
    			  System.out.println("4-star item");
    			  FourCount++;
    		  }else {
    			  itemArr.add("5-star item");  	
    			  System.out.println("5-star item");
    		  }  
    		  count++;
    	  }while(!itemArr.contains("5-star item"));
    	  
    	  System.out.println("ccongratulation! You drawed " + count + " times to get a 5-star item.");
    	  System.out.println("The amount of 3-star item: " + ThreeCount);
    	  System.out.println("The amount of 4-star item: " + FourCount);
    	  
      }
}
